package org.orioai.ext.halvocab.services.remote;

import java.util.Map;

import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("halvocab")
@NotMock
public class HalGetLabsCountries extends AbstractHalGetLabVocab {

	private final String opId = "getLabsCountries";	
	
	protected String frLabelFieldName = "country_s";
	
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		return commonExecute(wsMethodParams, frLabelFieldName);
	}

	@Override
	public String getOpId() {
		return opId;
	}

}
