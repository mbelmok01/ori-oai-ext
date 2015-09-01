package org.orioai.ext.hal.services.marshalling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.orioai.ext.core.utils.XMLUtilsService;
import org.orioai.ext.hal.beans.HalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext-testCompleteHalDTOMarshalling.xml")
@Component
public class TestCompleteHalDTOMarshalling {

	@Autowired
	@Qualifier("castor")
	private CastorHalDTOBuilder halDTOBuilder;

	@Autowired
	private XMLUtilsService xmlUtilsService;

	private String dcplusfr2halDTO = "/META-INF/xsl/dcPlusFr2halDTO.xsl";
	
	private String dcplusfrLoc = "src/test/resources/META-INF/xml/dc_plus_fr_exemplev12.xml";

	private String halDTOXml;
	
	private String halDTOXmlResult;
	
	@Before
	public void prepare() throws IOException {
		HalDTO halDTO;
		try {
			halDTOXml = 
				xmlUtilsService.xslTransform(dcplusfr2halDTO, FileUtils.readFileToString(new File(dcplusfrLoc))).toString();
			halDTO = halDTOBuilder.buildHalDTO(halDTOXml.toString());
			halDTOXmlResult = halDTOBuilder.serializeHalDTO(halDTO);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testEquality() {
		System.out.println(halDTOXmlResult);
	}
	
}
