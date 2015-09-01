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

import fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct;
import fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub;

@Service
@Qualifier("halvocab")
@NotMock
public class HalGetEmbargos extends AbstractHalGetVocab {

	private final String opId = "getEmbargos";

	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);

		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		Hal_WebServices_ReferentielsBindingStub binding = 
				(Hal_WebServices_ReferentielsBindingStub) initHalBindingService();
		final DateVisibleStruct[] embargosFr;
		try {
			embargosFr = binding.getRefDateVisible();
		} catch (RemoteException e) {
			throw new MethodExecutionException(e);
		}
		WSOperationBean toReturn = new WSOperationBean();

		String vdex = produceVdex(new WriteVdexTerm() {
			public void exec(XMLOutputFactory2 xof) {
				XMLStreamWriter2 xtw = null;
				for(DateVisibleStruct emb : embargosFr)
					try {
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						xtw = (XMLStreamWriter2) xof.createXMLStreamWriter(out);
						xtw.writeStartElement("vdex:term");
						// vdex:termIdentifier
						xtw.writeStartElement("vdex:termIdentifier");
						xtw.writeCharacters(emb.getCode());
						xtw.writeEndElement();
						// vdex:termCaption
						xtw.writeStartElement("vdex:caption");
						xtw.writeStartElement("vdex:langstring");
						xtw.writeAttribute("language", "fr");
						xtw.writeCharacters(emb.getLibelle());
						xtw.writeEndElement();
						xtw.writeStartElement("vdex:langstring");
						xtw.writeAttribute("language", "en");
						xtw.writeCharacters(
								org.apache.commons.lang3.StringUtils.replaceEach(
										emb.getLibelle(), new String[] {"ans", "an", "mois", "jours"},
										new String[] {"years", "year", "month(s)", "day(s)"}));
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
