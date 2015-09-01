/**
 * 
 */
package org.orioai.ext.core.services;

import java.util.Map;

import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.orioai.ws.ext.exceptions.UnknownServiceException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author neuville
 *
 */
@Service
@NotMock
public class OriOaiExtService implements IOriOaiExtService {

	private Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());

	@Autowired
	private IWebService[] webServices;
	
	private WSOperationBean result;
	
	//public static final String USE_DOWNLOAD_SERVICE = "useDownloadService";
	
	public WSOperationBean getResult() {
		return result;
	}

	public void setResult(WSOperationBean wsOpBean) {
		this.result = wsOpBean;
	}

	/* (non-Javadoc)
	 * @see org.orioai.ws.ext.OriOaiExtServiceInterface#execute(java.lang.String, java.lang.String, java.util.Map)
	 */
	@Override
	public WSOperationBean execute(String wsId, String wsMethodId, Map<String, String> wsMethodParams) 
																					throws OriOaiExtException {
		result = null;
		boolean serviceExists = false;
		log.info("Trying to find service\"" + wsId + "\" ...");		
		for(IWebService ws : webServices) {
			if(ws.getWsId().equals(wsId)) {
				serviceExists = true;
				log.info("Ok, service found.");
				result = ws.execute(wsMethodId, wsMethodParams);
			}
		}
		if(!serviceExists)
			throw new UnknownServiceException(wsId);
		return result;
	}
}
