package org.orioai.ext.core.services;

import java.util.Map;

import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;

public interface IWebService {

	public String getWsId();
	
	public WSOperationBean execute(String wsMethodId, Map<String, String> wsMethodParams) 
																			throws OriOaiExtException;
	
}
