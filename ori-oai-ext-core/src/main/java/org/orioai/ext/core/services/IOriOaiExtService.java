/**
 * 
 */
package org.orioai.ext.core.services;

import java.util.Map;

import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;

/**
 * @author neuville
 *
 */
public interface IOriOaiExtService {

	public WSOperationBean execute(String wsId, String wsMethodId, Map<String, String> wsMethodParams)
								throws OriOaiExtException; 
	
}
