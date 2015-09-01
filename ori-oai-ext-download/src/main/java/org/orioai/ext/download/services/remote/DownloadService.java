/**
 * 
 */
package org.orioai.ext.download.services.remote;

import java.util.Map;

import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.IWSOperation;
import org.orioai.ext.core.services.IWebService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.orioai.ws.ext.exceptions.UnknownMethodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author neuville
 *
 */
@Service
@Qualifier("download")
@NotMock
public class DownloadService implements IWebService {

	private @Value("${download.ws_id}") String wsId;
	
	@Autowired
	@Qualifier("download")
	private IWSOperation[] dlOperations;
	
	private WSOperationBean result;
	
	
	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWebService#execute(java.lang.String, java.util.Map)
	 */
	@Override
	public WSOperationBean execute(String wsMethodId,	Map<String, String> wsMethodParams) 
																			throws OriOaiExtException {
		boolean opExists = false;
		for(IWSOperation op : dlOperations) {
			String opId = op.getOpId(); 
			if(opId != null && opId.equals(wsMethodId)) {
				opExists = true;
				result = op.execute(wsMethodParams);
			}
		}
		if(!opExists)
			throw new UnknownMethodException(wsMethodId);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWebService#getWsId()
	 */
	@Override
	public String getWsId() {
		return wsId;
	}

}
