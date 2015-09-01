 /**
  *
  */
package org.orioai.ext.physalis.services.remote;

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
@Qualifier("physalis")
@NotMock
public class PhysalisWebService implements IWebService {
    
    private Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
    
    private @Value("${physalis.wsId}") String wsId;
    
    //authorized parameters names
    public static final String USER_ID = "physalisUserId";
    public static final String WS_USER = "physalisWsUser";
    public static final String WS_PASSWORD = "physalisWsPassword";
    public static final String TEF_CREATOR = "physalisTefCreator";
    public static final String TEF_SUDOC_ETAB_ID = "physalisTefSudocEtabId";
    public static final String TEF_XML_CONTENT = "xmlContent";
    public static final String USER_ATTRIBUTE_PREFIX = "userAttribute_";
    
    public static final String URL = "database_url";
    public static final String USER = "database_user";
    public static final String PASSWORD = "database_password";
    
    
    @Autowired
    @Qualifier("physalis")
    private IWSOperation[] physalisOperations;
    
    private WSOperationBean result;
    
    /* (non-Javadoc)
    * @see org.orioai.ext.services.remote.IWebService#execute(java.lang.String, java.util.Map)
    */
    @Override
    public WSOperationBean execute(String wsMethodId, Map<String, String> wsMethodParams) throws OriOaiExtException {
        
        boolean opExists = false;
        if(log.isInfoEnabled())
            log.info("Trying to find method \"" + wsMethodId+ "\" ...");
        for(IWSOperation op : physalisOperations) {
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
        if(!opExists){
            throw new UnknownMethodException(wsMethodId);
        }
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
