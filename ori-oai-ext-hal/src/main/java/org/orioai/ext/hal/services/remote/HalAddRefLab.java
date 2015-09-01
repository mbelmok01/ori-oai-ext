/**
 * 
 */
package org.orioai.ext.hal.services.remote;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.axis.AxisFault;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.archives_ouvertes.hal.ws.ref_php.AddLabStruct;
import fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsPort;
import fr.archives_ouvertes.hal.ws.ref_php.UserStruct;
import fr.archives_ouvertes.hal.ws.submit_php.LaboratoryStruct;

/**
 * @author neuville
 *
 */
@Service
@Qualifier("hal")
@NotMock
public class HalAddRefLab extends AbstractHalOperation {

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
	
	private @Value("${hal.addRefLabOpId}") String opId;
	
	/* (non-Javadoc)
	 * @see org.orioai.ext.hal.services.remote.AbstractHalOperation#execute(java.util.Map)
	 */
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		log.info("Ok, here we are ! Now executing : "+opId);
		// checking parameters
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		//get hal binding service
		Hal_WebServices_ReferentielsPort binding = 
			(Hal_WebServices_ReferentielsPort) initHalBindingService("ref");
		// transforming dc_plus_fr to halDTO
		HalDTO halDTO = buildHalDTO((String) wsMethodParams.get(ParameterName.XMLCONTENT.value));
		String halUserId = wsMethodParams.get(ParameterName.HAL_USER_ID.value);
		String halUserPassword = wsMethodParams.get(ParameterName.HAL_USER_PASSWORD.value);
		UserStruct user = new UserStruct(halUserId, halUserPassword);
		LaboratoryStruct oldLab = halDTO.getLaboratories()[0];
		AddLabStruct addLabStruct = new AddLabStruct(oldLab.getKnownLabid(),
				oldLab.getName(), oldLab.getShortName(), oldLab.getAddress(),
				oldLab.getUrl(), oldLab.getPays(), oldLab.getAffiliation());
		int halLabId;
		try {
			halLabId = binding.addRefLab(user, addLabStruct);
		} catch (AxisFault fault) {
			throw new MethodExecutionException(opId, fault.getFaultString(),
					fault.getFaultCode(),
					fault.getFaultActor(),
					fault.getFaultNode(),
					fault.getFaultDetails());
		} catch(Exception e) {
			throw new MethodExecutionException(opId, e);
		}
		WSOperationBean toReturn = new WSOperationBean();
		toReturn.put("halLabId", new Integer(halLabId).toString());
		return toReturn;
	}

	/* (non-Javadoc)
	 * @see org.orioai.ext.core.services.AbstractWSOperation#getOpId()
	 */
	@Override
	public String getOpId() {
		// TODO Auto-generated method stub
		return this.opId;
	}

}
