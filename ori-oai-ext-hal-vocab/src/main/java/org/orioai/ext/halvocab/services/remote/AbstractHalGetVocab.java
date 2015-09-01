package org.orioai.ext.halvocab.services.remote;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.stream.XMLStreamException;

import org.apache.axis.AxisFault;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.codehaus.stax2.XMLOutputFactory2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.orioai.ext.hal.services.remote.AbstractHalOperation;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;

import com.ctc.wstx.stax.WstxOutputFactory;

public abstract class AbstractHalGetVocab extends AbstractHalOperation {

	private final String refWsUrl = "http://hal.archives-ouvertes.fr/ws/ref.php";
	//private final String refWsUrl = "http://paol.ccsd.cnrs.fr/ws/ref.php";
	
	private static final int SOLR_PAGES_SIZE = 10000;
	
	
	

	protected enum ParameterName {
		VOCAB_NAME(HalVocabService.VOCAB_NAME), 
		VOCAB_ID(HalVocabService.VOCAB_ID);

		public final String value;

		ParameterName(String value) {
			this.value = value;
		}
		public static List<String> getValues() {
			List<String> toReturn = new ArrayList<String>();
			for(ParameterName pName : ParameterName.values()) {
				toReturn.add(pName.value);
			}
			return toReturn;
		}
	}

	protected interface HalOpExecuter {
		public Object exec() throws RemoteException;
	}

	
	protected String treatLabel(String label) {
		String[] accentedChars =
				new String[] {"à", "â", "ä", "é", "è", "ê", "ë", "î", "ï", "ô", "ö", "ù", "û", "ü"};
		String[] unAccentedChars =
				new String[] {"a", "a", "a", "e", "e", "e", "e", "i", "i", "o", "o", "u", "u", "u"};
		String[] arabicNumerals =
				new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20"};
		String[] romanNumerals =
				new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
				"XIV", "XV", "XVI", "XVII", "XVIII", "IXX", "XX"};
		String treatedLabel = StringUtils.trimToEmpty(label);
		treatedLabel = StringUtils.replaceEachRepeatedly(label, accentedChars, unAccentedChars);
		treatedLabel = StringUtils.lowerCase(treatedLabel);
		treatedLabel = StringUtils.replaceEachRepeatedly(treatedLabel, arabicNumerals, romanNumerals);
		return treatedLabel;
	}
	
	
	protected Object getValueFromHal(int maxTries, HalOpExecuter executer) throws RemoteException {
		Object toReturn = null;
		int tries = 0;
		do {
			boolean success = true;
			try {
				toReturn = executer.exec();
			} catch (AxisFault fault) {
				log.warn(fault.dumpToString());
				if (!StringUtils.containsIgnoreCase(fault.getFaultString(), "invalid XML character")) {
					success = false;
					tries++;
				}
			}
			if (success) break;
			if (tries == maxTries) {
				log.warn("Too many errors... Giving up !");
				toReturn = null;
				break;
			}
		} while (true);
		return toReturn;
	}

	protected ExecutorService pool;

	protected interface WriteVdexTerm {
		public void exec(XMLOutputFactory2 xof);
	}

	private WstxOutputFactory xof;

	protected final List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();

	protected Remote initHalBindingService() throws MethodExecutionException {
		return super.initHalBindingService("ref", refWsUrl);
	}
	
	protected ConcurrentLinkedQueue<ByteArrayOutputStream> outputsList = new ConcurrentLinkedQueue<ByteArrayOutputStream>();
	
	protected String produceVdex(WriteVdexTerm writeVdexTerm, WSOperationBean wsMethodParams)
			throws MethodExecutionException {
		String vdex = "";
		xof = new WstxOutputFactory();
		xof.configureForSpeed();
		xof.getConfig().doValidateStructure(true);
		XMLStreamWriter2 xtw = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		pool = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() * 4);
		try {
			//pin = new PipedInputStream(pout);
			xtw = (XMLStreamWriter2) xof.createXMLStreamWriter(out);
			// let's write some xml
			xtw.writeStartDocument();
			// root element
			xtw.writeStartElement("vdex:vdex");
			xtw.writeNamespace("vdex", "http://www.imsglobal.org/xsd/imsvdex_v1p0");
			xtw.writeAttribute("orderSignificant", HalVocabService.VDEX_ORDER_SIGNIFICANT);
			xtw.writeAttribute("profileType", HalVocabService.VDEX_PROFILE_TYPE);
			// vdex:vocabName
			xtw.writeStartElement("vdex:vocabName");
			xtw.writeStartElement("vdex:langstring");
			xtw.writeAttribute("language", "fr");
			xtw.writeCharacters(wsMethodParams.get(HalVocabService.VOCAB_NAME));
			xtw.writeEndElement();
			xtw.writeEndElement();
			// vdex:vocabIdentifier
			xtw.writeStartElement("vdex:vocabIdentifier");
			xtw.writeAttribute("isRegistered", "false");
			xtw.writeCharacters(wsMethodParams.get(HalVocabService.VOCAB_ID));
			xtw.writeEndElement();
			xtw.flush();

			// writing terms is specific to each HAL operation
			writeVdexTerm.exec(xof);
			pool.invokeAll(tasks);

			// deal with the whole vdex tree
			for (ByteArrayOutputStream curOut : outputsList)
				curOut.writeTo(out);

			//end of root element
			xtw.writeEndElement();
			// end of vocab
			xtw.writeEndDocument();
		} catch (XMLStreamException e) {
			throw new MethodExecutionException(e);
		} catch (InterruptedException e) {
			throw new MethodExecutionException(e);
		} catch (IOException e) {
			throw new MethodExecutionException(e);
		} finally {
			pool.shutdownNow();
			try {
				out.close();
				vdex = out.toString();
				
				if (wsMethodParams.containsKey("writeToFile"))
					FileUtils.write(new File(
							wsMethodParams.get("vocabFilePath") +
							File.separator +
							wsMethodParams.get(HalVocabService.VOCAB_ID) +
							".xml"), vdex);
				//else vdex = out.toString();
				xtw.closeCompletely();
			} catch (XMLStreamException e) {
				throw new MethodExecutionException(e);
			} catch (IOException e) {
				throw new MethodExecutionException(e);
			}
		}
		return vdex;
	}
	
	protected WSOperationBean getWSOperationBeanFromSolr(final List<SolrDocument> docs, Map<String, String> wsMethodParams, String idFieldName, String frLabelFieldName, String enLabelFieldName) throws MethodExecutionException {
		
		WSOperationBean toReturn = new WSOperationBean();
		final String finalIdFieldName = idFieldName;
		final String finalFrLabelFieldName = frLabelFieldName;
		final String finalEnLabelFieldName = enLabelFieldName;
		outputsList = new ConcurrentLinkedQueue<ByteArrayOutputStream>();
		
		String vdex = null;
		if (docs!=null) {
			vdex = produceVdex(new WriteVdexTerm() {
				public void exec(XMLOutputFactory2 xof) {
					XMLStreamWriter2 xtw = null;
					for(SolrDocument doc : docs) {
						try {
							ByteArrayOutputStream out = new ByteArrayOutputStream();
							xtw = (XMLStreamWriter2) xof.createXMLStreamWriter(out);
							xtw.writeStartElement("vdex:term");
							
							// vdex:termIdentifier
							xtw.writeStartElement("vdex:termIdentifier");
							String idValue = getSolrDocumentIdValue(doc, finalIdFieldName);
							xtw.writeCharacters(idValue);
							xtw.writeEndElement();
							
							// vdex:termCaption
							writeVdexCaption(xtw, doc, finalFrLabelFieldName, finalEnLabelFieldName);
							
							xtw.writeEndElement(); // end vdex:term
							xtw.flush();
							outputsList.add(out);
							log.debug("One more vdex:term written");
						} catch (XMLStreamException e) {
							log.info("", e);
						} finally {
							try {
								xtw.closeCompletely();
							} catch (XMLStreamException e) {
								log.info("", e);
							}
						}
					}
				}
			}, (WSOperationBean) wsMethodParams);
		}
		
		toReturn.put("xmlContent", vdex);
		return toReturn;
	}
	
	
	protected void writeVdexCaption(XMLStreamWriter2 xtw, SolrDocument doc, String finalFrLabelFieldName, String finalEnLabelFieldName) throws XMLStreamException {

		// vdex:termCaption
		xtw.writeStartElement("vdex:caption");
		
		writeVdexCaptionFr(xtw, doc, finalFrLabelFieldName);
		writeVdexCaptionEn(xtw, doc, finalEnLabelFieldName);
		
		xtw.writeEndElement(); // end vdex:caption
	}
	
	
	protected void writeVdexCaptionFr(XMLStreamWriter2 xtw, SolrDocument doc, String finalFrLabelFieldName) throws XMLStreamException {
		String labelFrValue = getSolrDocumentFrLabelValue(doc, finalFrLabelFieldName);
		if (labelFrValue!=null) {
			xtw.writeStartElement("vdex:langstring");
			xtw.writeAttribute("language", "fr");
			xtw.writeCharacters(labelFrValue);
			xtw.writeEndElement();
		}
	}
	
	
	protected void writeVdexCaptionEn(XMLStreamWriter2 xtw, SolrDocument doc, String finalEnLabelFieldName) throws XMLStreamException {
		String labelEnValue = getSolrDocumentEnLabelValue(doc, finalEnLabelFieldName);
		if (labelEnValue!=null) {
			xtw.writeStartElement("vdex:langstring");
			xtw.writeAttribute("language", "en");
			xtw.writeCharacters(labelEnValue);
			xtw.writeEndElement();
		}
	}
	
	
	
	protected void fillSolrSearchStartEndPages(int fullSize, List<Integer> starts, List<Integer> rows) {
		
		int pages = fullSize/SOLR_PAGES_SIZE;
		System.out.println("pages="+pages);
		
		int mod = fullSize%SOLR_PAGES_SIZE;
		System.out.println("mod="+mod);
		
		if (mod!=0) {
			pages = pages+1;
		}
		
		for (int p=1; p<=pages; p++) {
			int start = (p-1)*SOLR_PAGES_SIZE;
			int end = p*SOLR_PAGES_SIZE-1;
			if (end>fullSize) {
				end = fullSize-1;
			}
			int row = end-(start-1);
			
			System.out.println("p="+p+" :: "+start+"-->"+end+" ["+row+"]");
			
			starts.add(start);
			rows.add(row);
		}
	}
	
	
	protected List<SolrDocument> solrSearch(String url, String queryString, String idFieldName, String frLabelFieldName, String enLabelFieldName, String sortField) throws MethodExecutionException {
		return solrSearch(url, queryString, idFieldName, frLabelFieldName, enLabelFieldName, sortField, null);
	}
	
	protected List<SolrDocument> solrSearch(String url, String queryString, String idFieldName, String frLabelFieldName, String enLabelFieldName, String sortField, List<String> otherFields) throws MethodExecutionException {

		// asked fields
		List<String> askedFields = new ArrayList<String>();
		String[] idFieldNames = idFieldName.split(",");
		for (String idField : idFieldNames) {
			askedFields.add(idField);
		}
		if (frLabelFieldName!=null)
			askedFields.add(frLabelFieldName);
		if (enLabelFieldName!=null) 
			askedFields.add(enLabelFieldName);
		
		if (otherFields!=null) {
			for (String otherField : otherFields) {
				askedFields.add(otherField);
			}
		}
		
		// solr query
		SolrServer server = new HttpSolrServer(url, null, new XMLResponseParser());
		SolrQuery query = new SolrQuery();
	    query.setQuery(queryString);
	    for (String askedField : askedFields)
	    	query.addField(askedField);
	    if (sortField!=null)
	    	query.addSortField(sortField, SolrQuery.ORDER.asc);
	    
	    
	    final List<SolrDocument> docsResults = new LinkedList<SolrDocument>();
	    try {
	    	// get results length
	    	QueryResponse rsp = server.query(query);
		    SolrDocumentList docs = rsp.getResults();
		    if (docs==null)
		    	System.out.println("\ndocs=null !!!");
		    long numFound = docs.getNumFound();
		    System.out.println("\n"+docs.size()+" :: "+numFound);
		    
		    if ((int)numFound == docs.size()) {
		    	for(SolrDocument doc : docs) {
			    	docsResults.add(doc);
			    }
		    }
		    else {
			    // calculate pages
			    List<Integer> starts = new LinkedList<Integer>();
				List<Integer> rows = new LinkedList<Integer>();
				fillSolrSearchStartEndPages((int)numFound, starts, rows);
			    
			    // real search page per page
				for (int p=0; p<starts.size(); p++) {
				    query = new SolrQuery();
				    query.setQuery(queryString);
				    for (String askedField : askedFields)
				    	query.addField(askedField);
				    query.setStart(starts.get(p));
				    query.setRows(rows.get(p));
				    if (sortField!=null)
				    	query.addSortField(sortField, SolrQuery.ORDER.asc);
				    
				    System.out.println("for :: "+starts.get(p)+" :: "+rows.get(p));
				    
				    rsp = server.query(query);
				    docs = rsp.getResults();
				    System.out.println("docs.size()="+docs.size());
				    for(SolrDocument doc : docs) {
				    	docsResults.add(doc);
				    }
				}
		    }
			
			System.out.println("Nombre de resultats dans SOLR="+numFound+" :: Nombre de resultats dans la liste finale="+docsResults.size());
	    }
	    catch(SolrServerException e) {
	    	throw new MethodExecutionException(e);
	    }
	    
	    return docsResults;
	}
	
	protected String getSolrDocumentIdValue(SolrDocument doc, String idFieldName) {
		String[] idFieldNames = idFieldName.split(",");
		String idValue = null;
		
		for (int i=0; idValue==null && i<idFieldNames.length; i++) {
			Object idObject = doc.getFieldValue(idFieldNames[i]);
			if (idObject!=null) {
				idValue = idObject.toString();
			}
		}
		return idValue;
	}
	
	protected String getSolrDocumentFrLabelValue(SolrDocument doc, String fieldName) {
		return getSolrDocumentFieldValue(doc, fieldName);
		
	}
	
	protected String getSolrDocumentEnLabelValue(SolrDocument doc, String fieldName) {
		return getSolrDocumentFieldValue(doc, fieldName);
		
	}
	
	protected String getSolrDocumentFieldValue(SolrDocument doc, String fieldName) {
		Object fieldObject = null;
		String fieldValue = null;
		if (fieldName!=null) {
			fieldObject = doc.getFieldValue(fieldName);
			if (fieldObject!=null) {
				fieldValue = fieldObject.toString();
			}
		}
		return fieldValue;
	}
	
	protected List<String> getSolrDocumentFieldValues(SolrDocument doc, String fieldName) {
		List<String> fieldValues = null;
		if (fieldName!=null) {
			Collection<Object> fieldObjectList = doc.getFieldValues(fieldName);
			if (fieldObjectList!=null && !fieldObjectList.isEmpty()) {
				fieldValues = new LinkedList<String>();
				for (Object fieldObject : fieldObjectList) {
					fieldValues.add(fieldObject.toString());
				}
			}
		}
		return fieldValues;
	}

}
