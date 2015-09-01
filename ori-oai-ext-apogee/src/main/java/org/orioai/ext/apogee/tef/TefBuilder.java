package org.orioai.ext.apogee.tef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.orioai.ext.apogee.beans.Jury;
import org.orioai.ext.apogee.beans.Rapporteur;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.core.io.Resource;


public class TefBuilder {
	private Log4jLoggerAdapter log = 
			(Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());

	private Resource nationalityResource;
	private Resource listDiplomeResource;
	
	protected Map<String, String> nationalities = new HashMap<String, String>();
	protected Map<String, String> diplomes = new HashMap<String, String>();
	
	public TefBuilder() {
	}
	
	public void init() {
		readNationalityFromFile();
		readDiplomeListFromFile();
	}
	
	private String replaceXmlContent(String xmlContent, String attributeName, String attributeValue, Map<String, String> userAttributesParams) {
		if (attributeValue==null) {
			attributeValue="";
		}
		if (attributeValue.equals("")) {
			String userAttributeValue=userAttributesParams.get(attributeName);
			if (userAttributeValue!=null) {
				attributeValue=userAttributeValue;
			}
		}
		return xmlContent.replace("_"+attributeName+"_", attributeValue);
	}
	
	public String buildTef(TefDTO dto, String creator, String sudoc, String xmlContent, Map<String, String> userAttributesParams){
		String newXmlContent = xmlContent;
		
		newXmlContent = replaceXmlContent(newXmlContent, "CODE_THESE", dto.CODE_THESE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CREATOR", creator, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "TITRE", dto.TITRE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CODE_ETUDIANT", dto.CODE_ETUDIANT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "NOM_ETUDIANT", dto.NOM_ETUDIANT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "NOM_USUEL_ETUDIANT", dto.NOM_USUEL_ETUDIANT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "MAIL_PRO", makeAutoriteExterne("mailPro", dto.MAIL_PRO!=null ? dto.MAIL_PRO : userAttributesParams.get("MAIL_PRO")), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "MAIL_PERSO", makeAutoriteExterne("mailPerso", dto.MAIL_PERSO!=null ? dto.MAIL_PERSO : userAttributesParams.get("MAIL_PERSO")), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "PRENOM_ETUDIANT", dto.PRENOM_ETUDIANT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "DATE_NAISSANCE_ETUDIANT", dto.DATE_NAISSANCE_ETUDIANT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "NATIONALITE", getValueFromMap(nationalities, dto.NATIONALITE), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "DISCIPLINE", getValueFromMap(diplomes, dto.DISCIPLINE_WEB), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "DATE_SOUTENANCE", dto.DATE_SOUTENANCE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ETAB_SOUT", dto.LIBELLE_ETAB_SOUT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CODE_ETAB_SOUT", dto.CODE_ETAB_SOUT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "SUDOC", sudoc, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CODE_ECOLE_DOCTORALE", dto.CODE_ECOLE_DOCTORALE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CODE_ETAB_SOUT", dto.CODE_ETAB_SOUT, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "COTUTELLE", makeCotutelle(dto), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "TRAVAUX", dto.getTRAVAUX(), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "NOM_DIRECTEUR", dto.NOM_DIRECTEUR, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "PRENOM_DIRECTEUR", dto.PRENOM_DIRECTEUR, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CODIRECTEUR", makeCodirecteur(dto), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "JURY_LISTE_MEMBRES", makeJuries(dto), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "JURY_LISTE_RAPPORTEURS", makeRaporteures(dto), userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ECOLE_DOCTORALE", dto.LIBELLE_ECOLE_DOCTORALE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_EQUIPE_RECHERCHE", dto.LIBELLE_EQUIPE_RECHERCHE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CODE_EQUIPE_RECHERCHE", dto.CODE_EQUIPE_RECHERCHE, userAttributesParams);
		newXmlContent = replaceXmlContent(newXmlContent, "CONFIDENTIALITE", makeConfidentiality(dto), userAttributesParams);
		
		return newXmlContent;
	}
	
	
	private String makeAutoriteExterne(String autoriteSource, String value) {
		StringBuffer sb = new StringBuffer();
		if(value != null && !value.trim().equals("")){
			sb.append("<tef:autoriteExterne autoriteSource=\""+autoriteSource+"\">").append(value).append("</tef:autoriteExterne>");
		} else
			sb.append("");
		
		return sb.toString();
	}
	

	private String makeCotutelle(TefDTO dto){
		StringBuffer sb = new StringBuffer();
		String NOM_COTUTELLE = dto.getNOM_COTUTELLE();
		
		if(NOM_COTUTELLE != null){
			sb.append("<tef:thesis.degree.grantor>");
			sb.append("<tef:nom>").append(NOM_COTUTELLE).append("</tef:nom>");
			sb.append("<tef:autoriteInterne>thesis.degree.grantor_2</tef:autoriteInterne>");
			sb.append(makeAutoriteExterne("RNE", dto.getCODE_COTUTELLE()));
			sb.append("</tef:thesis.degree.grantor>");
		} else
			sb.append("");
		return sb.toString();
	}
	
	private String makeCodirecteur(TefDTO dto){
		StringBuffer sb = new StringBuffer();
		String NOM_CODIRECTEUR = dto.getNOM_CODIRECTEUR();
		
		if(NOM_CODIRECTEUR != null){
			sb.append("<tef:directeurThese>");
			sb.append("<tef:nom>").append(NOM_CODIRECTEUR).append("</tef:nom>");
			sb.append("<tef:prenom>").append(dto.getPRENOM_CODIRECTEUR()).append("</tef:prenom>")
			.append("</tef:directeurThese>");
		} else
			sb.append("");
		return sb.toString();
	}
	
	private String makeJuries(TefDTO dto){
		StringBuffer sb = new StringBuffer();
		List<Jury> juries = dto.getJuries();
		if(juries != null){
			int i = 0;
			for(Jury jury: juries) {
				if(i == 0)
					makeJury(jury, "tef:presidentJury", sb);
				else
					makeJury(jury, "tef:membreJury", sb);
				i++;
			}
		} else
			sb.append("");
		return sb.toString();
	}
	
	private void makeJury(Jury jury, String tag, StringBuffer sb){
		if(!jury.getNOM_JURY().equals("") && !jury.getPRENOM_JURY().equals("")){
			sb.append("<").append(tag).append(">");
			sb.append("<tef:nom>").append(jury.getNOM_JURY()).append("</tef:nom>");
			sb.append("<tef:prenom>").append(jury.getPRENOM_JURY()).append("</tef:prenom>");
			sb.append("</").append(tag).append(">");
		}
	}
	
	private String makeRaporteures(TefDTO dto) {
		StringBuffer sb = new StringBuffer();
		List<Rapporteur> rapporteurs = dto.getRapporteurs();
		if(rapporteurs != null){
			for(Rapporteur raporteur: rapporteurs) {
				
				if(!raporteur.getNOM_RAPPORTEUR().equals("") && !raporteur.getPRENOM_RAPPORTEUR().equals("")){
					sb.append("<tef:rapporteur>");
					sb.append("<tef:nom>").append(raporteur.getNOM_RAPPORTEUR()).append("</tef:nom>");
					sb.append("<tef:prenom>").append(raporteur.getPRENOM_RAPPORTEUR()).append("</tef:prenom>");
					sb.append("</tef:rapporteur>");
				}
			}
		}
		return sb.toString();
	}
	
	private String makeConfidentiality(TefDTO dto){
		StringBuffer sb = new StringBuffer();
		String DATE_FIN_CONFIDENTIALITE = dto.DATE_FIN_CONFIDENTIALITE;
		
		if(DATE_FIN_CONFIDENTIALITE != null){
			sb.append("<metsRights:Constraints CONSTRAINTTYPE=\"TIME\">");
			sb.append("<metsRights:ConstraintDescription>confidentialité ").append(dto.DATE_SOUTENANCE).append(" ").append(dto.DATE_FIN_CONFIDENTIALITE).append("</metsRights:ConstraintDescription>");
			sb.append("</metsRights:Constraints>");
		} else
			sb.append("");
		return sb.toString();
	}
	
	private String getValueFromMap(Map<String, String> map, String originalValue) {
		String value = map.get(originalValue);
		if (value!=null) {
			return value;
		}
		else {
			return originalValue;
		}
	}
	
	/////////////////////////////////////////////
	/**
	 * read nationalite.csv file 
	 */
	protected void readNationalityFromFile() {
		readFile(nationalityResource, nationalities);
	}
	
	/**
	 * read liste_diplome.csv file 
	 */
	protected void readDiplomeListFromFile() {
		readFile(listDiplomeResource, diplomes);
	}
	
	private void readFile(Resource fileResource, Map<String, String> map) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(fileResource.getInputStream(), "ISO-8859-1"));
			
			String strLine;
			while ((strLine = br.readLine()) != null) {
				String[] tmp = strLine.split(";");
				map.put(tmp[0], tmp[1]);
			}
			br.close();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	//////////////////////////////////////////////
	public void setNationalityResource(Resource nationalityResource) {
		this.nationalityResource = nationalityResource;
	}
	
	public void setListDiplomeResource(Resource listDiplomeResource) {
		this.listDiplomeResource = listDiplomeResource;
	}
	
	

}
