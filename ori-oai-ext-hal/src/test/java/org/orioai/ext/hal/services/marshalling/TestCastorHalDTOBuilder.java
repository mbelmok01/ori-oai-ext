/**
 * 
 */
package org.orioai.ext.hal.services.marshalling;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ext.hal.stubs.HalDTOBuilderStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neuville
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext-testHalDTOBuilder.xml")
@Component
public class TestCastorHalDTOBuilder {
	
	/**
	 * tested class
	 */
	@Autowired
	private CastorHalDTOBuilder halDTOBuilder;
	
	@Autowired
	private HalDTOBuilderStub halDTOBuilderStub;
	
	private HalDTO halDTO1;
	
	private HalDTO halDTO2;
	
	private String halDTOxml1;
	
	private String halDTOxml2;

	
	/**
	 * Build an halDTO object using a fake halDTOBuilder ; 
	 * then build an halDTO object using the real (tested) halDTOBuilder 
	 * 
	 * @throws Exception
	 */
	@Before
	public void prepareHalDTOs() throws Exception {
		try {
			halDTO1 = halDTOBuilderStub.buildHalDTO(null);
			halDTOxml1 = halDTOBuilder.serializeHalDTO(halDTO1); 
			FileUtils.writeStringToFile(new File("src/test/resources/META-INF/xml/halDTOxml1.xml"), 
													halDTOxml1, "utf-8");
			
			halDTO2 = halDTOBuilder.buildHalDTO(halDTOxml1);
			halDTOxml2 = halDTOBuilder.serializeHalDTO(halDTO2);
			FileUtils.writeStringToFile(new File("src/test/resources/META-INF/xml/halDTOxml2.xml"), 
													halDTOxml2, "utf-8");
		} catch (Throwable t) {
			throw new Exception(t);
		}
	}
	
	
	/**
	 * Test equality of the two halDTOs through
	 * their serialized form
	 * 
	 * @throws IOException
	 */
	@Test
	public void testHalDTOsEquality() throws IOException {
		String xml1 = FileUtils.readFileToString(new File("src/test/resources/META-INF/xml/halDTOxml1.xml"), "utf-8");
		String xml2 = FileUtils.readFileToString(new File("src/test/resources/META-INF/xml/halDTOxml2.xml"), "utf-8");
		Assert.assertTrue(xml1.equals(xml2));
	}
}
