/**
 * 
 */
package org.orioai.ext.hal.services.remote;

import java.util.Map;

import org.apache.axis.AxisFault;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct;
import fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct;
import fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitPort;
import fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct;
import fr.archives_ouvertes.hal.ws.submit_php.UserStruct;

/**
 * @author neuville
 *
 */
@Service
@Qualifier("hal")
@NotMock
public class HalModify extends AbstractHalOperation {

	private @Value("${hal.modifyOpId}") String opId;

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
		HalDTO halDTO = buildHalDTO((String) wsMethodParams.get(ParameterName.XML_CONTENT.value));
		// preparing user, contrib and fullText
		Object[] commonStructs =PrepareCommonStructs(wsMethodParams);
		// here we go, modifying
		PendingArticleStruct pendingArt = null;
		try {
			pendingArt = binding.modify(halDTO.getArtIdentStruct(), 
					(UserStruct) commonStructs[0], (ContributorStruct) commonStructs[1],
					halDTO.getMetadatas(), (FullTextStruct) commonStructs[2]);
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
		res.put("halArtId", pendingArt.getIdentifiant());
		res.put("halArtVersion", java.lang.String.valueOf(pendingArt.getVersion()));
		res.put("halArtPassword", pendingArt.getPasswd());
		res.put("halArtStatus", pendingArt.getStatus());
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
