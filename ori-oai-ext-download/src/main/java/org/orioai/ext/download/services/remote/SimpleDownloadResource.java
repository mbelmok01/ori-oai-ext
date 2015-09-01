/**
 * 
 */
package org.orioai.ext.download.services.remote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.AbstractWSOperation;
import org.orioai.ext.core.utils.EncodingUtils;
import org.orioai.ext.download.beans.UrlCredentialsMappingsHolder;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * This service allows to download a resource exposed by a distant 
 * service.
 * </p>
 * <p>
 * It performs a simple GET request and manages simple (basic) HTTP
 * authentication if a starting segment of the resource URL is mapped
 * to credentials in  <code>credentials.properties</code>
 * </p>
 * 
 * @author neuville
 *
 */
@Service
@Qualifier("download")
@NotMock
public class SimpleDownloadResource extends AbstractWSOperation {

	private @Value("${download.simple_dl_op_id}") String opId;

	@Autowired
	private UrlCredentialsMappingsHolder urlCredMappingsHolder;

	private enum ParameterName {
		FULL_TEXT_URI("fullTextUri");

		public final String value;

		ParameterName(String value) {
			this.value = value;
		}
		public static List<String> getValues() {
			List<String> toReturn = new ArrayList<String>();
			for(ParameterName pName : ParameterName.values()) {
				toReturn.add(pName.value);
			}
			return toReturn;
		}
	}

	private HttpClient httpClient;
	
	private RestTemplate restTemplate;
	
	private SimpleDownloadResource() {}

	public static SimpleDownloadResource createInstance() {
		SimpleDownloadResource dlRs = new SimpleDownloadResource();
		HttpClientParams param = new HttpClientParams();		
		dlRs.httpClient = new HttpClient(param,
				new MultiThreadedHttpConnectionManager());
		dlRs.restTemplate = 
				new RestTemplate(new CommonsClientHttpRequestFactory(dlRs.httpClient));
		return dlRs;
	}

	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWSOperation#execute(java.util.Map)
	 */
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams) 
	throws MethodExecutionException {
		// check incoming parameters
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		// do we need basic authentication ?
		StringBuilder base64Result = new StringBuilder();
		String[] resUriTab = wsMethodParams.get(ParameterName.FULL_TEXT_URI.value).split("\\|");
		for(String resUri : resUriTab) {
			for(Entry<String, String> entry : urlCredMappingsHolder.getMappings().entrySet()) {
				if(resUri.startsWith(entry.getKey())) {
					//String host = resUri.substring(0, 8).split("/", 2)[0];
					httpClient.getParams().setAuthenticationPreemptive(true);
					String[] credentials = entry.getValue().split("\\s\\|\\|\\s");
					httpClient.getState().setCredentials(AuthScope.ANY,
							new UsernamePasswordCredentials(credentials[0], credentials[1]));
				}
			}
			// let's do the request
			ResponseEntity<Resource> resp = 
				restTemplate.getForEntity(resUri, Resource.class);
			//and deal with response
			try {
				base64Result.append(EncodingUtils.base64encode(resp.getBody().getInputStream()));
			} catch(IOException e) {
				throw new MethodExecutionException(opId, e);
			}
			base64Result.append("|");
		}
		WSOperationBean toReturn = new WSOperationBean();
		toReturn.put("fullTextContentBase64", base64Result.toString());

		return toReturn;
	}

	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWSOperation#getOpId()
	 */
	@Override
	public String getOpId() {
		return opId;
	}
}
