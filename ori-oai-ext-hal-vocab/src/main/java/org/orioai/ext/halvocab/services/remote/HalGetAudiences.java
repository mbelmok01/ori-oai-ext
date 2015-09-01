package org.orioai.ext.halvocab.services.remote;

import java.util.List;
import java.util.Map;

import org.apache.solr.common.SolrDocument;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("halvocab")
@NotMock
public class HalGetAudiences extends AbstractHalGetVocab {
	private final String opId = "getAudiences";

	// solr parameters
	private String url = "http://api-preprod.archives-ouvertes.fr/ref/metadatalist";
	private String queryString = "metaName_s:audience";
	private String idFieldName = "metaValue_s";
	private String frLabelFieldName = "fr_metaLabel_s";
	private String enLabelFieldName = "en_metaLabel_s";
	private String sortFieldName = "metaValue_s";

	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);
		
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		
		// solr query
		final List<SolrDocument> docs = solrSearch(url, queryString, idFieldName, frLabelFieldName, enLabelFieldName, sortFieldName);
		
		// create and fill VDEX
		WSOperationBean toReturn = getWSOperationBeanFromSolr(docs, wsMethodParams, idFieldName, frLabelFieldName, enLabelFieldName);
		return toReturn;
	}

	@Override
	public String getOpId() {
		return opId;
	}
}
