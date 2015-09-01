package org.orioai.ext.halvocab.services.remote;

import java.io.ByteArrayOutputStream;
import java.rmi.RemoteException;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.codehaus.stax2.XMLOutputFactory2;
import org.codehaus.stax2.XMLStreamWriter2;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.archives_ouvertes.hal.ws.ref_php.FormatStruct;
import fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub;

@Service
@Qualifier("halvocab")
@NotMock
public class HalGetFilesFormats extends AbstractHalGetVocab {

	private final String opId = "getFilesFormats";

	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);

		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		Hal_WebServices_ReferentielsBindingStub binding = 
				(Hal_WebServices_ReferentielsBindingStub) initHalBindingService();
		final FormatStruct[] formatsFr;
		final FormatStruct[] formatsEn;
		try {
			formatsFr = binding.getRefFormat("hal", "fr");
			formatsEn = binding.getRefFormat("hal", "en");			
		} catch (RemoteException e) {
			throw new MethodExecutionException(e);
		}
		WSOperationBean toReturn = new WSOperationBean();

		String vdex = produceVdex(new WriteVdexTerm() {
			public void exec(XMLOutputFactory2 xof) {
				XMLStreamWriter2 xtw = null;
				for(FormatStruct formtFr : formatsFr)
					for(FormatStruct formtEn : formatsEn)
						if (formtFr.getCode().equals(formtEn.getCode()))
							try {
								ByteArrayOutputStream out = new ByteArrayOutputStream();
								xtw = (XMLStreamWriter2) xof.createXMLStreamWriter(out);
								xtw.writeStartElement("vdex:term");
								// vdex:termIdentifier
								xtw.writeStartElement("vdex:termIdentifier");
								xtw.writeCharacters(formtFr.getCode());
								xtw.writeEndElement();
								// vdex:termCaption
								xtw.writeStartElement("vdex:caption");
								xtw.writeStartElement("vdex:langstring");
								xtw.writeAttribute("language", "fr");
								xtw.writeCharacters(formtFr.getLibelle());
								xtw.writeEndElement();
								xtw.writeStartElement("vdex:langstring");
								xtw.writeAttribute("language", "en");
								xtw.writeCharacters(formtEn.getLibelle());
								xtw.writeEndElement();
								xtw.writeEndElement();
								xtw.writeEndElement();
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
		}, (WSOperationBean) wsMethodParams);

		toReturn.put("xmlContent", vdex);
		return toReturn;
	}

	@Override
	public String getOpId() {
		return opId;
	}
}
