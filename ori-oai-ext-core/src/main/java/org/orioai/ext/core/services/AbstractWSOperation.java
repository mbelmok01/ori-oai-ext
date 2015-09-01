/**
 *
 */
package org.orioai.ext.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.orioai.ws.ext.exceptions.MethodParametersException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;

/**
 * @author neuville
 *
 */
public abstract class AbstractWSOperation implements IWSOperation {
    
    protected Log4jLoggerAdapter log =
            (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
    
    protected String opId;
    
    /* (non-Javadoc)
    * @see org.orioai.ext.core.services.IWSOperation#execute(java.util.Map)
    */
    @Override
    public abstract WSOperationBean execute(Map<String, String> wsMethodParams)
            throws MethodExecutionException ;
    
    /* (non-Javadoc)
    * @see org.orioai.ext.core.services.IWSOperation#getOpId()
    */
    @Override
    public abstract String getOpId();
    
    /**
     *
     * @param opId
     * @param parametersNames
     * @param wsMethodParams
     * @return
     * @throws MethodParametersException
     */
    protected boolean checkParameters(String opId, List<String> parametersNames, Map<String, String> wsMethodParams) throws MethodParametersException {
        boolean paramsOk = false;
        
        List<String> paramsNames = new ArrayList<String>(parametersNames);
        
        for(String pName : parametersNames) {
            if(wsMethodParams.containsKey(pName) && wsMethodParams.get(pName) != null) {
                paramsNames.remove(pName);
                if(log.isDebugEnabled())
                    log.debug("Method \""+opId+"\" - Parameter \""+pName+"\" OK");
            }
        }
        if(!paramsNames.isEmpty()) {
            StringBuilder illParams = new StringBuilder("");
            for(String pName : paramsNames)
                illParams.append(", "+pName);
            throw new MethodParametersException(opId , illParams.substring(2));
        } else {
            paramsOk = true;
        }
        return paramsOk;
    }
    
    protected String getFaultCodeFromFaultString(String faultString) {
        if (faultString!=null) {
            faultString = faultString.replaceAll("é", "e").replaceAll("è", "e").replaceAll(" ", "_").replaceAll("'", "_").replaceAll("\\(", "_").replaceAll("\\)", "_").replaceAll("\\.", "_").replaceAll(";", "_").toLowerCase();
            while (faultString.indexOf("__")!=-1) {
                faultString = faultString.replaceAll("__", "_");
            }
            return faultString;
        }
        else {
            return "";
        }
    }
}
