/**
 * 
 */
package org.orioai.ext.core.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import net.sf.saxon.TransformerFactoryImpl;

import org.orioai.ext.core.exceptions.XmlException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import com.ctc.wstx.stax.WstxInputFactory;

/**
 * Inspired by XMLUtilsService found in ori-oai-workflow.
 * Modified to use woodstox parser factories and stax api (perfs ?).
 * 
 * @author neuville
 *
 */
@Service
public class XMLUtilsService {

	protected Log4jLoggerAdapter log = 
			(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
	
	
	protected XPathFactory xPathFactory;
	
	
	
	public StringBuilder xslTransform(String xslFile, String xmlContent) {
		return 	xslTransform(xslFile, xmlContent, null, null);
	}
	
	/**
	 * Make a Xsl Transformation of xmlContent with xslFile.
	 * 
	 * @param xslFile
	 *            String location of the xsl File : ClassPathResource
	 * @param xmlContent
	 *            the content of the xml
	 * @param xslParameters 
	 * @return the content of the html
	 */
	public StringBuilder xslTransform(String xslFile, String xmlContent, URIResolver uriResolver, Map<String, String> xslParameters) {

		StringBuilder result = new StringBuilder();
		
		XMLInputFactory inputFactory = null;
		XMLStreamReader streamReaderXSL = null;
		XMLStreamReader streamReaderXML= null;
		Transformer transformer = null;
		ClassPathResource xslFileResource = null;

		inputFactory = WstxInputFactory.newInstance();
		
		//set three properties for the XMLInputFactory  
	    inputFactory.setProperty("javax.xml.stream.isSupportingExternalEntities",Boolean.TRUE);
	    inputFactory.setProperty("javax.xml.stream.isNamespaceAware",Boolean.TRUE);
	    inputFactory.setProperty("javax.xml.stream.isReplacingEntityReferences",Boolean.TRUE);
		
		TransformerFactory tFactory = new TransformerFactoryImpl();
//		    TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
		if(uriResolver != null)
			tFactory.setURIResolver(uriResolver);
		
		try {
			xslFileResource = new ClassPathResource(xslFile);
			
			//get the XMLStreamReader objects
			streamReaderXSL = inputFactory.createXMLStreamReader(xslFileResource.getInputStream());
			streamReaderXML = inputFactory.createXMLStreamReader(new ByteArrayInputStream(xmlContent.getBytes()));
			
			// get the transformer and sets its parameters
			Source sourceXSL = new StAXSource(streamReaderXSL);
			transformer = tFactory.newTransformer(sourceXSL);
			//transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			if(xslParameters != null) {
				for(String xslParameterName: xslParameters.keySet()) {
					transformer.setParameter(xslParameterName, xslParameters.get(xslParameterName));
				}
			}
			
			if(uriResolver != null)
				transformer.setURIResolver(uriResolver);
			
			transformer.setErrorListener(new ErrorListener() {

				public void error(TransformerException e) throws TransformerException {
					throw new XmlException("Xsl Transformation failed", e);
				}

				public void fatalError(TransformerException e) throws TransformerException {
					throw new XmlException("Xsl Transformation failed", e);	
				}

				public void warning(TransformerException e) throws TransformerException {
					throw new XmlException("Xsl Transformation failed", e);
				}
			});
			
			// the xml to be transformed
			Source src = new StAXSource(streamReaderXML);
			
			// the result of the transformation
			StringWriter sw = new StringWriter();
			// I would have preferred to use a StAXResult here,
			// but it didn't work (neither with xalan nor saxon)
			Result tempRes = new StreamResult(sw);
			
			// Do the transformation
			transformer.transform(src, tempRes);
			result.append(sw.getBuffer());

			return result;
			
		} catch (Throwable cause) {
			throw new XmlException("Xsl Transformation failed : xslFile = " + xslFile, new Exception(cause));
		}
	}
	
	
	
	
	
	
	
	
	protected InputStream getInputStreamFromString(String inputXML){
		ByteArrayInputStream inputStream = null;
		
        try{
        	inputStream = new ByteArrayInputStream(inputXML.getBytes("UTF-8"));
        }catch(Exception e){
        	log.error("can't get inputstream for string :"+inputXML,e);
        }
		return inputStream;
	}
	
	public String evaluateFromXPath(String inputXML, String xpath, Map<String, String> namespaces){
		String result = null;
		InputStream inputStream = getInputStreamFromString(inputXML);
		InputSource source = new InputSource(inputStream);
		try{
			XPath environnement = getXPathFactory().newXPath();
			environnement.setNamespaceContext(new NamespaceContextImpl(namespaces));
			
			XPathExpression expression = environnement.compile(xpath);
			result = expression.evaluate(source);
			
		}
		catch(Exception e){
			log.debug("can't evaluate XPATH expression :"+xpath +" for string :"+inputXML, e);
		}
		return result;
		
	}
	
	

	public XPathFactory getXPathFactory(){
		if (xPathFactory==null) { 
			xPathFactory = XPathFactory.newInstance();
		}
		return xPathFactory;
	}
}


class NamespaceContextImpl implements NamespaceContext{
	

	protected Map<String, String> namespaces;
	protected Map<String, String> prefixes;
	
	
	public NamespaceContextImpl(Map<String, String> namespaces) {
		super();
		this.namespaces = namespaces;
		prefixes = new HashMap<String, String>();
		
		for(Map.Entry<String,String> entry : namespaces.entrySet()){
			prefixes.put(entry.getValue(), entry.getKey());
		}
	}

	public String getNamespaceURI(String prefix) {
		return namespaces.get(prefix);
	}

	public String getPrefix(String namespaceURI) {
		return prefixes.get(namespaceURI);
	}

	public Iterator<String> getPrefixes(String namespaceURI) {
		return namespaces.keySet().iterator();
		
	}
}
