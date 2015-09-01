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
public class HalGetTypesPubli extends AbstractHalGetVocab {

	private final String opId = "getTypesPubli";

	// solr parameters
	private String url = "http://api-preprod.archives-ouvertes.fr/ref/doctype";
	private String queryString = "*:*";
	private String idFieldName = "docid";
	private String frLabelFieldName = "fr_label";
	private String enLabelFieldName = "en_label";
	private String sortFieldName = null;

	/*String soutPrefix = "A";
	System.out.println(soutPrefix+"1");
	String url = "http://api-preprod.archives-ouvertes.fr/ref/doctype";
	System.out.println(soutPrefix+"2");
	SolrServer server = new HttpSolrServer(url, null, new XMLResponseParser());
	System.out.println(soutPrefix+"3");
	
	SolrQuery query = new SolrQuery();
    query.setQuery( "*:*" );
	
    System.out.println(soutPrefix+"4");
    
    try {
	    QueryResponse rsp = server.query( query );
	    System.out.println(soutPrefix+"5");
	    
	    docs = rsp.getResults();
		System.out.println(soutPrefix+" docs="+docs);
    }
    catch(SolrServerException e) {
    	throw new MethodExecutionException(e);
    }*/
	

	/*
	
	soutPrefix = "B";
	try {
		System.out.println(soutPrefix+"1");
		String url = "http://api-preprod.archives-ouvertes.fr/ref";
		System.out.println(soutPrefix+"2");
		CloudSolrServer server = new CloudSolrServer(url);
		server.setDefaultCollection("doctype");
		System.out.println(soutPrefix+"3");
		
		SolrQuery query = new SolrQuery();
	    query.setQuery( "*:*" );
		
	    System.out.println(soutPrefix+"4");
	    
	    QueryResponse rsp = server.query( query );
	    System.out.println(soutPrefix+"5");
	    
	    SolrDocumentList docs = rsp.getResults();
		System.out.println(soutPrefix+" docs="+docs);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	catch(Error e) {
		e.printStackTrace();
	}
	
	*/
	
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
