/**
 * 
 */
package org.orioai.ext.core.utils;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.orioai.ext.core.utils.XMLUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neuville
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext-test.xml")
@Component
public class TestXMLUtilsService {

	/**
	 * tested class
	 */
	@Autowired
	private XMLUtilsService xmlServ;
	
	private String xslFile = "/META-INF/xsl/dcPlusFr2halDTO.xsl";
	
	private String xmlContent;
	
	@Before
	public void setup() {
		ClassPathResource xmlContentResource = 
								new ClassPathResource("/META-INF/xml/dc_plus_fr_test.xml");
		InputStream xmlContentStream = null;
		try {
			xmlContentStream = xmlContentResource.getInputStream();
			byte[] tabXML = new byte[xmlContentStream.available()];
			xmlContentStream.read(tabXML);
			xmlContentStream.close();
			xmlContent = new String(tabXML);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testXslTransform() {
		StringBuilder result = xmlServ.xslTransform(xslFile, xmlContent);
		System.out.println(result.toString());
	}
	
}
