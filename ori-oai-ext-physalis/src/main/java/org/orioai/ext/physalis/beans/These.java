/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.orioai.ext.physalis.beans;

import java.util.ArrayList;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Mohamed
 */
public class These {
//      public String CODE_THESE;
//	public String CODE_ETUDIANT;
//	public String CODE_INE;
//	public String NOM_ETUDIANT;
//	public String NOM_USUEL_ETUDIANT;
//	public String MAIL_PERSO;
//	public String MAIL_PRO;
//	public String PRENOM_ETUDIANT;
//	public String DATE_NAISSANCE_ETUDIANT;
//	public String SEXE_ETUDIANT;
//	public String NATIONALITE;
//	public String TYPE;
//	public String CODE_ETAB_SOUT;
//	public String LIBELLE_ETAB_SOUT;
//	public String TITRE;
//	public String DISCIPLINE;
//	public String DISCIPLINE_WEB;
//	public String AVIS_DE_REPRODUCTION;
//	public String DATE_FIN_CONFIDENTIALITE;
//	public String DATE_SOUTENANCE;
//	public String CODE_COTUTELLE;
//	public String NOM_COTUTELLE;
//	public String CODE_ECOLE_DOCTORALE;
//	public String LIBELLE_ECOLE_DOCTORALE;
//	public String CODE_EQUIPE_RECHERCHE;
//	public String LIBELLE_EQUIPE_RECHERCHE;
//	public String NOM_DIRECTEUR;
//	public String PRENOM_DIRECTEUR;
//	public String NOM_CODIRECTEUR;
//	public String PRENOM_CODIRECTEUR;
//	public String TRAVAUX;
        
        
    private String ID_THESE;
    private String SUJET_THESE;
    private String ETUD_NUMERO;
    private String NOM_PATRONYMIQUE;
    private String NOM_USUEL;
    private String PRENOM;
    private String ETUD_CODE_INE;
    private String DATE_NAISSANCE;
    private String L_NATIONALITE;
    private String RESUME_FR;
    private String DATE_SOUTENANCE;
    private String LIEU_SOUTENANCE;
    private String AVIS_JURY;
    private String ANNEE_REF_OBTENTION;
    private String MENTION;
    private String OBSERVATIONS_SOUTENANCE;
    private String CON_OBJET_COURT;
    private String CON_OBJET_COURT_EN;
    private ArrayList<MembreJury> MEMBRES_JURY;
    private String DOMAINE;
    private String DS_LIBELLE;
    private String ADRESSE_MAIL;
    private String ADRESSE_MAIL_Pro;
    private ArrayList<EtablissementCotutelle> EtablissementsCotutelle;
    public String getADRESSE_MAIL_Pro() {
        return ADRESSE_MAIL_Pro;
    }

    public void setADRESSE_MAIL_Pro(String getADRESSE_MAIL_Pro) {
        this.ADRESSE_MAIL_Pro = getADRESSE_MAIL_Pro;
    }
    private ArrayList supervisor;
    private DoctoralSchool doctoralSchool;
    private String etab_cotutelle;

    public String getEtab_cotutelle() {
        return etab_cotutelle;
    }

    public void setEtab_cotutelle(String etab_cotutelle) {
        this.etab_cotutelle = etab_cotutelle;
    }

    public DoctoralSchool getDoctoralSchool() {
        return doctoralSchool;
    }

    public void setDoctoralSchool(DoctoralSchool doctoralSchool) {
        this.doctoralSchool = doctoralSchool;
    }
    

    public String getADRESSE_MAIL() {
        return ADRESSE_MAIL;
    }

    public void setADRESSE_MAIL(String ADRESSE_MAIL) {
        this.ADRESSE_MAIL = ADRESSE_MAIL;
    }
    
    
    public void These(){
    };

    public String getID_THESE() {
        return ID_THESE;
    }

    public void setID_THESE(String ID_THESE) {
        this.ID_THESE = ID_THESE;
    }

    public String getSUJET_THESE() {
        return SUJET_THESE;
    }

    public void setSUJET_THESE(String SUJET_THESE) {
        this.SUJET_THESE = SUJET_THESE;
    }

    public String getETUD_NUMERO() {
        return ETUD_NUMERO;
    }

    public void setETUD_NUMERO(String ETUD_NUMERO) {
        this.ETUD_NUMERO = ETUD_NUMERO;
    }

    public String getNOM_PATRONYMIQUE() {
        return NOM_PATRONYMIQUE;
    }

    public void setNOM_PATRONYMIQUE(String NOM_PATRONYMIQUE) {
        this.NOM_PATRONYMIQUE = NOM_PATRONYMIQUE;
    }

    public String getNOM_USUEL() {
        return NOM_USUEL;
    }

    public void setNOM_USUEL(String NOM_USUEL) {
        this.NOM_USUEL = NOM_USUEL;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getETUD_CODE_INE() {
        return ETUD_CODE_INE;
    }

    public void setETUD_CODE_INE(String ETUD_CODE_INE) {
        this.ETUD_CODE_INE = ETUD_CODE_INE;
    }

    public String getDATE_NAISSANCE() {
        return DATE_NAISSANCE;
    }

    public void setDATE_NAISSANCE(String DATE_NAISSANCE) {
        this.DATE_NAISSANCE = DATE_NAISSANCE;
    }

    public String getL_NATIONALITE() {
        return L_NATIONALITE;
    }

    public void setL_NATIONALITE(String L_NATIONALITE) {
        this.L_NATIONALITE = L_NATIONALITE;
    }

    public String getRESUME_FR() {
        return RESUME_FR;
    }

    public void setRESUME_FR(String RESUME_FR) {
        this.RESUME_FR = RESUME_FR;
    }

    public String getDATE_SOUTENANCE() {
        return DATE_SOUTENANCE;
    }

    public void setDATE_SOUTENANCE(String DATE_SOUTENANCE) {
        this.DATE_SOUTENANCE = DATE_SOUTENANCE;
    }

    public String getLIEU_SOUTENANCE() {
        return LIEU_SOUTENANCE;
    }

    public void setLIEU_SOUTENANCE(String LIEU_SOUTENANCE) {
        this.LIEU_SOUTENANCE = LIEU_SOUTENANCE;
    }

    public String getAVIS_JURY() {
        return AVIS_JURY;
    }

    public void setAVIS_JURY(String AVIS_JURY) {
        this.AVIS_JURY = AVIS_JURY;
    }

    public String getANNEE_REF_OBTENTION() {
        return ANNEE_REF_OBTENTION;
    }

    public void setANNEE_REF_OBTENTION(String ANNEE_REF_OBTENTION) {
        this.ANNEE_REF_OBTENTION = ANNEE_REF_OBTENTION;
    }

    public String getMENTION() {
        return MENTION;
    }

    public void setMENTION(String MENTION) {
        this.MENTION = MENTION;
    }

    public String getOBSERVATIONS_SOUTENANCE() {
        return OBSERVATIONS_SOUTENANCE;
    }

    public void setOBSERVATIONS_SOUTENANCE(String OBSERVATIONS_SOUTENANCE) {
        this.OBSERVATIONS_SOUTENANCE = OBSERVATIONS_SOUTENANCE;
    }

    public String getCON_OBJET_COURT() {
        return CON_OBJET_COURT;
    }

    public void setCON_OBJET_COURT(String CON_OBJET_COURT) {
        this.CON_OBJET_COURT = CON_OBJET_COURT;
    }

    public String getCON_OBJET_COURT_EN() {
        return CON_OBJET_COURT_EN;
    }

    public void setCON_OBJET_COURT_EN(String CON_OBJET_COURT_EN) {
        this.CON_OBJET_COURT_EN = CON_OBJET_COURT_EN;
    }

    public ArrayList<MembreJury> getMEMBRES_JURY() {
        return MEMBRES_JURY;
    }

    public void setMEMBRES_JURY(String MEMBRES_JURY) throws JSONException {
        ArrayList<MembreJury> al = new ArrayList();
        
        System.out.println("entree dans setMEMBRES_JURY : "+ MEMBRES_JURY);
        
        JSONArray obj = new JSONArray(MEMBRES_JURY);
        
        for(int i=0; i< obj.length(); i++){
            JSONObject j = obj.getJSONObject(i);
            MembreJury mj = new MembreJury();
            
            mj.setNom(j.get("nom").toString());
            mj.setPrenom(j.get("prenom").toString());
            mj.setStatus(j.getString("role").toString());
            al.add(mj);
            System.out.println("mon membre jury : "+mj.toString());
        }
        System.out.println(" liste des objets membres jury : " + al.toString());
        this.MEMBRES_JURY = al;
    }

    public String getDOMAINE() {
        return DOMAINE;
    }

    public void setDOMAINE(String DOMAINE) {
        this.DOMAINE = DOMAINE;
    }

    public String getDS_LIBELLE() {
        return DS_LIBELLE;
    }

    public void setDS_LIBELLE(String DS_LIBELLE) {
        this.DS_LIBELLE = DS_LIBELLE;
    }
    
    public ArrayList getSupervisor() {
        return supervisor;
    }

    public void setSupervisors(ArrayList supervisor) {
        this.supervisor = supervisor;
    }

}