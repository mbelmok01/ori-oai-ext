package org.orioai.ext.halvocab.services.remote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.common.SolrDocument;
import org.codehaus.stax2.XMLStreamWriter2;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("halvocab")
@NotMock
public class HalGetAffiliations extends AbstractHalGetLabVocab {

	private final String opId = "getAffiliations";

	private ConcurrentHashMap<String, String> label2IdMap = new ConcurrentHashMap<String, String>();

	private String codeField = "code_s";
	private String parentNameField = "parentName_s";
	private String parentValidField = "parentValid_s";
	
	private String generateId() {
		StringBuffer buf = new StringBuffer("ori-etab-");
		buf.append(StringUtils.substring(UUID.randomUUID().toString(), 0, 6));
		return buf.toString();
	}
	
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		otherFields = new ArrayList<String>();
		otherFields.add(codeField);
		otherFields.add(parentNameField);
		otherFields.add(parentValidField);
		
		return commonExecute(wsMethodParams, null);
	}
	

	
	@Override
	protected void writeVdexCaptionFr(XMLStreamWriter2 xtw, SolrDocument doc, String finalFrLabelFieldName) throws XMLStreamException {
		String codeFieldValue = getSolrDocumentFieldValue(doc, codeField);
		List<String> parentNameFieldValues = getSolrDocumentFieldValues(doc, parentNameField);
		List<String> parentValidFieldValues = getSolrDocumentFieldValues(doc, parentValidField);
		
		if (parentNameFieldValues!=null && parentValidFieldValues!=null && parentNameFieldValues.size()>0 && parentNameFieldValues.size()==parentValidFieldValues.size()) {
			for (int i=0; i<parentValidFieldValues.size(); i++) {
				String parentValidFieldValue = parentValidFieldValues.get(i);
				if (parentValidFieldValue.equals("VALID")) {
					String parentNameFieldValue = parentNameFieldValues.get(i);
					
					if (parentNameFieldValue.equals("CNRS") && codeFieldValue!=null && !codeFieldValue.equals("")) {
						parentNameFieldValue = parentNameFieldValue+" : "+codeFieldValue;
					}
					
					xtw.writeStartElement("vdex:langstring");
					xtw.writeAttribute("language", "fr");
					
					String treatedLabel = treatLabel(parentNameFieldValue);
					String id = (label2IdMap.containsKey(treatedLabel)) ?
							label2IdMap.get(treatedLabel) : generateId();
					label2IdMap.putIfAbsent(treatedLabel, id);
					xtw.writeAttribute("id", id);
					
					xtw.writeCharacters(parentNameFieldValue);
					xtw.writeEndElement();
				}
			}
		}
	}
	
	@Override
	protected void writeVdexCaptionEn(XMLStreamWriter2 xtw, SolrDocument doc, String finalEnLabelFieldName) throws XMLStreamException {
		//nothing to do
	}

	@Override
	public String getOpId() {
		return opId;
	}

}
