package org.orioai.ext.halvocab.services.remote;

import java.util.List;
import java.util.Map;

import org.apache.solr.common.SolrDocument;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;

public abstract class AbstractHalGetLabVocab extends AbstractHalGetVocab {

	// solr parameters
	protected String url = "http://api-preprod.archives-ouvertes.fr/ref/structure";
	//protected String queryString = "valid_s:(VALID OR OLD)";
	protected String queryString = "(type_s:laboratory AND valid_s:(VALID OR OLD) AND acronym_s:LAMIH)";
	protected String idFieldName = "docid";
	protected String enLabelFieldName = null;
	protected String sortFieldName = null;
	protected List<String> otherFields = null;

	
	protected WSOperationBean commonExecute(Map<String, String> wsMethodParams, String frLabelFieldName)
			throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);
		
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		
		// solr query
		final List<SolrDocument> docs = solrSearch(url, queryString, idFieldName, frLabelFieldName, enLabelFieldName, sortFieldName, otherFields);
		
		// create and fill VDEX
		WSOperationBean toReturn = getWSOperationBeanFromSolr(docs, wsMethodParams, idFieldName, frLabelFieldName, enLabelFieldName);
		return toReturn;
	}
	
	@Override
	protected String getSolrDocumentIdValue(SolrDocument doc, String idFieldName) {
		return "hal-"+super.getSolrDocumentIdValue(doc, idFieldName);
	}
}
