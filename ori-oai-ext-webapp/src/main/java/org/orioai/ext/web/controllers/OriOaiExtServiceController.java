/**
 * 
 */
package org.orioai.ext.web.controllers;

import java.util.HashMap;

import org.esupportail.commons.services.exceptionHandling.ExceptionUtils;
import org.orioai.ext.core.services.IOriOaiExtService;
import org.orioai.ext.core.services.OriOaiExtService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author neuville
 *
 */
@Controller
//@RequestMapping("/*/")
public class OriOaiExtServiceController {

	private Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());

	@Autowired
	private IOriOaiExtService extService;

	@SuppressWarnings("finally")
	@RequestMapping(value="{wsId}/{wsMethodId}", method=RequestMethod.POST)
	public ModelAndView execute(@PathVariable String wsId, @PathVariable String wsMethodId, 
															@RequestBody WSOperationBean wsMethodParams) {
		WSOperationBean result = null;
		log.info("Trying to execute method \"" + wsMethodId + "\" for \"" + wsId + "\" distant service...");
		try {
			result = extService.execute(wsId, wsMethodId, wsMethodParams);				
		} catch (MethodExecutionException e) {
			if(log.isDebugEnabled())
				log.debug("Ouch ! Execution of method \""+wsMethodId+"\" failed for service \"" +
						wsId + "\" : " + e.getMessage());
			if (!e.isSilent()) {
				ExceptionUtils.catchException(e);
			}
		} catch (Exception e) {
			if(log.isDebugEnabled())
				log.debug("Ouch ! Execution of method \""+wsMethodId+"\" failed for service \"" +
						wsId + "\" : " + e.getMessage());
			ExceptionUtils.catchException(e);
		} finally {
			// we make sure we always return something intelligible to the client
			if(log.isInfoEnabled())
				log.info("Ok, request has been processed, let's return a " +
						"serialized WSOperationBean.");
			result = (result == null) ? ((OriOaiExtService) extService).getResult() : result;
			ModelAndView mav = new ModelAndView("wsOpResultView", BindingResult.MODEL_KEY_PREFIX +
											"wsOpResult", result);
			return mav;
		}
	}
	
	/**
	 * For testing purpose only
	 * 
	 * @param wsId
	 * @param wsMethodId
	 * @return
	 */
	//@RequestMapping(value="{wsId}/{wsMethodId}/", method=RequestMethod.GET)
	@RequestMapping(value="{wsId}/{wsMethodId}", method=RequestMethod.GET)
	public ModelAndView status(@PathVariable String wsId, @PathVariable String wsMethodId) {
		WSOperationBean result = null;
		
		log.info("Trying to execute method \"" + wsMethodId + "\" for \"" + wsId + "\" distant service...");
		try {
			result = extService.execute(wsId, wsMethodId, new HashMap<String, String>());				
		} catch (OriOaiExtException e) {
			ExceptionUtils.catchException(e);
			if(log.isDebugEnabled())
				log.debug("Ouch ! Execution of method \""+wsMethodId+"\" failed for service \"" +
						wsId + "\" : " + e.getMessage());
		}
		ModelAndView mav = new ModelAndView("wsOpResultView", BindingResult.MODEL_KEY_PREFIX +
											"wsOpResult", result);
		return mav;
	}
	
}
