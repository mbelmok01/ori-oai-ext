/**
 * 
 */
package org.orioai.ext;

import java.util.Map;

import org.orioai.ws.ext.AbstractOriOaiExtServiceClient;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;

/**
 * @author neuville
 *
 */
public class OriExtService extends AbstractOriOaiExtServiceClient {

	/**
	 * 
	 * @param wsId
	 * @param wsMethod
	 * @param args
	 * @return
	 */
	public Map<String, String> invokeWSOperation(String wsId, String wsMethod, 
																					Map<String, String> args) throws OriOaiExtException {
		WSOperationBean toSend = new WSOperationBean();
		WSOperationBean toReturn = new WSOperationBean();
		toSend.putAll(args);
		toReturn = super.invoke(wsId, wsMethod, toSend);
		return toReturn;
	}
}
