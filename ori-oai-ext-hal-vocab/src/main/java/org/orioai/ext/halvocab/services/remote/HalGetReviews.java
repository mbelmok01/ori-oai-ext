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
public class HalGetReviews extends AbstractHalGetVocab {

	private final String opId = "getReviews";

	// solr parameters
	private String url = "http://api-preprod.archives-ouvertes.fr/ref/journal";
	private String queryString = "*:*";
	private String idFieldName = "issn_s,docid";
	private String frLabelFieldName = "title_s";
	private String enLabelFieldName = null;
	private String sortFieldName = "title_s";

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
	/*
	protected String getSolrDocumentIdValue(SolrDocument doc, String idFieldName) {
		Object idObject = doc.getFieldValue(idFieldName);
		String idValue = null;
		if (idObject!=null) {
			idValue = idObject.toString();
		}
		
		// get issn in label
		String labelFullValue = super.getSolrDocumentLabelFrValue(doc, frLabelFieldName);
		String[] stringElts = labelFullValue.split("\\[");
		
		String issn = null;
		for (int i=0; issn==null && i<stringElts.length; i++) {
			String elt = stringElts[i].trim();
			if (elt.startsWith("ISSN:")) {
				issn = elt.replaceAll("ISSN:", "").replaceAll("]", "").trim();
			}
		}
		
		if (issn!=null) {
			idValue = issn;
		}
		
		return idValue;
	}
	
	protected String getSolrDocumentLabelFrValue(SolrDocument doc, String frLabelFieldName) {
		String labelFullValue = super.getSolrDocumentLabelFrValue(doc, frLabelFieldName);
		String[] stringElts = labelFullValue.split("\\[");
		
		String label = stringElts[0].trim();
		return label;
	}
	
	protected String getSolrDocumentLabelEnValue(SolrDocument doc, String enLabelFieldName) {
		return null;
	}*/

}
