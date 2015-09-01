/**
 * 
 */
package org.orioai.ext.core.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.orioai.ext.core.services.OriOaiExtService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.w3c.dom.Element;

/**
 * @author neuville
 *
 */
@Aspect
public class OriOaiExtServiceExceptionHandler {
	
	private WSOperationBean emergencyBean = null;

	@Pointcut("CoreArchitecture.inServiceLayer() && CoreArchitecture.coreBusinessService()")
	public void inExecute() {}
	
	@AfterThrowing(
			pointcut="inExecute()",
			throwing="ex"
	)
	public void treatOriOaiExtException(Exception ex) {
		emergencyBean = new WSOperationBean();
		emergencyBean.put("exceptionOccured", "true");
		emergencyBean.put("faultMessage",ex.getLocalizedMessage());		
		if(ex instanceof OriOaiExtException) {
			OriOaiExtException oriEx = (OriOaiExtException) ex;
			emergencyBean.put("faultActor", oriEx.getFaultActor());
		    emergencyBean.put("faultNode", oriEx.getFaultNode());
		    emergencyBean.put("faultString", oriEx.getFaultString());
		    emergencyBean.put("faultCode", oriEx.getFaultCode().toString());
		    emergencyBean.put("opId", oriEx.getOpId());
		    int i = 0;
		    for(Element el : oriEx.getFaultDetails()) {
		    	emergencyBean.put("faultDetail-" + String.valueOf(i) , el.getTextContent());
		    	i++;
		    }	
		}	
		else {
			treatOtherExceptions(ex);
		}
	}
	
	private void treatOtherExceptions(Exception excp) {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		for(StackTraceElement el : excp.getStackTrace()) {
			builder.append(el.toString());
			builder.append("\n");
		}
		emergencyBean.put("faultDetail-0", builder.toString());
	}
	
	@After("inExecute()")
	public void substituteReturn(JoinPoint jp) {
		OriOaiExtService targetObj = (OriOaiExtService)jp.getTarget();
		targetObj.setResult(emergencyBean);
	}
}
