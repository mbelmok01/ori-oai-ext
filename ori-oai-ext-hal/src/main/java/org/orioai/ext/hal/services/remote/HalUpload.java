/**
 * 
 */
package org.orioai.ext.hal.services.remote;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis.AxisFault;
import org.apache.commons.io.FileUtils;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.orioai.ws.ext.exceptions.MethodParametersException;
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
 */
@Service
//@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
@Qualifier("hal")
@NotMock
public class HalUpload extends AbstractHalOperation {

	private @Value("${hal.uploadOpId}") String opId;

	/* (non-Javadoc)
	 * @see org.orioai.ext.core.services.AbstractWSOperation#checkParameters(java.lang.String, java.util.List, java.util.Map)
	 */
	/**
	 * According to the value mapped to the key 
	 * {@link HalWebService#ENVOI_HAL}, the key 
	 * {@link HalWebService#FULL_TEXT_CONTENT_BASE_64} may or may
	 * not be present.
	 */
	@Override
	protected boolean checkParameters(String opId,
			List<String> parametersNames, Map<String, String> wsMethodParams)
					throws MethodParametersException {
		String[] constArray = {HalWebService.ENVOI_HAL_FILE_HAL, HalWebService.ENVOI_HAL_FILE_NO_HAL, 
				HalWebService.ENVOI_HAL_LINK_FILE_HAL, HalWebService.ENVOI_HAL_LINK_HAL, 
				HalWebService.ENVOI_HAL_NO_FILE_HAL, HalWebService.ENVOI_HAL_UNAVAILABLE_FILE}; 
		if(!Arrays.asList(constArray).contains(wsMethodParams.get(HalWebService.ENVOI_HAL)))
			throw new MethodParametersException(opId, HalWebService.ENVOI_HAL);
		if(wsMethodParams.get(HalWebService.ENVOI_HAL).equals(HalWebService.ENVOI_HAL_LINK_HAL) ||
				wsMethodParams.get(HalWebService.ENVOI_HAL).equals(HalWebService.ENVOI_HAL_NO_FILE_HAL))
			parametersNames.remove(HalWebService.FULL_TEXT_CONTENT_BASE_64);
		return super.checkParameters(opId, parametersNames, wsMethodParams);
	}

	/* (non-Javadoc)
	 * @see org.orioai.ext.services.remote.IWSOperation#execute(java.util.Map)
	 */
	/**
	 * <p>
	 * This method processes as follows :
	 * <ol>
	 * <li> checking of parameters
	 * <li> reclaiming of the XML to be uploaded
	 * <li> XSLT transformation of this XML to hal objects schema (HalDTO)
	 * <li> Deserialisation of HalDTO XML into objects
	 * <li> Uploading of these objects towards Hal through Axis
	 * </ol>
	 * </p>
	 * @throws MethodExecutionException
	 */		
	@Override
	public WSOperationBean execute(Map<String, String> wsMethodParams) 
			throws MethodExecutionException {
		if(log.isInfoEnabled())
			log.info("Ok, here we are ! Now executing : "+opId);
		// checking parameters
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		
		// preparing fullText
		FullTextStruct fullTextStruc = getFullTextStruct(wsMethodParams);
		System.out.println("\n\n==fullTextStruc==\n"+fullTextStruc+"\n\n");
		
		// XSLT transformation : DC+FR to TEI
		String xmlFileName = "orioai-xml-content.xml";
		String xmlContent = wsMethodParams.get(ParameterName.XML_CONTENT.value);
		String xslFile = "/META-INF/xsl/dcPlusFr2halDTO.xsl";
		StringBuilder result = xmlUtilsService.xslTransform(xslFile, xmlContent);
		System.out.println("\n\n"+result.toString()+"\n\n");
		
		// TODO : BEGIN TEMP
		try {
			if (fullTextStruc!=null && fullTextStruc.getFiles()!=null && fullTextStruc.getFiles().length>0) {
				xmlContent = FileUtils.readFileToString(new File("D:\\Travail\\Developpement\\Workspaces\\ORI-OAI\\ori-oai-ext_v2-fonctionnel\\ori-oai-ext-hal\\src\\test\\resources\\sword\\data-test\\zip\\halv3_sword_art-include-pdf.xml"));
			}
			else {
				xmlContent = FileUtils.readFileToString(new File("D:\\Travail\\Developpement\\Workspaces\\ORI-OAI\\ori-oai-ext_v2-fonctionnel\\ori-oai-ext-hal\\src\\test\\resources\\sword\\data-test\\halv3_sword_art-url-pdf.xml")); 
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// TODO : END TEMP
		
		// create ZIP package
		File zipFileDest = null;
		try {
			zipFileDest = this.createZipFile(xmlFileName, xmlContent, fullTextStruc);
		}
		catch(IOException e) {
			throw new MethodExecutionException(opId, e);
		}
		
		// Here we go, uploading...
		String id = null;
		try {
			// send document to HAL with Sword
			id = swordService.HalUploadZip(zipFileDest, xmlFileName);
			
			if (zipFileDest!=null) {
				try {
					FileUtils.forceDelete(zipFileDest);
				}
				catch(IOException ioe) {
					log.warn("Can't delete file : "+zipFileDest);
				}
			}
		} catch (MethodExecutionException e) {
			if (zipFileDest!=null) {
				try {
					FileUtils.forceDelete(zipFileDest);
				}
				catch(IOException ioe) {
					log.warn("Can't delete file : "+zipFileDest);
				}
			}
			
			e.setOpId(opId);
			e.setFaultCode(new QName(getFaultCodeFromFaultString(e.getFaultString())));
			throw e;
		} catch (Exception e) {
			if (zipFileDest!=null) {
				try {
					FileUtils.forceDelete(zipFileDest);
				}
				catch(IOException ioe) {
					log.warn("Can't delete file : "+zipFileDest);
				}
			}
			
			throw new MethodExecutionException(opId, e);
		}
		
		// Get status
		String status = null;
		String version = null;
		String password = null;
		String comment = null;
		try {
			String[] statusElements = swordService.HalStatus(id);
			status = statusElements[0];
			version = statusElements[1];
			password = statusElements[2];
			comment = statusElements[3];
		} catch (MethodExecutionException e) {
			e.setOpId(opId);
			e.setFaultCode(new QName(getFaultCodeFromFaultString(e.getFaultString())));
			// valeurs possibles de faultCode : paper_id_can_not_be_found, no_data_can_be_found_please_provide_paper_id
			throw e;
		} catch (Exception e) {
			throw new MethodExecutionException(opId, e);
		}
		
		// Dealing with the result
		WSOperationBean res = new WSOperationBean();
		res.put("halArtId", id);
		res.put("halArtVersion", version);
		res.put("halArtPassword", password);
		res.put("halArtStatus", status);
		res.put("halArtComment", comment);
		return res;
	}
	
	public WSOperationBean executeByWS(Map<String, String> wsMethodParams) 
			throws MethodExecutionException {
		if(log.isInfoEnabled())
			log.info("Ok, here we are ! Now executing : "+opId);
		// checking parameters
		checkParameters(opId, ParameterName.getValues(), wsMethodParams);
		
		//get hal binding service
		Hal_WebServices_SubmitPort binding = 
				(Hal_WebServices_SubmitPort) initHalBindingService("submit");
		// transforming dc_plus_fr to halDTO
		HalDTO halDTO = buildHalDTO(wsMethodParams.get(ParameterName.XML_CONTENT.value));	
		// preparing user, contrib and fullText
		Object[] commonStructs = PrepareCommonStructs(wsMethodParams);
		// Here we go, uploading...
		PendingArticleStruct pendingArt = null;
		try {
			pendingArt = binding.upload(halDTO.getHalPortalName(), 
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
		// Dealing with the result
		WSOperationBean res = new WSOperationBean();
		res.put("halArtId", pendingArt.getIdentifiant());
		res.put("halArtVersion", java.lang.String.valueOf(pendingArt.getVersion()));
		res.put("halArtPassword", pendingArt.getPasswd());
		res.put("halArtStatus", pendingArt.getStatus());
		return res;
	}

	@Override
	public String getOpId() {
		return this.opId;
	}
}
