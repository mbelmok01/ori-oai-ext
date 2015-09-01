/**
 * 
 */
package org.orioai.ext.apogee.services.remote;

import gouv.education.apogee.commun.client.utils.WSUtils;
import gouv.education.apogee.commun.client.ws.administratifmetier.AdministratifMetierServiceInterface;
import gouv.education.apogee.commun.client.ws.administratifmetier.AdministratifMetierSoapBindingStub;
import gouv.education.apogee.commun.client.ws.etudiantmetier.EtudiantMetierServiceInterface;
import gouv.education.apogee.commun.client.ws.etudiantmetier.EtudiantMetierSoapBindingStub;
import gouv.education.apogee.commun.client.ws.thesemetier.TheseMetierServiceInterface;
import gouv.education.apogee.commun.client.ws.thesemetier.TheseMetierSoapBindingStub;
import gouv.education.apogee.commun.transverse.dto.etudiant.CoordonneesDTO2;
import gouv.education.apogee.commun.transverse.dto.etudiant.InfoAdmEtuDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.CoDirThsDTO2;
import gouv.education.apogee.commun.transverse.dto.pedagogique.JuryDTO;
import gouv.education.apogee.commun.transverse.dto.pedagogique.ListThesesDTO2;
import gouv.education.apogee.commun.transverse.dto.pedagogique.RapporteurDTO;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.xml.namespace.QName;

import org.apache.axis.AxisFault;
import org.orioai.ext.apogee.beans.Jury;
import org.orioai.ext.apogee.beans.Rapporteur;
import org.orioai.ext.apogee.tef.TefBuilder;
import org.orioai.ext.apogee.tef.TefDTO;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.AbstractWSOperation;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodExecutionException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Yohan Colmant
 *
 */
@Service
@Qualifier("apogee")
@NotMock
public class ApogeeGetTefFromUserId extends AbstractWSOperation {

	private Log4jLoggerAdapter log = 
			(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
	
	private @Value("${apogee.getTefFromUserId}") String opId;
	private @Value("${apogee.getTefFromUserId.etaThs}") String etaThs;

	@Autowired
	private TefBuilder tefBuilder;

	
	private enum ParameterName {
		USER_ID(ApogeeWebService.USER_ID),
		WS_USER(ApogeeWebService.WS_USER),
		WS_PASSWORD(ApogeeWebService.WS_PASSWORD),
		TEF_CREATOR(ApogeeWebService.TEF_CREATOR),
		TEF_SUDOC_ETAB_ID(ApogeeWebService.TEF_SUDOC_ETAB_ID),
		TEF_XML_CONTENT(ApogeeWebService.TEF_XML_CONTENT);

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
		
		// fill xml
		WSOperationBean result = new WSOperationBean();
		
		try {
			Map<String, String> userAttributesParams = new HashMap<String, String>();
			for (String key : wsMethodParams.keySet()) {
				if (key.startsWith(ApogeeWebService.USER_ATTRIBUTE_PREFIX)) {
					userAttributesParams.put(key.replaceFirst(ApogeeWebService.USER_ATTRIBUTE_PREFIX, ""), wsMethodParams.get(key));
				}
			}
			
			
			String xmlContent = makeTef(wsMethodParams.get(ApogeeWebService.TEF_CREATOR), wsMethodParams.get(ApogeeWebService.TEF_SUDOC_ETAB_ID), wsMethodParams.get(ApogeeWebService.USER_ID), wsMethodParams.get(ApogeeWebService.WS_USER), wsMethodParams.get(ApogeeWebService.WS_PASSWORD), wsMethodParams.get(ApogeeWebService.TEF_XML_CONTENT), userAttributesParams);
			//System.out.println("xmlContent="+xmlContent);
			if (xmlContent!=null) {
				result.put("xmlContent", xmlContent);
				result.put("successCode", "success");
			}
			else {
				log.warn(ApogeeWebService.USER_ID+"="+wsMethodParams.get(ApogeeWebService.USER_ID)+" :: xmlContent is NULL");
				
				MethodExecutionException extException = new MethodExecutionException(opId);
				String faultString = "Aucune these trouvee";
				String faultCode = getFaultCodeFromFaultString(faultString);
				extException.setFaultString(faultString);
				extException.setFaultCode(new QName(faultCode));
				extException.setFaultActor(wsMethodParams.get(ApogeeWebService.USER_ID));
				throw extException;
			}
		}
		catch (RemoteException e) {
			if (e instanceof AxisFault) {
				log.warn(ApogeeWebService.USER_ID+"="+wsMethodParams.get(ApogeeWebService.USER_ID)+" :: "+((AxisFault)e).getFaultString(), e);
				
				MethodExecutionException extException = new MethodExecutionException(opId);
				String faultString = ((AxisFault)e).getFaultString();
				String faultCode = faultString;
				if (faultCode.indexOf("java.net.UnknownHostException")!=-1) {
					faultCode = "java.net.UnknownHostException";
				}
				faultCode = getFaultCodeFromFaultString(faultString);
				extException.setFaultString(faultString);
				extException.setFaultCode(new QName(faultCode));
				extException.setFaultActor(wsMethodParams.get(ApogeeWebService.USER_ID));
				throw extException;
			}
			else {
				log.warn(ApogeeWebService.USER_ID+"="+wsMethodParams.get(ApogeeWebService.USER_ID)+" :: "+e.getMessage(), e);
				
				MethodExecutionException extException = new MethodExecutionException(opId);
				String faultString = e.getMessage();
				String faultCode = getFaultCodeFromFaultString(faultString);
				extException.setFaultString(faultString);
				extException.setFaultCode(new QName(faultCode));
				extException.setFaultActor(wsMethodParams.get(ApogeeWebService.USER_ID));
				throw extException;
			}
		}
		catch (WebBaseException e) {
			log.warn(ApogeeWebService.USER_ID+"="+wsMethodParams.get(ApogeeWebService.USER_ID)+" :: "+e.getLastErrorMsg(), e);
			
			MethodExecutionException extException = new MethodExecutionException(opId, true);
			String faultString = e.getLastErrorMsg();
			String faultCode = getFaultCodeFromFaultString(faultString);
			extException.setFaultString(faultString);
			extException.setFaultCode(new QName(faultCode));
			extException.setFaultActor(wsMethodParams.get(ApogeeWebService.USER_ID));
			throw extException;
		}
		
		return result;
	}
	
	
	@Override
	public String getOpId() {
		return this.opId;
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	private Date convertApogeeDateToDate(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try  {
			return sdf.parse(sDate);
		}
		catch(ParseException e) {
			return null;
		}
	}
	
	private String formatDateToTef(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	
	protected void convertToDTO(Object obj, TefDTO dto) {
		ListThesesDTO2 these = (ListThesesDTO2) obj;
		
		dto.CODE_ETUDIANT = these.getCodEtu() + "";
		dto.TITRE = these.getLibThs();
		dto.CODE_THESE = these.getCodThs() + "";
		
		if(these.getSuiviThese() != null){
			if(these.getSuiviThese().getSouThs() != null && these.getSuiviThese().getSouThs().getDatSouThs() != null) {
				dto.DATE_SOUTENANCE = formatDateToTef(convertApogeeDateToDate(these.getSuiviThese().getSouThs().getDatSouThs()));
			}
				
			if(these.getSuiviThese().getDatFinCfdThs() != null) {
				dto.DATE_FIN_CONFIDENTIALITE = formatDateToTef(convertApogeeDateToDate(these.getSuiviThese().getDatFinCfdThs()));
			}
			
			if(these.getSuiviThese().getSouThs() != null && these.getSuiviThese().getSouThs().getEtbSouThs() != null 
					&& these.getSuiviThese().getSouThs().getEtbSouThs().getLibEtb() != null)
				dto.LIBELLE_ETAB_SOUT = these.getSuiviThese().getSouThs().getEtbSouThs().getLibEtb();
			
			if(these.getSuiviThese().getSouThs() != null && these.getSuiviThese().getSouThs().getEtbSouThs() != null
					&& these.getSuiviThese().getSouThs().getEtbSouThs().getCodEtb() != null)
				dto.CODE_ETAB_SOUT = these.getSuiviThese().getSouThs().getEtbSouThs().getCodEtb();
		}
		
		if(these.getDiplome() != null && these.getDiplome().getLibDip() != null)
			dto.DISCIPLINE = these.getDiplome().getLibDip();
		
		if(these.getDiplome() != null && these.getDiplome().getLibWebVdi() != null)
			dto.DISCIPLINE_WEB = these.getDiplome().getLibWebVdi();

		if(these.getType() != null && these.getType().getLibThsTrv() != null)
			dto.TYPE = these.getType().getLibThsTrv();
		
		if(these.getEncThs() != null && these.getEncThs().getDirThs() != null && these.getEncThs().getDirThs().getLibNomPatPer() != null)
			dto.NOM_DIRECTEUR = these.getEncThs().getDirThs().getLibNomPatPer();
		
		if(these.getEncThs() != null && these.getEncThs().getDirThs() != null && these.getEncThs().getDirThs().getLibPr1Per() != null)
			dto.PRENOM_DIRECTEUR = these.getEncThs().getDirThs().getLibPr1Per();
		
		if(these.getEncThs() != null && these.getEncThs().getListCoDirThs() != null && these.getEncThs().getListCoDirThs().length>0) {
			CoDirThsDTO2 coDir1 = these.getEncThs().getListCoDirThs()[0];
			if (coDir1.getLibNomPatPer() != null) {
				dto.NOM_CODIRECTEUR = coDir1.getLibNomPatPer();
			}
			if (coDir1.getLibPr1Per() != null) {
				dto.PRENOM_CODIRECTEUR = coDir1.getLibPr1Per();
			}
		}
		
		if (these.getSuiviThese()!=null) {
			if (these.getSuiviThese().getListJury() != null && these.getSuiviThese().getListJury().length>0) {
				List<Jury> juryList = new LinkedList<Jury>();
				for (JuryDTO juryDto : these.getSuiviThese().getListJury()) {
					Jury jury = new Jury(juryDto.getLibNomPatPerJur(), juryDto.getLibPr1PerJur());
					juryList.add(jury);
				}
				dto.setJuries(juryList);
			}
			
			if (these.getSuiviThese().getListRapporteur() != null && these.getSuiviThese().getListRapporteur().length>0) {
				List<Rapporteur> rapporteurList = new LinkedList<Rapporteur>();
				for (RapporteurDTO rapporteurDto : these.getSuiviThese().getListRapporteur()) {
					Rapporteur rapporteur = new Rapporteur(rapporteurDto.getLibNomPatPerRap(), rapporteurDto.getLibPr1PerRap());
					rapporteurList.add(rapporteur);
				}
				dto.setRapporteurs(rapporteurList);
			}
		}
		
		if(these.getEcoleDoctorale() != null && these.getEcoleDoctorale().getLibEcolDoct() != null)
			dto.LIBELLE_ECOLE_DOCTORALE = these.getEcoleDoctorale().getLibEcolDoct();
		
		if(these.getEcoleDoctorale() != null && these.getEcoleDoctorale().getCodEcolDoct() != null)
			dto.CODE_ECOLE_DOCTORALE = these.getEcoleDoctorale().getCodEcolDoct();
		
		if(these.getEquipeRch() != null && these.getEquipeRch().getLibEqRch() != null)
			dto.LIBELLE_EQUIPE_RECHERCHE = these.getEquipeRch().getLibEqRch();
		
		if(these.getEquipeRch() != null && these.getEquipeRch().getCodEqRch() != null)
			dto.CODE_EQUIPE_RECHERCHE = these.getEquipeRch().getCodEqRch();
	}
	
	protected void convertToDTO(InfoAdmEtuDTO etudiant, TefDTO dto) {
		String nom = etudiant.getNomUsuel();
		String nomDeNaissance = etudiant.getNomPatronymique();
		if (nom==null || nom.trim().equals("")) {
			dto.NOM_USUEL_ETUDIANT = nomDeNaissance;
		}
		else {
			dto.NOM_ETUDIANT = nomDeNaissance;
			dto.NOM_USUEL_ETUDIANT = nom;
		}
		
		dto.PRENOM_ETUDIANT = etudiant.getPrenom1();
		dto.CODE_INE = etudiant.getNumeroINE()+etudiant.getCleINE();
		
		if(etudiant.getNationaliteDTO() != null && etudiant.getNationaliteDTO().getCodeNationalite() != null)
			dto.NATIONALITE = etudiant.getNationaliteDTO().getCodeNationalite();
		
		if(etudiant.getDateNaissance() != null) {
			dto.DATE_NAISSANCE_ETUDIANT = formatDateToTef(etudiant.getDateNaissance());
		}
	}
	
	protected void convertToDTO(CoordonneesDTO2 coordonneesEtudiant, TefDTO dto) {
		dto.MAIL_PRO = coordonneesEtudiant.getEmailAnnuaire();
		dto.MAIL_PERSO = coordonneesEtudiant.getEmail();
	}
	
	
	private ListThesesDTO2[] readApogeeThese(String codEtu, String wsUser, String wsPassword) throws RemoteException, WebBaseException {
		//System.out.println("===== readApogeeThese 1");
		ListThesesDTO2[] theses = null;
		//System.out.println("===== readApogeeThese 2");
		//System.out.println("===== readApogeeThese 3");
		TheseMetierServiceInterface theseMetierService2 = null;
		if (wsUser!=null && wsUser.trim().equals("") && wsPassword!=null && wsPassword.trim().equals("")) {
			theseMetierService2 = (TheseMetierSoapBindingStub) WSUtils.getService(WSUtils.THESE_SERVICE_NAME, null, null);
		}
		else {
			theseMetierService2 = (TheseMetierSoapBindingStub) WSUtils.getService(WSUtils.THESE_SERVICE_NAME, wsUser, wsPassword);
		}
		//System.out.println("===== readApogeeThese 4");
		theses = theseMetierService2.recupererDonneesTheses_v2(codEtu, etaThs, null);
		//System.out.println("========= theses="+theses);
		/*if (theses!=null) {
			for (ListThesesDTO2 these :theses) {
				try {
					System.out.println(IntrospectionUtils.afficherAttributsParIntrospection(these, 0));
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println("===== readApogeeThese 5");*/
		
		return theses;
	}
	
	private InfoAdmEtuDTO readEtudiant(String codEtu, String wsUser, String wsPassword) throws RemoteException {
		InfoAdmEtuDTO result = new InfoAdmEtuDTO();
		
		EtudiantMetierServiceInterface etudianService = null;
		if (wsUser!=null && wsUser.trim().equals("") && wsPassword!=null && wsPassword.trim().equals("")) {
			etudianService = (EtudiantMetierSoapBindingStub) WSUtils.getService(WSUtils.ETUDIANT_SERVICE_NAME, null, null);
		}
		else {
			etudianService = (EtudiantMetierSoapBindingStub) WSUtils.getService(WSUtils.ETUDIANT_SERVICE_NAME, wsUser, wsPassword);
		}
		result = etudianService.recupererInfosAdmEtu(codEtu);
		
		/*try {
			System.out.println(IntrospectionUtils.afficherAttributsParIntrospection(result, 0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		return result;
	}
	
	private CoordonneesDTO2 readCoordonneesEtudiant(String codEtu, String wsUser, String wsPassword) throws RemoteException {
		CoordonneesDTO2 result = new CoordonneesDTO2();
		
		AdministratifMetierServiceInterface administratifService = null;
		if (wsUser!=null && wsUser.trim().equals("") && wsPassword!=null && wsPassword.trim().equals("")) {
			administratifService = (AdministratifMetierSoapBindingStub) WSUtils.getService(WSUtils.ADMINISTRATIF_SERVICE_NAME, null, null);
		}
		else {
			administratifService = (AdministratifMetierSoapBindingStub) WSUtils.getService(WSUtils.ADMINISTRATIF_SERVICE_NAME, wsUser, wsPassword);
		}
		String[] annees =  administratifService.recupererAnneesIa(codEtu, null);
		TreeSet<String> sortedAnnees = new TreeSet<String>();
		for (String annee : annees) {
			sortedAnnees.add(annee);
		}
		String anneeDernierInscThese = sortedAnnees.last();
		
		
		EtudiantMetierServiceInterface etudianService = null;
		if (wsUser!=null && wsUser.trim().equals("") && wsPassword!=null && wsPassword.trim().equals("")) {
			etudianService = (EtudiantMetierSoapBindingStub) WSUtils.getService(WSUtils.ETUDIANT_SERVICE_NAME, null, null);
		}
		else {
			etudianService = (EtudiantMetierSoapBindingStub) WSUtils.getService(WSUtils.ETUDIANT_SERVICE_NAME, wsUser, wsPassword);
		}
		result = etudianService.recupererAdressesEtudiant_v2(codEtu, anneeDernierInscThese, null);
		
		/*try {
			System.out.println(IntrospectionUtils.afficherAttributsParIntrospection(result, 0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		return result;
	}
	
	
	
	public String makeTef(String creator, String sudoc, String codEtu, String wsUser, String wsPassword, String xmlContent, Map<String, String> userAttributesParams) throws RemoteException, WebBaseException {
		String newXmlContent = null;
		
		//System.out.println("===== makeThese 1");
		ListThesesDTO2[] theses = readApogeeThese(codEtu, wsUser, wsPassword);
		//System.out.println("===== makeThese 2");
		if (theses!=null && theses.length>0) {
			//System.out.println("===== makeThese 3 :: theses="+theses);
			ListThesesDTO2 these = theses[0];
 			//System.out.println("===== makeThese 5 ::        these="+these);
 			
 			//System.out.println("===== makeThese 5 ::        these.getSuiviThese()="+these.getSuiviThese());
 			if (these.getSuiviThese()!=null) {
 				//System.out.println("===== makeThese 5 ::        these.getSuiviThese().getSouThs()="+these.getSuiviThese().getSouThs());
 				if (these.getSuiviThese().getSouThs()!=null) {
 					//System.out.println("===== makeThese 5 ::        these.getSuiviThese().getSouThs()="+these.getSuiviThese().getSouThs().getTemAutSouThs());
 				}
 			}
 			
 			if(these.getSuiviThese() !=null && these.getSuiviThese().getSouThs() != null && 
 					these.getSuiviThese().getSouThs().getTemAutSouThs() != null &&  
 					these.getSuiviThese().getSouThs().getTemAutSouThs().equals("O")){
 				//System.out.println("===== makeThese 5 ::        OK !");
 				InfoAdmEtuDTO etudiant = readEtudiant(these.getCodEtu()+"", wsUser, wsPassword);
 				CoordonneesDTO2 coordonneesEtudiant = readCoordonneesEtudiant(these.getCodEtu()+"", wsUser, wsPassword);
 				
 				TefDTO dto = new TefDTO();
 				convertToDTO(etudiant, dto);
 	 			convertToDTO(these, dto);
 	 			convertToDTO(coordonneesEtudiant, dto);
 	 			//System.out.println("tefBuilder="+tefBuilder);
 	 			newXmlContent = tefBuilder.buildTef(dto, creator, sudoc, xmlContent, userAttributesParams);
 			}
		}
		else {
			newXmlContent = null;
		}
		
		return newXmlContent;
	}
	
	
	
	
	
	
	
}
