package org.orioai.ext.physalis.tef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.core.io.Resource;

public class TefBuilder {
    
    private Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
    private Resource nationalityResource;
    private Resource listDiplomeResource;
    protected Map<String, String> nationalities = new HashMap<String, String>();
    protected Map<String, String> diplomes = new HashMap<String, String>();
    
    /**
     * Default construct
     */
    public TefBuilder() {
    }
    
    /**
     * The init() method is started by the browser when the Java program is loaded and run by the browser.
     */
    public void init() {
    }
    
    /**
     * Used to replace value into xml file using pattern _attribute_
     * @param xmlContent
     * @param attributeName
     * @param attributeValue
     * @param userAttributesParams
     * @return 
     */
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
    
    /**
     * Build tef file with assembled informations
     * @param dto Data Transfer Object (informations about a Phd student and it's thesis)
     * @param creator
     * @param sudoc sudoc id
     * @param xmlContent xml received from the workflow module
     * @param userAttributesParams received parameters
     * @param attributes HashMap containing all the information (complementary with the object dto
     * @return a new xml file completed
     * @throws JSONException 
     */
    public String buildTef(TefDTO dto, String creator, String sudoc, String xmlContent, Map<String, String> userAttributesParams, HashMap<String, String> attributes) throws JSONException {
        
        String newXmlContent = xmlContent;
        
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_THESE", dto.CODE_THESE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CREATOR", creator, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "TITRE", dto.TITRE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_ETUDIANT", attributes.get("ETUD_NUMERO"), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NOM_USUEL_ETUDIANT", dto.NOM_USUEL_ETUDIANT, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NOM_ETUDIANT", dto.NOM_ETUDIANT, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "PRENOM_ETUDIANT", dto.PRENOM_ETUDIANT, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DATE_NAISSANCE_ETUDIANT", dto.DATE_NAISSANCE_ETUDIANT, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NATIONALITE", dto.NATIONALITE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "MAIL_PERSO", makeAutoriteExterne("mailPerso", dto.MAIL_PERSO!=null ? dto.MAIL_PERSO : userAttributesParams.get("MAIL_PERSO")), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "MAIL_PRO", makeAutoriteExterne("mailPro", dto.MAIL_PRO), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DATE_SOUTENANCE", dto.DATE_SOUTENANCE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DISCIPLINE", dto.DISCIPLINE_WEB, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ETAB_SOUT", dto.LIBELLE_ETAB_SOUT, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "SUDOC", sudoc, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "TRAVAUX", "non", userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NOM_DIRECTEUR", dto.NOM_DIRECTEUR, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "PRENOM_DIRECTEUR", dto.PRENOM_DIRECTEUR, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "JURY_LISTE_MEMBRES", makeJury(attributes.get("MEMBRES_JURY")), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "JURY_LISTE_RAPPORTEURS", makeRapporteurs(attributes.get("MEMBRES_JURY")), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "RESUME_FR", attributes.get("RESUME_FR"), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ECOLE_DOCTORALE", dto.LIBELLE_ECOLE_DOCTORALE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_ECOLE_DOCTORALE", dto.CODE_ECOLE_DOCTORALE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ECOLE_DOCTORALE", dto.LIBELLE_ECOLE_DOCTORALE, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_ECOLE_DOCTORALE", dto.CODE_ECOLE_DOCTORALE, userAttributesParams);
        
        // newXmlContent = replaceXmlContent(newXmlContent, "COTUTELLE", makeCotutelle(dto), userAttributesParams);
        // newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_EQUIPE_RECHERCHE", dto.LIBELLE_EQUIPE_RECHERCHE, userAttributesParams);
        // newXmlContent = replaceXmlContent(newXmlContent, "CODE_EQUIPE_RECHERCHE", dto.CODE_EQUIPE_RECHERCHE, userAttributesParams); 
        // newXmlContent = replaceXmlContent(newXmlContent, "CONFIDENTIALITE", makeConfidentiality(dto), userAttributesParams);
        
        return newXmlContent;
    }
    
    /**
     * build jury xml snippet
     * @param str
     * @return a tag containing all members of the jury
     * @throws JSONException 
     */
    private String makeJury(String str) throws JSONException{
        
        StringBuffer sb = new StringBuffer();
        
        JSONArray obj = new JSONArray(str);
        
        for(int i=0; i< obj.length(); i++){
            JSONObject j = obj.getJSONObject(i);
            
           if(j.getString("role").equals("D_JR_PRES")){
                sb.append("<").append("tef:presidentJury").append(">");
                sb.append("<tef:nom>").append(j.get("nom")).append("</tef:nom>");
                sb.append("<tef:prenom>").append(j.get("prenom")).append("</tef:prenom>");
                sb.append("</").append("tef:presidentJury").append(">");
                
            } else if(j.getString("role").equals("D_JR_MEM")){
                // si autre
                sb.append("<").append("tef:membreJury").append(">");
                sb.append("<tef:nom>").append(j.get("nom")).append("</tef:nom>");
                sb.append("<tef:prenom>").append(j.get("prenom")).append("</tef:prenom>");
                sb.append("</").append("tef:membreJury").append(">");
            }
        }
        return sb.toString();
    }
    
    /**
     * build protractor xml snippet
     * @param str
     * @return
     * @throws JSONException 
     */
    private String makeRapporteurs(String str) throws JSONException{
        StringBuffer sb = new StringBuffer();
        
        JSONArray obj = new JSONArray(str);
        
        for(int i=0; i< obj.length(); i++){
            JSONObject j = obj.getJSONObject(i);
            
            if (j.getString("role").equals("D_JURY_RAP")){
                sb.append("<tef:rapporteur>");
                sb.append("<tef:nom>").append(j.get("nom")).append("</tef:nom>");
                sb.append("<tef:prenom>").append(j.get("prenom")).append("</tef:prenom>");
                sb.append("</tef:rapporteur>");
            }
        }
        return sb.toString();
    }
    
    /**
     * build AutoriteExterne xml snippet
     * @param autoriteSource
     * @param value
     * @return 
     */
    private String makeAutoriteExterne(String autoriteSource, String value) {
        StringBuffer sb = new StringBuffer();
        if(value != null && !value.trim().equals("")){
            sb.append("<tef:autoriteExterne autoriteSource=\""+autoriteSource+"\">").append(value).append("</tef:autoriteExterne>");
        } else
            sb.append("");
        
        return sb.toString();
    }
    
    /**
     * build cotutelle xml snippet
     * @param dto
     * @return 
     */
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
    
    /**
     * build Confidentiality xml snippet
     * @param dto
     * @return 
     */
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
    
    //////////////////////////////////////////////
    
    /**
     * 
     * @param map
     * @param originalValue
     * @return 
     */
    private String getValueFromMap(Map<String, String> map, String originalValue) {
        String value = map.get(originalValue);
        if (value!=null) {
            return value;
        }
        else {
            return originalValue;
        }
    }
    
    protected void readNationalityFromFile() {
        readFile(nationalityResource, nationalities);
    }
    
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
    
    public void setNationalityResource(Resource nationalityResource) {
        this.nationalityResource = nationalityResource;
    }
    
    public void setListDiplomeResource(Resource listDiplomeResource) {
        this.listDiplomeResource = listDiplomeResource;
    }
}
