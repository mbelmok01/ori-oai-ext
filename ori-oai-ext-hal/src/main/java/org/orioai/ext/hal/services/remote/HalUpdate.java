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

import fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct;
import fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitPort;
import fr.archives_ouvertes.hal.ws.submit_php.UserStruct;

/**
 * @author neuville
 *
 */
@Service
@Qualifier("hal")
@NotMock
public class HalUpdate extends AbstractHalOperation {

	private @Value("${hal.updateOpId}") String opId;

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
	 * @see org.orioai.ext.hal.services.remote.AbstractHalOperation#execute(java.util.Map)
	 */
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException {
		if(log.isInfoEnabled())
			log.info("Ok, here we are ! Now executing : "+opId);
		// checking parameters
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		//get hal binding service
		Hal_WebServices_SubmitPort binding = 
				(Hal_WebServices_SubmitPort) initHalBindingService("submit");
		// transforming dc_plus_fr to halDTO
		HalDTO halDTO = buildHalDTO(wsMethodParams.get(ParameterName.XMLCONTENT.value));
		//Hal user informations
		String halUserId = wsMethodParams.get(ParameterName.HAL_USER_ID.value);
		String halUserPassword = wsMethodParams.get(ParameterName.HAL_USER_PASSWORD.value);
		//Hal data structures
		UserStruct user = new UserStruct(halUserId, halUserPassword);
		// Here we go, updating...
		ArticleIdentStruct newArtStruct = null;
		try {
			newArtStruct = binding.update(halDTO.getArtIdentStruct(), user,
					halDTO.getMetadatas());
		} catch (AxisFault fault) {
			throw new MethodExecutionException(opId, fault.getFaultString(),
					fault.getFaultCode(),
					fault.getFaultActor(),
					fault.getFaultNode(),
					fault.getFaultDetails());
		} catch (Exception e) {
			throw new MethodExecutionException(opId, e);
		}

		WSOperationBean res = new WSOperationBean();
		res.put("halArtId", newArtStruct.getIdentifiant());
		res.put("halArtVersion", java.lang.String.valueOf(newArtStruct.getVersion()));
		res.put("halArtPassword", newArtStruct.getPasswd());
		return res;
	}
	/* (non-Javadoc)
	 * @see org.orioai.ext.hal.services.remote.AbstractHalOperation#getOpId()
	 */
	@Override
	public String getOpId() {
		return this.opId;
	}
}
