/**
 *
 */
package org.orioai.ext.physalis.services.remote;

import gouv.education.apogee.commun.transverse.dto.etudiant.InfoAdmEtuDTO;
import gouv.education.apogee.commun.transverse.exception.WebBaseException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.AbstractWSOperation;
import org.orioai.ext.physalis.tef.TefBuilder;
import org.orioai.ext.physalis.tef.TefDTO;
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
@Qualifier("physalis")
@NotMock
public class PhysalisGetTefFromUserId extends AbstractWSOperation {
    
    private Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());
    
    private @Value("${physalis.getTefFromUserId}") String opId;
    private @Value("${physalis.getTefFromUserId.etaThs}") String etaThs;
    
    @Autowired
    private TefBuilder tefBuilder;
    
    private enum ParameterName {
        USER_ID(PhysalisWebService.USER_ID),
        WS_USER(PhysalisWebService.WS_USER),
        WS_PASSWORD(PhysalisWebService.WS_PASSWORD),
        TEF_CREATOR(PhysalisWebService.TEF_CREATOR),
        TEF_SUDOC_ETAB_ID(PhysalisWebService.TEF_SUDOC_ETAB_ID),
        TEF_XML_CONTENT(PhysalisWebService.TEF_XML_CONTENT),
        URL(PhysalisWebService.URL),
        USER(PhysalisWebService.USER),
        PASSWORD(PhysalisWebService.PASSWORD);
        
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
    
    Connection conn;
    Statement state;
    ResultSet queryResult;
    HashMap<String, String> attributes = new HashMap<String, String>();
    
    
    @Override
    public WSOperationBean execute(Map<String, String> wsMethodParams) throws MethodExecutionException {
        
        // checking parameters
        checkParameters(opId, ParameterName.getValues(), wsMethodParams);
        
        // fill xml
        WSOperationBean result = new WSOperationBean();
        
        try {
            Map<String, String> userAttributesParams = new HashMap<String, String>();
            for (String key : wsMethodParams.keySet()) {
                if (key.startsWith(PhysalisWebService.USER_ATTRIBUTE_PREFIX)) {
                    userAttributesParams.put(key.replaceFirst(PhysalisWebService.USER_ATTRIBUTE_PREFIX, ""), wsMethodParams.get(key));
                }
            }
            
            this.connexionBD(wsMethodParams);
            ResultSet queryResult = this.getTheseInfo();
            ResultSetMetaData resultMeta = queryResult.getMetaData();
            HashMap<String, String> attributes = this.parseQueryResult(queryResult);
            
            String xmlContent = makeTef(wsMethodParams.get(PhysalisWebService.TEF_CREATOR), wsMethodParams.get(PhysalisWebService.TEF_SUDOC_ETAB_ID), wsMethodParams.get(PhysalisWebService.USER_ID), wsMethodParams.get(PhysalisWebService.WS_USER), wsMethodParams.get(PhysalisWebService.WS_PASSWORD), wsMethodParams.get(PhysalisWebService.TEF_XML_CONTENT), userAttributesParams, attributes);
            
            System.out.println("xmlContent = "+xmlContent);
            
            if (xmlContent!=null) {
                result.put("xmlContent", xmlContent);
                result.put("successCode", "success");
            }
            else {
                log.warn(PhysalisWebService.USER_ID+"="+wsMethodParams.get(PhysalisWebService.USER_ID)+" :: xmlContent is NULL");
            }
        }
        catch (WebBaseException e) {
            e.printStackTrace();
            log.warn(PhysalisWebService.USER_ID+"="+wsMethodParams.get(PhysalisWebService.USER_ID)+" :: "+e.getLastErrorMsg(), e);
        } catch (SQLException ex) {
            Logger.getLogger(PhysalisGetTefFromUserId.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(PhysalisGetTefFromUserId.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(PhysalisGetTefFromUserId.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    @Override
    public String getOpId() {
        return this.opId;
    }
    
    /**
     * Create a new connection to the database.
     * The connexion stays opened during the process.
     */
    public void connexionBD(Map<String, String> wsMethodParams){
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(wsMethodParams.get(PhysalisWebService.URL), wsMethodParams.get(PhysalisWebService.USER), wsMethodParams.get(PhysalisWebService.PASSWORD));
            
            state = conn.createStatement();
            
        }catch(Exception e){
            System.out.println("Echec de la connexion à la base de données : " + wsMethodParams.get(PhysalisWebService.URL));
            System.out.println(e);
        }
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    private ResultSet getTheseInfo() throws SQLException {
        
        String query = "select * from INFORMATIONS_DOCTORANT WHERE NOM_USUEL LIKE '%BELMOKHTAR%' AND PRENOM LIKE '%MOHA%'";
        
        try{
            queryResult = state.executeQuery(query);
        }catch(Exception e) {
            queryResult = null;
            System.out.println("La requête pour récupérer les information concernant une thèse a échoué : " + e.toString());
        }
        return queryResult;
    }
    
    /**
     *
     * @param str Responds to thesis identifier
     * @throws SQLException
     */
    private void getDirecteurThese(String str) throws SQLException {
        
        ResultSet queryResult = null;
        
        String query = "Select * from GRHUM.DIRECTEUR_THESE GDT WHERE GDT.ID_THESE ="+ str;
        
        try{
            queryResult = state.executeQuery(query);
            
            while(queryResult.next()){
                
                String nom_directeur = queryResult.getString("PERS_NOMPTR");
                String prenom_directeur = queryResult.getString("PERS_LC");
                
                attributes.put("NOM_DIRECTEUR", nom_directeur);
                attributes.put("PRENOM_DIRECTEUR", prenom_directeur);
            }
            
        }catch(Exception e){
            System.out.println("La requete pour récupérer les informations concernant le directeur a échoué : " + e);
        }
    }
    
    /**
     * 
     * @param str
     * @throws SQLException 
     */
    private void getEcoleDoctorale(String str) throws SQLException {
        
        ResultSet queryResult = null;
        
        String query = "select * from GRHUM.ECOLE_DOCTORALE_THESE where ID_THESE =" + str;
        
        try{
            queryResult = state.executeQuery(query);
            while(queryResult.next()){
                
                String elecoleDoc = queryResult.getString("FDIP_MENTION");
                String ecoleDocCode = queryResult.getString("FD.FDIP_CODE");
                
                attributes.put("FDIP_MENTION", elecoleDoc);
                attributes.put("FDIP_CODE", ecoleDocCode);
            }
        }catch(Exception e){
            System.out.println("La requete pour récupérer l'école doctorale a échoué : " + e);
        }
    }
    
    /**
     * converts the QueryResult into a map
     * @param queryResult
     * @return HashMap <attribute, value>
     * @throws SQLException
     */
    public HashMap<String, String> parseQueryResult(ResultSet queryResult) throws SQLException {
        
        while(queryResult.next()){
            
            try{
                String id_these = String.valueOf(queryResult.getInt("ID_THESE"));
                attributes.put("ID_THESE", id_these);
            }catch(Exception e){
                System.out.println("Le champs ID_THESE est vide");
            }
            
            try{
                String sujet_these = queryResult.getString("SUJET_THESE");
                attributes.put("SUJET_THESE", sujet_these);
            }catch(Exception e){
                System.out.println("Le champs SUJET_THESE est vide");
            }
            
            try{
                String etud_numero = String.valueOf(queryResult.getInt("ETUD_NUMERO"));
                attributes.put("ETUD_NUMERO", etud_numero);
            }catch(Exception e){
                System.out.println("Le champs ID_THESE est vide");
            }
            
            try{
                String nom_patronymique =  queryResult.getString("NOM_PATRONYMIQUE");
                attributes.put("NOM", nom_patronymique);
            }catch(Exception e){
                System.out.println("Le champs NOM_PATRONYMIQUE est vide.");
            }
            
            try{
                String nom_usuel =  queryResult.getString("NOM_USUEL");
                attributes.put("NOM_USUEL", nom_usuel);
            }catch(Exception e){
                System.out.println("Le champs NOM_USUEL est vide.");
            }
            
            try{
                String prenom = queryResult.getString("PRENOM");
                attributes.put("PRENOM", prenom);
            }catch(Exception e){
                System.out.println("Le champs PRENOM est vide.");
            }
            
            try{
                String etud_code_ine = queryResult.getString("ETUD_CODE_INE");
                attributes.put("ETUD_CODE_INE", etud_code_ine);
            }catch(Exception e){
                System.out.println("Le champs ETUD_CODE_INE est vide.");
            }
            
            try{
                String date_naissance = queryResult.getDate("DATE_NAISSANCE").toString();
                attributes.put("DATE_NAISSANCE", date_naissance);
            }catch(Exception e){
                System.out.println("Le champs DATE_NAISSANCE est vide");
            }
            
            try{
                String nationalite = queryResult.getString("L_NATIONALITE");
                attributes.put("L_NATIONALITE", nationalite);
            }catch(Exception e){
                System.out.println("Le champs NATIONALITE est vide.");
            }
            
            try{
                String resume_fr = queryResult.getString("RESUME_FR");
                attributes.put("RESUME_FR", resume_fr);
                System.out.println("RESUME_FR : " +resume_fr );
                
            }catch(Exception e){
                System.out.println("Le champs RESUME_FR est vide");
            }
            
            try{
                String date_soutenance = queryResult.getDate("DATE_SOUTENANCE").toString();
                attributes.put("DATE_SOUTENANCE", date_soutenance);
                System.out.println("DATE_SOUTENANCE : " +date_soutenance );
                
            }catch(Exception e){
                System.out.println("Le champs DATE_SOUTENANCE est vide");
            }
            
            try{
                String lieu_soutenance = queryResult.getString("LIEU_SOUTENANCE");
                attributes.put("LIEU_SOUTENANCE", lieu_soutenance);
                
            }catch(Exception e){
                System.out.println("Le champs LIEU_SOUTENANCE est vide");
            }
            
            try{
                String avis_jury = queryResult.getString("AVIS_JURY");
                attributes.put("AVIS_JURY", avis_jury);
            }catch(Exception e){
                System.out.println("Le champs AVIS_JURY est vide");
            }
            
            try{
                String annee_obtention = queryResult.getString("ANNEE_OBTENTION");
                attributes.put("ANNEE_OBTENTION", annee_obtention);
            }catch(Exception e){
                System.out.println("Le champs ANNEE_OBTENTION");
            }
            
            try{
                String mention = queryResult.getString("MENTION");
                attributes.put("MENTION", mention);
            }catch(Exception e){
                System.out.println("Le champs MENTION est vide");
            }
            
            try{
                String observation_soutenance = queryResult.getString("OBSERVATIONS_SOUTENANCE");
                attributes.put("OBSERVATION_SOUTENANCE", observation_soutenance);
            }catch(Exception e){
                System.out.println("Le champs OBSERVATION_SOUTENANCE est vide");
            }
            
            try{
                String con_objet_court = queryResult.getString("CON_OBJET_COURT");
                attributes.put("CON_OBJET_COURT", con_objet_court);
            }catch(Exception e){
                System.out.println("Le champs CON_OBJET_COURT est vide");
            }
            
            try{
                String membres_jury = queryResult.getString("MEMBRES_JURY");
                membres_jury = membres_jury.substring(0, membres_jury.length()-1);
                membres_jury+="]";
                attributes.put("MEMBRES_JURY", membres_jury);
            }catch(Exception e){
                System.out.println("Le champs MEMBRES_JURY est vide");
            }
            
            try{
                String domaine = queryResult.getString("DOMAINE");
                attributes.put("DOMAINE", domaine);
            
            }catch(Exception e){
                System.out.println("Le champs DOMAINE est vide");
            }
            
            try{
                String domaine_web = queryResult.getString("DS_LIBELLE");
                attributes.put("DS_LIBELLE", domaine_web);
            }catch(Exception e){
                System.out.println("Le champs DS_LIBELLE est vide");
            }
            
            try{
                
                String domaine = queryResult.getString("DOMAINE");
                String add = queryResult.getString("CPT_EMAIL");
                String concat = add + "@" + domaine;
                attributes.put("ADRESSE_MAIL", concat);
            }catch(Exception e){
                System.out.println("Le champs ADRESSE_MAIL est vide");
            }
        }
        
        queryResult.close();
        
        return attributes;
    }
    
    /**
     * built the XML file formatted into Tef
     * @param creator the xml file creator
     * @param sudoc the sudoc identifier
     * @param codEtu the Phd student identifier
     * @param wsUser
     * @param wsPassword
     * @param xmlContent the xml file received
     * @param userAttributesParams
     * @param attributes the hashmap of attributes <attribute, value>
     * @return
     * @throws RemoteException
     * @throws WebBaseException
     * @throws SQLException
     * @throws JSONException
     */
    public String makeTef(String creator, String sudoc, String codEtu, String wsUser, String wsPassword, String xmlContent, Map<String, String> userAttributesParams, HashMap<String, String> attributes) throws RemoteException, WebBaseException, SQLException, JSONException {
        
        String newXmlContent = "";
        InfoAdmEtuDTO etudiant = new InfoAdmEtuDTO();
        
        TefDTO dto = new TefDTO();
        this.convertToDTO(etudiant, dto, attributes);
        
        newXmlContent = tefBuilder.buildTef(dto, creator, sudoc, xmlContent, userAttributesParams, attributes);
        
        return newXmlContent;
    }
    
    /**
     *
     * @return This function builds the dto object
     * @throws SQLException
     */
    public void convertToDTO(InfoAdmEtuDTO etudiant, TefDTO dto, HashMap<String, String> attributes) throws SQLException {
        
        String nom = attributes.get("NOM");
        String nomDeNaissance = attributes.get("NOM_PATRONYMIQUE");
        
        if (nom == null || nom.trim().equals("")) {
            dto.NOM_USUEL_ETUDIANT = nomDeNaissance;
        }
        else {
            dto.NOM_ETUDIANT = nomDeNaissance;
            dto.NOM_USUEL_ETUDIANT = nom;
        }
        
        dto.PRENOM_ETUDIANT = attributes.get("PRENOM");
        dto.CODE_INE = attributes.get("ETUD_CODE_INE");
        dto.NATIONALITE = attributes.get("NATIONALITE");
        dto.DATE_NAISSANCE_ETUDIANT = attributes.get("DATE_NAISSANCE");
        dto.MAIL_PRO = attributes.get("ADRESSE_MAIL");
        dto.CODE_ETUDIANT = attributes.get("ETUD_NUMERO");
        dto.TITRE = attributes.get("SUJET_THESE");
        dto.CODE_THESE = attributes.get("ID_THESE");
        dto.DATE_SOUTENANCE = attributes.get("DATE_SOUTENANCE");
        
        dto.LIBELLE_ETAB_SOUT = attributes.get("LIEU_SOUTENANCE");
        dto.DISCIPLINE = attributes.get("DOMAINE");
        dto.DISCIPLINE_WEB = attributes.get("DS_LIBELLE");
        
        
        this.getDirecteurThese(attributes.get("ID_THESE"));
        dto.NOM_DIRECTEUR = attributes.get("NOM_DIRECTEUR");
        dto.PRENOM_DIRECTEUR = attributes.get("PRENOM_DIRECTEUR");
        
        this.getEcoleDoctorale(attributes.get("ID_THESE"));
        dto.LIBELLE_ECOLE_DOCTORALE = attributes.get("FDIP_MENTION");
        dto.CODE_ECOLE_DOCTORALE = attributes.get("FD.FDIP_CODE");
        // non pris en charge par physalis. Arrive dans la prochaine version
        // dto.DATE_FIN_CONFIDENTIALITE = formatDateToTef(convertApogeeDateToDate(these.getSuiviThese().getDatFinCfdThs()));
        
        // non pris en charge par physalis
        // dto.CODE_ETAB_SOUT = attributes.get("");

        // non pris en charge
        // dto.TYPE = these.getType().getLibThsTrv();

        // dto.NOM_CODIRECTEUR = coDir1.getLibNomPatPer();
        // dto.PRENOM_CODIRECTEUR = coDir1.getLibPr1Per();
    }
}
