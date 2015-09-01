/**
 * 
 */
package org.orioai.ext.hal.services.remote;

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
 * @author neuville
 *
 */
@Service
//@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
@Qualifier("hal")
@NotMock
public class HalWebService implements IWebService {

	private Log4jLoggerAdapter log = 
		(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
	
	private @Value("${hal.wsId}") String wsId;
	
	private @Value("${hal.ContribFirstName}") String halContribFirstName;
	
	private @Value("${hal.ContribLastName}") String halContribLastName;
	
	private @Value("${hal.ContribEmail}") String halContribEmail;

	//authorized parameters names
	public static final String XML_CONTENT = "xmlContent";
	public static final String TYPE_PUBLI = "typePubli";
	public static final String DOMAIN = "domain";
	public static final String FULL_TEXT_NAME = "fullTextName";
	public static final String FULL_TEXT_FORMAT = "fullTextFormat";	
	public static final String FULL_TEXT_CONTENT_BASE_64 = "fullTextContentBase64";
	public static final String FULL_TEXT_URI = "fullTextUri";
	public static final String HAL_USER_ID = "halUserId";
	public static final String HAL_USER_PASSWORD = "halUserPassword";
	public static final String HAL_CONTRIB_LASTNAME = "halContribLastName";
	public static final String HAL_CONTRIB_FIRSTNAME = "halContribFirstName";
	public static final String HAL_CONTRIB_EMAIL = "halContribEmail";
	public static final String ENVOI_HAL = "envoiHal";
	//authorized values for parameter envoiHal
	public static final String ENVOI_HAL_UNAVAILABLE_FILE = "unavailable_file";
	public static final String ENVOI_HAL_FILE_NO_HAL= "file_no_hal";
	public static final String ENVOI_HAL_FILE_HAL= "file_hal";
	public static final String ENVOI_HAL_NO_FILE_HAL= "no_file_hal";
	public static final String ENVOI_HAL_LINK_HAL= "link_hal";
	public static final String ENVOI_HAL_LINK_FILE_HAL= "link_file_hal";

	@Autowired
	@Qualifier("hal")
	private IWSOperation[] halOperations;
	
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
		for(IWSOperation op : halOperations) {
			String opId = op.getOpId();
			if(opId != null && opId.equals(wsMethodId)) {
				opExists = true;
				if(log.isInfoEnabled()) {
					log.info("Ok, method found.");
					log.info("Let's try to execute it...");
				}
				wsMethodParams.put(HAL_CONTRIB_FIRSTNAME, halContribFirstName);
				wsMethodParams.put(HAL_CONTRIB_LASTNAME, halContribLastName);
				wsMethodParams.put(HAL_CONTRIB_EMAIL, halContribEmail);
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
