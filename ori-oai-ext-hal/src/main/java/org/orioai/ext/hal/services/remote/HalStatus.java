/**
 * 
 */
package org.orioai.ext.hal.services.remote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author neuville
 *
 */
@Service
//@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Qualifier("hal")
@NotMock
public class HalStatus extends AbstractHalOperation {

	private @Value("${hal.statusOpId}") String opId;
	
	private @Value("${hal.dcplusfr.xpath.hal_id}") String dcfrHalIdXpath;;
	


	private enum ParameterName {
		XMLCONTENT(HalWebService.XML_CONTENT), 
		HAL_USER_ID(HalWebService.HAL_USER_ID), 
		HAL_USER_PASSWORD(HalWebService.HAL_USER_PASSWORD);

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

	/* (non-Javadoc)
	 * @see org.orioai.ext.core.services.IWSOperation#execute(java.util.Map)
	 */
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
	throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);
		
		// checking parameters
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		
		// get id, version and password from xpath
		Map<String, String> namespaces = new HashMap<String, String>();
		namespaces.put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		namespaces.put("dc", "http://purl.org/dc/elements/1.1/");
		namespaces.put("dcfr", "http://www.archives-ouvertes.fr/OAI/2.0/dc_plus_fr/");
		namespaces.put("dcterms", "http://purl.org/dc/terms/");
		
		String elementValue = xmlUtilsService.evaluateFromXPath((String)wsMethodParams.get(ParameterName.XMLCONTENT.value), dcfrHalIdXpath, namespaces);
		
		String id = null;
		//String version = null;
		//String password = null;
		if (elementValue!=null) {
			String[] elementValues = elementValue.split(",");
			id = elementValues[0];
			//version = elementValues[1];
			//password = elementValues[2];
		}
		
		// Get status
		String status = null;
		String comment = null;
		try {
			String[] statusElements = swordService.HalStatus(id);
			status = statusElements[0];
			comment = statusElements[3];
		} catch (MethodExecutionException e) {
			e.setOpId(opId);
			e.setFaultCode(new QName(getFaultCodeFromFaultString(e.getFaultString())));
			// valeurs possibles de faultCode : paper_id_can_not_be_found, no_data_can_be_found_please_provide_paper_id
			throw e;
		} catch (Exception e) {
			throw new MethodExecutionException(opId, e);
		}

		WSOperationBean res = new WSOperationBean();
		res.put("halArtStatus", status);
		res.put("halArtComment", comment);
		return res;			
	}
	
	@Override
	public String getOpId() {
		return this.opId;
	}
}
