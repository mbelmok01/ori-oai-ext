/**
 * 
 */
package org.orioai.ext.apogee.services.remote;

import java.util.Map;

import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.IWSOperation;
import org.orioai.ext.core.services.IWebService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.orioai.ws.ext.exceptions.UnknownMethodException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Yohan Colmant
 *
 */
@Service
//@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
@Qualifier("apogee")
@NotMock
public class ApogeeWebService implements IWebService {

	private Log4jLoggerAdapter log = 
		(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
	
	private @Value("${apogee.wsId}") String wsId;

	//authorized parameters names
	public static final String USER_ID = "apogeeUserId";
	public static final String WS_USER = "apogeeWsUser";
	public static final String WS_PASSWORD = "apogeeWsPassword";
	public static final String TEF_CREATOR = "apogeeTefCreator";
	public static final String TEF_SUDOC_ETAB_ID = "apogeeTefSudocEtabId";
	public static final String TEF_XML_CONTENT = "xmlContent";
	
	public static final String USER_ATTRIBUTE_PREFIX = "userAttribute_";
	
	
	

	@Autowired
	@Qualifier("apogee")
	private IWSOperation[] apogeeOperations;
	
	private WSOperationBean result;
	
	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWebService#execute(java.lang.String, java.util.Map)
	 */
	@Override
	public WSOperationBean execute(String wsMethodId, Map<String, String> wsMethodParams) 
																		throws OriOaiExtException {
		boolean opExists = false;
		if(log.isInfoEnabled())
			log.info("Trying to find method \"" + wsMethodId+ "\" ...");
		for(IWSOperation op : apogeeOperations) {
			String opId = op.getOpId();
			if(opId != null && opId.equals(wsMethodId)) {
				opExists = true;
				if(log.isInfoEnabled()) {
					log.info("Ok, method found.");
					log.info("Let's try to execute it...");
				}
				result = op.execute(wsMethodParams);
			}
		}
		if(!opExists)
			throw new UnknownMethodException(wsMethodId);
		return result;
	}

	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWebService#getName()
	 */
	@Override
	public String getWsId() {
		return wsId;
	}
}
