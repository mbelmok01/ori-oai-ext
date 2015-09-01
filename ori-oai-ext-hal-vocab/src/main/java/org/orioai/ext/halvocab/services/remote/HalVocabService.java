/**
 * 
 */
package org.orioai.ext.halvocab.services.remote;

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
import org.springframework.stereotype.Service;

/**
 * @author neuville
 *
 */
@Service
//@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
@Qualifier("halvocab")
@NotMock
public class HalVocabService implements IWebService {

	private Log4jLoggerAdapter log = 
		(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
	
	//authorized parameters names
	public static final String VOCAB_NAME = "vocabName";
	public static final String VOCAB_ID = "vocabId";
	public static final String TERM_KEY = "termKey";
	public static final String TERM_LIBEL = "termLibel";
	public static final String GEN_LANGSTRING_ID = "genLangstringId";	
//	public static final String TERMS_SET_ARG = "termsSetArg";
//	public static final String LANG_ARG_NAME = "langArgName";
//	public static final String ADD_ARG_NAMES = "addArgNames";
//	public static final String ADD_ARG_VALUES = "addArgValues";
//	public static final String SPECIAL_ARG_NAME = "specialArgName";
//	public static final String PREPROCESS_OP = "preProcessOp";
//	public static final String PREPROCESS_OP_ARGS = "preProcessOpArgs";
	// VDEX constants
	public static final String VDEX_ORDER_SIGNIFICANT = "false";
	public static final String VDEX_PROFILE_TYPE = "flatTokenTerms";
	public static final String VDEX_UPPEST_LANGSTRING_LANG = "fr";

	@Autowired
	@Qualifier("halvocab")
	private IWSOperation[] halVocabOperations;
	
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
		for(IWSOperation op : halVocabOperations) {
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
		return "halvocab";
	}
}
