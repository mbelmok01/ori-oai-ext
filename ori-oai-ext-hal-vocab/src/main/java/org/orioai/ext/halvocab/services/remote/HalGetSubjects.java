package org.orioai.ext.halvocab.services.remote;

import java.util.ArrayList;
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
public class HalGetSubjects extends AbstractHalGetVocab {

	private final String opId = "getSubjects";

	// solr parameters
	private String url = "http://api-preprod.archives-ouvertes.fr/ref/domain";
	private String queryString = "*:*";
	private String idFieldName = "code_s";
	private String frLabelFieldName = "fr_domain_s";
	private String enLabelFieldName = "en_domain_s";
	private String sortFieldName = "fr_domain_s";
	
	private String parentIdFieldName = "parent_i";
	

	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);
		
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		
		// solr query
		List<String> otherFields = new ArrayList<String>();
		otherFields.add(parentIdFieldName);
		final List<SolrDocument> docs = solrSearch(url, queryString, idFieldName, frLabelFieldName, enLabelFieldName, sortFieldName, otherFields);
		
		// create and fill VDEX
		WSOperationBean toReturn = getWSOperationBeanFromSolr(docs, wsMethodParams, idFieldName, frLabelFieldName, enLabelFieldName);
		return toReturn;
	}
	
	@Override
	protected String getSolrDocumentIdValue(SolrDocument doc, String idFieldName) {
		return super.getSolrDocumentIdValue(doc, idFieldName).replaceAll("\\.", ":").replaceAll("-", "_").toUpperCase();
	}
	
	
	private SolrDocument getParent(SolrDocument doc) throws MethodExecutionException {
		String parentId = this.getSolrDocumentFieldValue(doc, parentIdFieldName);
		if (parentId!=null && !"".equals(parentId.trim())) {
			
			List<SolrDocument> docs = solrSearch(url, "docid:"+parentId, idFieldName, frLabelFieldName, enLabelFieldName, sortFieldName);
			if (docs!=null && !docs.isEmpty()) {
				return docs.get(0);
			}
		}
		
		return null;
	}
	
	
	@Override
	protected String getSolrDocumentFrLabelValue(SolrDocument doc, String fieldName) {
		String fullFrValue = super.getSolrDocumentFrLabelValue(doc, fieldName);
		String result = fullFrValue;
		
		try {
			SolrDocument parent = getParent(doc);
			if (parent!=null) {
				String parentFrValue = super.getSolrDocumentFrLabelValue(parent, fieldName);
				result = fullFrValue.replaceAll(parentFrValue+"/", "").trim();
			}
		}
		catch(MethodExecutionException e) {
			log.error("Error while executing : "+opId, e);
		}
		
		return result;
	}
	
	
	@Override
	protected String getSolrDocumentEnLabelValue(SolrDocument doc, String fieldName) {
		String fullEnValue = super.getSolrDocumentEnLabelValue(doc, fieldName);
		String result = fullEnValue;
		
		try {
			SolrDocument parent = getParent(doc);
			if (parent!=null) {
				String parentEnValue = super.getSolrDocumentEnLabelValue(parent, fieldName);
				result = fullEnValue.replaceAll(parentEnValue+"/", "").trim();
			}
		}
		catch(MethodExecutionException e) {
			log.error("Error while executing : "+opId, e);
		}
		
		return result;
	}

	@Override
	public String getOpId() {
		return opId;
	}

}
