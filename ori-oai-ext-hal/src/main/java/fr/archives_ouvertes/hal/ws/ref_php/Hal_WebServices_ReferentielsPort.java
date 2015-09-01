/**
 * Hal_WebServices_ReferentielsPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.ref_php;

public interface Hal_WebServices_ReferentielsPort extends java.rmi.Remote {

    /**
     * Accès au référentiel des instances de Hal
     */
    public java.lang.String[] getRefInstance() throws java.rmi.RemoteException;

    /**
     * Accès au référentiel des types de publications par instance
     */
    public fr.archives_ouvertes.hal.ws.ref_php.TypePubliStruct[] getRefTypePubli(java.lang.String instance, java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * retourne la liste des métadonnées pour un type de publi ou
     * tous les types et une instance donnés
     */
    public fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[] getRefMetaData(java.lang.String instance, java.lang.String typePubli, java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * Récupération de la liste des métadonnées à renseigner pour
     * un type de publication
     */
    public fr.archives_ouvertes.hal.ws.ref_php.MetaDataStruct[] getRefMetaData_forTypePubli(java.lang.String instance, java.lang.String typePubli, java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * Récupération des informations d'un laboratoire
     */
    public fr.archives_ouvertes.hal.ws.ref_php.LabStruct getRefLab_byId(int knownLabid) throws java.rmi.RemoteException;

    /**
     * Recherche de laboratoires
     */
    public fr.archives_ouvertes.hal.ws.ref_php.LabStruct[] getRefLab_search(java.lang.String search) throws java.rmi.RemoteException;

    /**
     * Récupération des laboratoires
     */
    public int[] getRefLab(java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des laboratoires à partir de leurs noms
     */
    public int[] getRefLab_byName(java.lang.String name, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des laboratoires à partir de leurs sigles
     */
    public int[] getRefLab_byShortName(java.lang.String shortName, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des laboratoires à partir de leurs affiliations
     */
    public int[] getRefLab_byAffi(java.lang.String affi, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des laboratoires d'un auteur
     */
    public int[] getRefLab_byAuthor(java.lang.String lastname, java.lang.String firstname, java.lang.String email) throws java.rmi.RemoteException;

    /**
     * Ajout d'un laboratoire au référentiel
     */
    public int addRefLab(fr.archives_ouvertes.hal.ws.ref_php.UserStruct identification, fr.archives_ouvertes.hal.ws.ref_php.AddLabStruct lab) throws java.rmi.RemoteException;

    /**
     * Récupération du référentiel des affiliations
     */
    public java.lang.String[] getRefAffi(java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des affiliations à partir du nom de l'affiliation
     */
    public java.lang.String[] getRefAffi_byName(java.lang.String search, java.lang.String searchType, java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des informations sur une revue
     */
    public fr.archives_ouvertes.hal.ws.ref_php.ReviewStruct getRefReview_byId(int id) throws java.rmi.RemoteException;

    /**
     * Récupération des revues
     */
    public int[] getRefReview(java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des revues à partir d'un nom
     */
    public int[] getRefReview_byName(java.lang.String name, java.lang.String searchType) throws java.rmi.RemoteException;

    /**
     * Récupération des revues à partir d'un éditeur
     */
    public int[] getRefReview_byEditor(java.lang.String editor, java.lang.String searchType) throws java.rmi.RemoteException;

    /**
     * Récupération des revues à partir d'un issn
     */
    public int[] getRefReview_byISSN(java.lang.String issn, java.lang.String searchType) throws java.rmi.RemoteException;

    /**
     * Recherche des revue
     */
    public int[] searchReview(java.lang.String value, java.lang.String searchType, java.lang.String by, java.lang.String from) throws java.rmi.RemoteException;

    /**
     * Récupération des domaines scientifiques
     */
    public java.lang.String[] getRefSubject(java.lang.String instance) throws java.rmi.RemoteException;

    /**
     * Retourne les codes fils d'un domaine
     */
    public java.lang.String[] getRefSubject_byCodeParent(java.lang.String instance, java.lang.String code) throws java.rmi.RemoteException;

    /**
     * Description d'un domaine par son code
     */
    public fr.archives_ouvertes.hal.ws.ref_php.SubjectStruct getRefSubject_byCode(java.lang.String instance, java.lang.String code, java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des format de fichier déposables sur l'appli
     */
    public fr.archives_ouvertes.hal.ws.ref_php.FormatStruct[] getRefFormat(java.lang.String instance, java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des codes Tampons avec leur libelle respectifs
     * acceptés dans HAL
     */
    public fr.archives_ouvertes.hal.ws.ref_php.CollectionStruct[] getRefCollection(java.lang.String instance, java.lang.String uid) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des codes datevisible avec leur libelle respectifs
     * acceptés dans HAL
     */
    public fr.archives_ouvertes.hal.ws.ref_php.DateVisibleStruct[] getRefDateVisible() throws java.rmi.RemoteException;

    /**
     * Retourne la liste des audiences pour un papier publié dans
     * HAL
     */
    public fr.archives_ouvertes.hal.ws.ref_php.AudienceStruct[] getRefAudience(java.lang.String lang) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des codes ANR valides
     */
    public int[] getRefCodeANR(java.lang.String search) throws java.rmi.RemoteException;

    /**
     * Retourne les infos du code ANR
     */
    public fr.archives_ouvertes.hal.ws.ref_php.ANRStruct getRefANR_byCode(java.lang.String code) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des codes Projets Européens valides
     */
    public int[] getRefCodeProjEurope(java.lang.String search) throws java.rmi.RemoteException;

    /**
     * Retourne les infos du code projet Européen
     */
    public fr.archives_ouvertes.hal.ws.ref_php.ProjEuropeStruct getRefProjEurope_byCode(java.lang.String code) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des droits sur un dépôt dans HAL
     */
    public fr.archives_ouvertes.hal.ws.ref_php.RightFulltextStruct[] getRefRightFulltext() throws java.rmi.RemoteException;

    /**
     * Récupération des organismes de thèses
     */
    public fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[] getRefOrgThe(java.lang.String pays) throws java.rmi.RemoteException;

    /**
     * Récupération des organismes de thèses à partir de leurs noms
     */
    public fr.archives_ouvertes.hal.ws.ref_php.OrgtheStruct[] getRefOrgThe_byName(java.lang.String name, java.lang.String searchType, java.lang.String pays) throws java.rmi.RemoteException;

    /**
     * Récupération des écoles doctorales
     */
    public fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[] getRefSchool() throws java.rmi.RemoteException;

    /**
     * Récupération des écoles doctorales à partir d'un nom
     */
    public fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[] getRefSchool_byName(java.lang.String name, java.lang.String searchType) throws java.rmi.RemoteException;

    /**
     * Récupération des écoles doctorales à partir d'un organisme
     * de thèses
     */
    public fr.archives_ouvertes.hal.ws.ref_php.SchoolStruct[] getRefSchool_byOrgThe(java.lang.String name, java.lang.String searchType) throws java.rmi.RemoteException;
}
