package org.orioai.ext.core.services;

import java.util.Map;

import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;

public interface IWSOperation {

	public String getOpId();

	public WSOperationBean execute(Map<String, String> wsMethodParams) throws MethodExecutionException;
}