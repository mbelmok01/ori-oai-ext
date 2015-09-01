/**
 * 
 */
package org.orioai.ext.hal.services.marshalling;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;

import org.codehaus.stax2.XMLOutputFactory2;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.castor.CastorMarshaller;
import org.springframework.stereotype.Service;

import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;

/**
 * @author neuville
 *
 */
@Service
@Qualifier("castor")
public class CastorHalDTOBuilder implements IHalDTOBuilder {

	@Resource(name="halDTOMarshaller")
	private CastorMarshaller marshaller;
	
	/* (non-Javadoc)
	 * @see org.orioai.ext.hal.services.marshalling.IHalDTOBuilder#buildHalDTO(java.lang.String)
	 */
	@Override
	public HalDTO buildHalDTO(String xmlContent) throws OriOaiExtException {
		HalDTO halDTO = null;
		
		XMLInputFactory inputFactory = null;
		XMLStreamReader streamReaderXML= null;
		
		inputFactory = WstxInputFactory.newInstance();
		//set three properties for the XMLInputFactory  
	    inputFactory.setProperty("javax.xml.stream.isSupportingExternalEntities",Boolean.TRUE);
	    inputFactory.setProperty("javax.xml.stream.isNamespaceAware",Boolean.TRUE);
	    inputFactory.setProperty("javax.xml.stream.isReplacingEntityReferences",Boolean.TRUE);

		try {
			streamReaderXML = inputFactory.createXMLStreamReader(new ByteArrayInputStream(xmlContent.getBytes("UTF-8")));
			Source src = new StAXSource(streamReaderXML);
			halDTO = (HalDTO) marshaller.unmarshal(src);
		} catch (Throwable t) {
			throw new OriOaiExtException("HalDTO building failed : " + t.getLocalizedMessage(), new Exception(t));
		} 
		return halDTO;
	}
	
	@Override
	public String serializeHalDTO(HalDTO halDTO) throws OriOaiExtException {
		OutputStream output = new ByteArrayOutputStream();
		
		XMLOutputFactory2 outputFactory = null;
		XMLStreamWriter xmlSw = null;
		
		outputFactory = (XMLOutputFactory2) WstxOutputFactory.newInstance();
		//set three properties for the factories
	    outputFactory.setProperty("javax.xml.stream.isNamespaceAware",Boolean.TRUE);

	    try {
	    	xmlSw = outputFactory.createXMLStreamWriter(output);
	    	Result tempRes = new StAXResult(xmlSw);
	    	marshaller.marshal(halDTO, tempRes);
	    } catch (Throwable t) {
			throw new OriOaiExtException("HalDTO serializing failed : " + t.getLocalizedMessage(), new Exception(t));
		}
	    
	    return output.toString();
	}

}
