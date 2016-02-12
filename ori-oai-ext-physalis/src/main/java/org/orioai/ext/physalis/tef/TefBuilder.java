package org.orioai.ext.physalis.tef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jettison.json.JSONException;
import org.orioai.ext.physalis.beans.DirecteurThese;
import org.orioai.ext.physalis.beans.MembreJury;
import org.orioai.ext.physalis.beans.EtablissementCotutelle;
import org.orioai.ext.physalis.beans.These;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.core.io.Resource;


/**
 * @author Yohan Colmant
 * @author Mohamed Belmokhtar
 *
 */

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
    public String buildTef(String creator, String sudoc, String xmlContent, Map<String, String> userAttributesParams, These thesisObject) throws JSONException {
        
        String newXmlContent = xmlContent;
        
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_THESE", thesisObject.getID_THESE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CREATOR", creator, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "TITRE", thesisObject.getSUJET_THESE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_ETUDIANT", thesisObject.getETUD_NUMERO(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NOM_USUEL_ETUDIANT", thesisObject.getNOM_USUEL(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NOM_ETUDIANT", thesisObject.getNOM_PATRONYMIQUE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "PRENOM_ETUDIANT", thesisObject.getPRENOM(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DATE_NAISSANCE_ETUDIANT", thesisObject.getDATE_NAISSANCE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "NATIONALITE", thesisObject.getL_NATIONALITE(), userAttributesParams);
        //newXmlContent = replaceXmlContent(newXmlContent, "MAIL_PERSO", makeAutoriteExterne("mailPerso", thesisObject.getGetADRESSE_MAIL_Pro()!=null ? thesisObject.getADRESSE_MAIL() : userAttributesParams.get("MAIL_PERSO")), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "MAIL_PRO", thesisObject.getADRESSE_MAIL_Pro(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DATE_SOUTENANCE", thesisObject.getDATE_SOUTENANCE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DISCIPLINE", thesisObject.getDS_LIBELLE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ETAB_SOUT", thesisObject.getLIEU_SOUTENANCE(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "SUDOC", sudoc, userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "DIRECTEUR", makeDirecteurThese(thesisObject.getSupervisor()), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "TRAVAUX", "non", userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "JURY_LISTE_MEMBRES", makeMembreJuryThese(thesisObject.getMEMBRES_JURY()), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "JURY_LISTE_RAPPORTEURS", makeRapporteurThese(thesisObject.getMEMBRES_JURY()), userAttributesParams);   
        newXmlContent = replaceXmlContent(newXmlContent, "RESUME_FR", thesisObject.getRESUME_FR(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_ECOLE_DOCTORALE", thesisObject.getDoctoralSchool().getFDIP_MENTION(), userAttributesParams);
        newXmlContent = replaceXmlContent(newXmlContent, "CODE_ECOLE_DOCTORALE", thesisObject.getDoctoralSchool().getFD_FDIP_CODE(), userAttributesParams);
        //newXmlContent = replaceXmlContent(newXmlContent, "COTUTELLE", makeCotutelle(thesisObject.getEtab_cotutelle()), userAttributesParams);
        
        // newXmlContent = replaceXmlContent(newXmlContent, "LIBELLE_EQUIPE_RECHERCHE", dto.LIBELLE_EQUIPE_RECHERCHE, userAttributesParams);
        // newXmlContent = replaceXmlContent(newXmlContent, "CODE_EQUIPE_RECHERCHE", dto.CODE_EQUIPE_RECHERCHE, userAttributesParams); 
        
        return newXmlContent;
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
    
    private String makeDirecteurThese(ArrayList<DirecteurThese> dt){
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i<dt.size();i++){
            sb.append("<tef:directeurThese><tef:nom>").append(dt.get(i).getNom()).append("</tef:nom><tef:prenom>").append(dt.get(i).getPrenom()).append("</tef:prenom></tef:directeurThese>");
        }
        
        return sb.toString();
    }
    
    private String makeRapporteurThese(ArrayList<MembreJury> al){
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i<al.size();i++){
            if(al.get(i).getStatus().equalsIgnoreCase("D_JURY_RAP"))
            sb.append("<tef:rapporteur><tef:nom>").append(al.get(i).getNom()).append("</tef:nom><tef:prenom>").append(al.get(i).getPrenom()).append("</tef:prenom></tef:rapporteur>");
        }
        
        System.out.println("SB : "+sb.toString());
        return sb.toString();
        
                
    }
    
    private String makeMembreJuryThese(ArrayList<MembreJury> al){
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i<al.size();i++){
            System.out.println("Status : " +al.get(i).getStatus());
            
            if(al.get(i).getStatus().equalsIgnoreCase("D_JR_MEM") || al.get(i).getStatus().equalsIgnoreCase("D_JR_PRES"))
            sb.append("<tef:membreJury><tef:nom>").append(al.get(i).getNom()).append("</tef:nom><tef:prenom>").append(al.get(i).getPrenom()).append("</tef:prenom></tef:membreJury>");
        }
        
        System.out.println("SB : "+sb.toString());
        return sb.toString();
    }
    
    private String makeCoDirecteurThese(ArrayList<DirecteurThese> dt){
        StringBuffer sb = new StringBuffer();
        
        if(dt.size()>1){
            
            for(int i = 1; i<dt.size();i++){
                sb.append("<tef:directeurThese><tef:nom>").append(dt.get(i).getNom()).append("</tef:nom><tef:prenom>").append(dt.get(i).getPrenom()).append("</tef:prenom>");
            }
        }
        return sb.toString();
    }
    
    
    private String makeCotutelle(ArrayList<EtablissementCotutelle> ec){
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<ec.size(); i++){
            sb.append("<tef:thesis.degree.grantor>");
            sb.append("<tef:nom>").append(ec.get(i).getnOM_COTUTELLE()).append("</tef:nom>");
            sb.append("<tef:autoriteInterne>thesis.degree.grantor_2</tef:autoriteInterne>");
            sb.append(makeAutoriteExterne("RNE", ec.get(i).getcODE_COTUTELLE()));
            sb.append("</tef:thesis.degree.grantor>");
        }
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
