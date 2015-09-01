/**
 * 
 */
package org.orioai.ext.hal.services.remote;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.orioai.ext.core.services.AbstractWSOperation;
import org.orioai.ext.core.utils.XMLUtilsService;
import org.orioai.ext.core.utils.ZIPUtilsService;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ext.hal.services.marshalling.IHalDTOBuilder;
import org.orioai.ext.hal.services.sword.HalSwordService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.orioai.ws.ext.exceptions.MethodParametersException;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.google.common.base.Charsets;

import fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsBindingStub;
import fr.archives_ouvertes.hal.ws.ref_php.Hal_WebServices_ReferentielsServiceLocator;
import fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchBindingStub;
import fr.archives_ouvertes.hal.ws.search_php.Hal_WebServices_SearchServiceLocator;
import fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct;
import fr.archives_ouvertes.hal.ws.submit_php.FileStruct;
import fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct;
import fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitBindingStub;
import fr.archives_ouvertes.hal.ws.submit_php.Hal_WebServices_SubmitServiceLocator;
import fr.archives_ouvertes.hal.ws.submit_php.UserStruct;

/**
 * @author neuville
 *
 */
public abstract class AbstractHalOperation extends AbstractWSOperation {
	
	protected String opId;
	
	private @Value("${hal.submit.ws.url}") String submitWsUrl;
	
	private @Value("${hal.ref.ws.url}") String refWsUrl;
	
	private @Value("${hal.search.ws.url}") String searchWsUrl;
	
	@Autowired
	protected XMLUtilsService xmlUtilsService;
	
	@Autowired
	protected ZIPUtilsService zipUtilsService;
	
	@Autowired
	protected HalSwordService swordService;

	@Autowired
	@Qualifier("castor")
	private IHalDTOBuilder halDTOBuilder;

	private @Value("${hal.dcplusfr2haldto}") String dcplusfr2halDTO;

	/**
	 * Hal Web services binding.
	 */
//	protected PAOL_WSBindingStub binding;
	
	/**
	 * <p>
	 * Needed to iterate on parameter names
	 * and check the non nullity of associated values.
	 * </p> 
	 * @author neuville
	 */
	protected enum ParameterName {
		XML_CONTENT(HalWebService.XML_CONTENT), 
		FULL_TEXT_NAME(HalWebService.FULL_TEXT_NAME),
		FULL_TEXT_FORMAT(HalWebService.FULL_TEXT_FORMAT),
		FULL_TEXT_CONTENT_BASE_64(HalWebService.FULL_TEXT_CONTENT_BASE_64),
		FULL_TEXT_URI(HalWebService.FULL_TEXT_URI),
		HAL_USER_ID(HalWebService.HAL_USER_ID), 
		HAL_USER_PASSWORD(HalWebService.HAL_USER_PASSWORD),
		HAL_CONTRIB_LASTNAME(HalWebService.HAL_CONTRIB_LASTNAME),
		HAL_CONTRIB_FIRSTNAME(HalWebService.HAL_CONTRIB_FIRSTNAME),
		HAL_CONTRIB_EMAIL(HalWebService.HAL_CONTRIB_EMAIL);
		
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
	public abstract WSOperationBean execute(Map<String, String> wsMethodParams)
			throws MethodExecutionException;
	
	/**
	 * 
	 * @param dcPlusFr
	 * @return
	 * @throws MethodExecutionException
	 */
	protected HalDTO buildHalDTO(String dcPlusFr) throws MethodExecutionException {
		if(log.isDebugEnabled()) {
			log.debug("XSL tranformation stylesheet is : "+dcplusfr2halDTO);
			log.debug("Transformation entry : \n" + dcPlusFr + "\n");
		}
		StringBuilder halDTOXml = xmlUtilsService.xslTransform(dcplusfr2halDTO, dcPlusFr);
		if(log.isDebugEnabled())
			log.debug("Result of dcplusfr2halDTO.xsl transformation : \n" + halDTOXml.toString() + "\n");
		// unmarshalling halDTOXml to HalDTO
		HalDTO halDTO;
		try {
			halDTO = halDTOBuilder.buildHalDTO(halDTOXml.toString());
		} catch (OriOaiExtException e1) {
			throw new MethodExecutionException(e1);
		}
		return halDTO;
	}
	
	/**
	 * initialize the binding for the hal web services.
	 * 
	 * @throws MethodExecutionException
	 */
	public Remote initHalBindingService(String halWS) throws MethodExecutionException {
		Remote binding = null;
		try {
			if (halWS.equals("submit")) {
				Hal_WebServices_SubmitServiceLocator loc =
						new Hal_WebServices_SubmitServiceLocator();
				loc.setHal_WebServices_SubmitPortEndpointAddress(submitWsUrl);
				Hal_WebServices_SubmitBindingStub _stub =
						(Hal_WebServices_SubmitBindingStub) loc.getHal_WebServices_SubmitPort();
				_stub.setOperationNameSpaceURL(submitWsUrl);
				binding = _stub;
			} 
			else if (halWS.equals("ref")) {
				Hal_WebServices_ReferentielsServiceLocator loc=
						new Hal_WebServices_ReferentielsServiceLocator();
				loc.setHal_WebServices_ReferentielsPortEndpointAddress(refWsUrl);
				Hal_WebServices_ReferentielsBindingStub _stub =
						(Hal_WebServices_ReferentielsBindingStub) loc.getHal_WebServices_ReferentielsPort();
				_stub.setOperationNameSpaceURL(refWsUrl);
				binding = _stub;
			}
			else if (halWS.equals("search")) {
				Hal_WebServices_SearchServiceLocator loc=
						new Hal_WebServices_SearchServiceLocator();
				loc.setHal_WebServices_SearchPortEndpointAddress(searchWsUrl);
				Hal_WebServices_SearchBindingStub _stub =
						(Hal_WebServices_SearchBindingStub) loc.getHal_WebServices_SearchPort();
				_stub.setOperationNameSpaceURL(searchWsUrl);
				binding = _stub;
			}
		} catch (javax.xml.rpc.ServiceException jre) {
			if (jre.getLinkedCause() != null) {
				jre.getLinkedCause().printStackTrace();
			}
			throw new MethodExecutionException("Hal Binding initialization exception, JAX-RPC " +
					"ServiceException caught: " + jre.getMessage());
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return binding;
	}
	
	public Remote initHalBindingService(String halWS, String wsUrl) throws MethodExecutionException {
		if (halWS.equals("submit")) submitWsUrl = wsUrl;
		else if (halWS.equals("ref")) refWsUrl = wsUrl;
		else searchWsUrl = wsUrl;
		return initHalBindingService(halWS);
	}

	protected FullTextStruct getFullTextStruct(Map<String, String> wsMethodParams) throws MethodParametersException {
		// FullText Structure
		FileStruct[] files = {};
		String envoiHal = wsMethodParams.get(HalWebService.ENVOI_HAL);
		if(envoiHal.equals(HalWebService.ENVOI_HAL_FILE_HAL) || 
				envoiHal.equals(HalWebService.ENVOI_HAL_LINK_HAL) ||
				envoiHal.equals(HalWebService.ENVOI_HAL_LINK_FILE_HAL)) {
			String fullTextName = 
				org.apache.commons.lang3.StringUtils.replace(
						wsMethodParams.get(ParameterName.FULL_TEXT_NAME.value), " ", "_");
			String fullTextFormat = wsMethodParams.get(ParameterName.FULL_TEXT_FORMAT.value);
			int i = 0;
			String[] fullTextLinksTab =
				wsMethodParams.get(ParameterName.FULL_TEXT_URI.value).split("\\|");
			String[] fullTextBase64Tab = 
				(wsMethodParams.containsKey(ParameterName.FULL_TEXT_CONTENT_BASE_64.value))
				? wsMethodParams.get(ParameterName.FULL_TEXT_CONTENT_BASE_64.value).split("\\|")
						: new String[0];
			// we initiate files array for both links and resources if needed
			files = (envoiHal.equals(HalWebService.ENVOI_HAL_LINK_HAL) ||
						envoiHal.equals(HalWebService.ENVOI_HAL_FILE_HAL)) 
						? new FileStruct[fullTextLinksTab.length] 
						                 : new FileStruct[fullTextLinksTab.length + fullTextBase64Tab.length];
			// we shall send the resource link (url)
			if(envoiHal.equals(HalWebService.ENVOI_HAL_LINK_HAL) ||
				envoiHal.equals(HalWebService.ENVOI_HAL_LINK_FILE_HAL)) {
				List<String> addedName = new ArrayList<String>();
				for(String fullTextLink : fullTextLinksTab) {
					String fullName = fullTextName;
					if (addedName.contains(fullTextName)) {
						fullName = fullName + "-" + String.valueOf(i);
					}
					fullName = fullName + "." + fullTextFormat.toLowerCase();
					files[i] = new FileStruct(fullName, "", fullTextFormat, fullName, fullTextLink, false);
					i++;
					
					addedName.add(fullTextName);
				}
			}
			// we shall send the resource
			if(envoiHal.equals(HalWebService.ENVOI_HAL_FILE_HAL) || 
					envoiHal.equals(HalWebService.ENVOI_HAL_LINK_FILE_HAL)) {
				List<String> addedName = new ArrayList<String>();
				for(String fullTextBase64 : fullTextBase64Tab) {
					String fullName = fullTextName;
					if (addedName.contains(fullTextName)) {
						fullName = fullName + "-" + String.valueOf(i);
					}
					fullName = fullName + "." + fullTextFormat.toLowerCase();
					files[i] = new FileStruct(fullName, "", fullTextFormat, fullName, fullTextBase64, true);
					i++;
					
					addedName.add(fullTextName);
				}
			}
		}	
		FullTextStruct fullText = new FullTextStruct(1, files);
		return fullText;
	}

	protected Object[] PrepareCommonStructs(Map<String, String> wsMethodParams) throws MethodParametersException {
		// UserStruct
		String halUserId = wsMethodParams.get(ParameterName.HAL_USER_ID.value);
		String halUserPassword = wsMethodParams.get(ParameterName.HAL_USER_PASSWORD.value);
		UserStruct user = new UserStruct(halUserId, halUserPassword);
		//ContributorStruct
		ContributorStruct contrib = 
			new ContributorStruct(wsMethodParams.get(ParameterName.HAL_CONTRIB_LASTNAME.value), 
					wsMethodParams.get(ParameterName.HAL_CONTRIB_FIRSTNAME.value), 
					wsMethodParams.get(ParameterName.HAL_CONTRIB_EMAIL.value));
		// FullText Structure
		FullTextStruct fullText = getFullTextStruct(wsMethodParams);
		
		Object[] toReturn = {user, contrib, fullText};
		return toReturn;
	}
	
	
	
	
	
	
	
	
	protected File createZipFile(String xmlFileName, String xmlContent, FullTextStruct fullText) throws FileNotFoundException, IOException {
		
		File zipFileDest = File.createTempFile("ori-oai-ext_zipTempFile-", ".zip");
		zipFileDest.deleteOnExit();
		
		List<String> fileNames = new LinkedList<String>();
		List<byte[]> fileContents = new LinkedList<byte[]>();
		
		fileNames.add(xmlFileName);
		fileContents.add(xmlContent.getBytes(Charsets.UTF_8));
		
		if (fullText!=null) {
			FileStruct[] files = fullText.getFiles();
			if (files!=null) {
				for (FileStruct file : files) {
					fileNames.add(file.getName());
					String base64FileContent = file.getContent();
					byte[] fileContent = Base64.decodeBase64(base64FileContent);
					
					fileContents.add(fileContent);
				}
			}
		}
		
		this.zipUtilsService.createZipFileFromFileBytesContent(zipFileDest, fileNames, fileContents);
		return zipFileDest;
	}

}
