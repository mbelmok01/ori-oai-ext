/**
 *
 */
package org.orioai.ext.physalis.services.remote;

import gouv.education.apogee.commun.transverse.exception.WebBaseException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import org.orioai.ext.physalis.beans.DirecteurThese;
import org.orioai.ext.physalis.beans.DoctoralSchool;
import org.orioai.ext.physalis.beans.These;
import org.orioai.ext.physalis.tef.TefBuilder;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.MethodParametersException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Yohan Colmant
 * @author Mohamed Belmokhtar
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
        TEF_CREATOR(PhysalisWebService.TEF_CREATOR),
        TEF_SUDOC_ETAB_ID(PhysalisWebService.TEF_SUDOC_ETAB_ID),
        TEF_XML_CONTENT(PhysalisWebService.TEF_XML_CONTENT),
        URL(PhysalisWebService.URL),
        USER(PhysalisWebService.USER),
        PASSWORD(PhysalisWebService.PASSWORD),
        PHD_SUTDENT_NUMBER(PhysalisWebService.PHD_SUTDENT_NUMBER),
        PHD_NAME(PhysalisWebService.PHD_NAME),
        PHD_FIRST_NAME(PhysalisWebService.PHD_FIRST_NAME);
        
        
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
    public WSOperationBean execute(Map<String, String> wsMethodParams) throws MethodParametersException  {
        
        // checking parameters
        checkParameters(opId, ParameterName.getValues(), wsMethodParams);
        
        // fill xml
        WSOperationBean result = new WSOperationBean();
        
        try {
            Map<String, String> userAttributesParams = new HashMap<String, String>();
            
            this.openDatabase(wsMethodParams);
            
            
            These thesisObject = this.getThesisObject(wsMethodParams.get(PhysalisWebService.PHD_SUTDENT_NUMBER));
            
            // on recupere le superviseur et on l'affecte a l'objet these
            thesisObject.setSupervisors(this.getThesisSupervisor(thesisObject.getID_THESE()));
            
            
            // on recupere l'ecole doctorale cotutelle et on l'affecte a l'objet these
            thesisObject.setDoctoralSchool(this.getDoctoralSchool(thesisObject.getID_THESE()));
            
            
            // on recupere l'etablissement cotutelle et on l'affecte a l'objet these
            thesisObject.setEtab_cotutelle(getSupervisionJointEstablissement(thesisObject.getID_THESE()));
            
            this.closeDatabase();
            
            String xmlContent = makeTef(wsMethodParams.get(PhysalisWebService.TEF_CREATOR), wsMethodParams.get(PhysalisWebService.TEF_SUDOC_ETAB_ID), wsMethodParams.get(PhysalisWebService.TEF_XML_CONTENT), userAttributesParams, thesisObject);
            
            System.out.println("xmlContent = "+xmlContent);
            
            if (xmlContent!=null) {
                result.put("xmlContent", xmlContent);
                result.put("successCode", "success");
            }
            
        } catch (WebBaseException e) {
            e.printStackTrace();
        }
        catch (SQLException ex) {
            Logger.getLogger(PhysalisGetTefFromUserId.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RemoteException ex) {
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
     * @param wsMethodParams 
     */
    public void openDatabase(Map<String, String> wsMethodParams){
        
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
     * Close the connexion to database
     */
    private void closeDatabase() {
        try {
            conn.close();
        }
        catch(Exception e){
            System.out.println("Echec lors de la fermeture de la base : "+e.getMessage());
            e.printStackTrace();
        }

    }
    
    
    /**
     * 
     * @param nom : PhD student Name
     * @param prenom PhD student firstname
     * @throws SQLException 
     */
    private These getThesisObject(String numero_etudiant) throws SQLException {
        
        System.out.println("Parametre recu dans getThesisInformation : " + numero_etudiant);
        String query = "select * from RECHERCHE.V_INFORMATIONS_DOCTORANT WHERE ETUD_NUMERO="+numero_etudiant;
        
        try{
            queryResult = state.executeQuery(query);
        }catch(Exception e) {
            queryResult = null;
            System.out.println("La requête pour récupérer les information concernant une thèse a échoué : " + e.toString());
        }
        
        These t = makeThesisObject(queryResult);
        
        return t;
    }
    
    
    /**
     * 
     * @param str Thesis identifier
     * @throws SQLException 
     */
    private ArrayList getThesisSupervisor(String str) throws SQLException {
        
        ArrayList al = new ArrayList();
        ResultSet queryResult = null;
        
        String query = "Select * from RECHERCHE.V_DIRECTEUR_THESE GDT WHERE GDT.ID_THESE ="+ str;
        
        try{
            queryResult = state.executeQuery(query);
            
            while(queryResult.next()){
                
                String nom_directeur = queryResult.getString("PERS_NOMPTR");
                String prenom_directeur = queryResult.getString("PERS_LC");
                DirecteurThese dt = new DirecteurThese(nom_directeur, prenom_directeur);
                al.add(dt);
            }
            
        }catch(Exception e){
            System.out.println("La requete pour récupérer les informations concernant le directeur a échoué : " + e);
        }
        return al;
    }
    
    
    /**
     * 
     * @param str Thesis identifier
     * @throws SQLException 
     */
    private DoctoralSchool getDoctoralSchool(String str) throws SQLException {
        
        ResultSet queryResult = null;
        
        String query = "select * from RECHERCHE.V_ECOLE_DOCTORALE_THESE where ID_THESE =" + str;
        DoctoralSchool ds = new DoctoralSchool();
        try{
            queryResult = state.executeQuery(query);
            while(queryResult.next()){
                
                ds.setFDIP_MENTION(queryResult.getString("FDIP_MENTION"));
                ds.setFD_FDIP_CODE(queryResult.getString("FD.FDIP_CODE"));
            }
        }catch(Exception e){
            System.out.println("La requete pour récupérer l'école doctorale a échoué : " + e);
        }
        return ds;
    }
    
    
    /**
     * 
     * @param str Thesis identifier
     */
    private String getSupervisionJointEstablissement(String str){
        
        ResultSet queryResult = null;
        
        String query = "select * from RECHERCHE.V_ETABLISSEMENT_COTUTELLE where ID_THESE =" + str;
        String etab_cotutelle = "";
        try{
            queryResult = state.executeQuery(query);
            while(queryResult.next()){
                
                etab_cotutelle = queryResult.getString("PERS_LIBELLE");
            }
        }catch(Exception e){
            System.out.println("La requete pour récupérer l'établissement de cotutuelle a échoué : " + e);
        }
        
        return etab_cotutelle;
    }
    
    private These makeThesisObject(ResultSet queryResult) throws SQLException{
        // For each field, we get its value, if it isn't present in the response, we said that the field is empty.
        These t = new These();
        
        while(queryResult.next()){
            
            try{
                t.setID_THESE(String.valueOf(queryResult.getInt("ID_THESE")));
            }catch(Exception e){
                System.out.println("Le champs ID_THESE est vide");
            }
            
            try{
                t.setSUJET_THESE(queryResult.getString("SUJET_THESE"));
            }catch(Exception e){
                System.out.println("Le champs SUJET_THESE est vide");
            }
            
            try{
                t.setETUD_NUMERO(String.valueOf(queryResult.getInt("ETUD_NUMERO")));
            }catch(Exception e){
                System.out.println("Le champs ID_THESE est vide");
            }
            
            try{
                t.setNOM_PATRONYMIQUE(queryResult.getString("NOM_PATRONYMIQUE"));
            }catch(Exception e){
                System.out.println("Le champs NOM_PATRONYMIQUE est vide.");
            }
            
            try{
                t.setNOM_USUEL(queryResult.getString("NOM_USUEL"));
            }catch(Exception e){
                System.out.println("Le champs NOM_USUEL est vide.");
            }
            
            try{
                t.setPRENOM(queryResult.getString("PRENOM"));
            }catch(Exception e){
                System.out.println("Le champs PRENOM est vide.");
            }
            
            try{
                t.setETUD_CODE_INE(queryResult.getString("ETUD_CODE_INE"));
            }catch(Exception e){
                System.out.println("Le champs ETUD_CODE_INE est vide.");
            }
            
            try{
                t.setDATE_NAISSANCE(queryResult.getDate("DATE_NAISSANCE").toString());
            }catch(Exception e){
                System.out.println("Le champs DATE_NAISSANCE est vide");
            }
            
            try{
                t.setL_NATIONALITE(queryResult.getString("L_NATIONALITE"));
            }catch(Exception e){
                System.out.println("Le champs NATIONALITE est vide.");
            }
            
            try{
                t.setRESUME_FR(queryResult.getString("RESUME_FR"));
            }catch(Exception e){
                System.out.println("Le champs RESUME_FR est vide");
            }
            
            try{
                t.setDATE_SOUTENANCE(queryResult.getDate("DATE_SOUTENANCE").toString());
            }catch(Exception e){
                System.out.println("Le champs DATE_SOUTENANCE est vide");
            }
            
            try{
                t.setLIEU_SOUTENANCE(queryResult.getString("LIEU_SOUTENANCE"));
            }catch(Exception e){
                System.out.println("Le champs LIEU_SOUTENANCE est vide");
            }
            
            try{
                t.setAVIS_JURY(queryResult.getString("AVIS_JURY"));
                }catch(Exception e){
                System.out.println("Le champs AVIS_JURY est vide");
            }
            
            try{
                t.setANNEE_REF_OBTENTION(queryResult.getString("ANNEE_REF_OBTENTION"));
            }catch(Exception e){
                System.out.println("Le champs ANNEE_REF_OBTENTION est vide");
            }
            
            try{
                t.setMENTION(queryResult.getString("MENTION"));
            }catch(Exception e){
                System.out.println("Le champs MENTION est vide");
            }
            
            try{
                t.setOBSERVATIONS_SOUTENANCE(queryResult.getString("OBSERVATIONS_SOUTENANCE"));
            }catch(Exception e){
                System.out.println("Le champs OBSERVATIONS_SOUTENANCE est vide");
            }
            
            try{
                t.setCON_OBJET_COURT(queryResult.getString("CON_OBJET_COURT"));
            }catch(Exception e){
                System.out.println("Le champs CON_OBJET_COURT est vide");
            }
            
            try{
                t.setCON_OBJET_COURT_EN(queryResult.getString("CON_OBJET_COURT_EN"));
            }catch(Exception e){
                System.out.println("Le champs CON_OBJET_COURT_EN est vide");
            }
            
            
            try{
                String membres_jury = queryResult.getString("MEMBRES_JURY");
                
                if(!membres_jury.equalsIgnoreCase("\\[")){
                    membres_jury = membres_jury.substring(0, membres_jury.length()-1);
                    membres_jury+="]";
                    
                    t.setMEMBRES_JURY(membres_jury);;
                }else{
                    t.setMEMBRES_JURY("");
                }
            }catch(Exception e){
                System.out.println("Le champs MEMBRES_JURY est vide");
            }
            
            try{
                t.setDOMAINE(queryResult.getString("DOMAINE"));
            }catch(Exception e){
                System.out.println("Le champs DOMAINE est vide");
            }
            
            try{
                t.setDS_LIBELLE(queryResult.getString("DS_LIBELLE"));
            }catch(Exception e){
                System.out.println("Le champs DS_LIBELLE est vide");
            }
            
            try{
                String domaine = queryResult.getString("DOMAINE");
                String add = queryResult.getString("CPT_EMAIL");
                String concat = add + "@" + domaine;
                t.setADRESSE_MAIL_Pro(concat);
            }catch(Exception e){
                System.out.println("Le champs ADRESSE_MAIL est vide");
            }
        }
        
        queryResult.close();
        
        return t;
    }
   
    /**
     * 
     * @param creator
     * @param sudoc
     * @param thesisObject
     * @param xmlContent
     * @param userAttributesParams
     * @return
     * @throws RemoteException
     * @throws WebBaseException
     * @throws SQLException
     * @throws JSONException 
     */
    public String makeTef(String creator, String sudoc, String xmlContent, Map<String, String> userAttributesParams, These thesisObject) throws RemoteException, WebBaseException, SQLException, JSONException {
        
        String newXmlContent = "";
        //InfoAdmEtuDTO etudiant = new InfoAdmEtuDTO();
        
        //TefDTO dto = new TefDTO();
        //this.convertToDTO(etudiant, dto, attributes);
        
        newXmlContent = tefBuilder.buildTef(creator, sudoc, xmlContent, userAttributesParams, thesisObject);
        
        return newXmlContent;
    }
}
