/**
 * Hal_WebServices_SearchPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.search_php;

public interface Hal_WebServices_SearchPort extends java.rmi.Remote {

    /**
     * Retourne la liste des dépôts dans HAL correspondants aux critères
     * de recherche
     */
    public fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[] existOnHAL(java.lang.String title, java.lang.String status) throws java.rmi.RemoteException;

    /**
     * Retourne les statistiques de consultation d'un article
     */
    public fr.archives_ouvertes.hal.ws.search_php.CounterStruct getArticleCounter(fr.archives_ouvertes.hal.ws.search_php.UserStruct identification, fr.archives_ouvertes.hal.ws.search_php.ArticleIdentStruct article) throws java.rmi.RemoteException;

    /**
     * Retourne le nombre de documents pour une instance ou une collection
     * donnée
     */
    public fr.archives_ouvertes.hal.ws.search_php.SetCounterStruct getSetCounter(java.lang.String set) throws java.rmi.RemoteException;

    /**
     * Retourne les métadonnées pour un article donné
     */
    public fr.archives_ouvertes.hal.ws.search_php.DatasStruct getArticleMetadata(java.lang.String identifiant, int version) throws java.rmi.RemoteException;

    /**
     * Retourne le texte intégral pour un identifiant donné
     */
    public java.lang.String[] getArticleFile(java.lang.String identifiant, int version) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des articles correspondants aux critères
     * de recherche
     */
    public fr.archives_ouvertes.hal.ws.search_php.ArticleStruct[] search(fr.archives_ouvertes.hal.ws.search_php.SearchStruct[] search, java.lang.String[] typePubli, boolean onlyFullText, java.lang.String orderBy) throws java.rmi.RemoteException;

    /**
     * Retourne la liste des thèses correspondants aux critères de
     * recherche
     */
    public fr.archives_ouvertes.hal.ws.search_php.ThesisStruct[] search_thesis(fr.archives_ouvertes.hal.ws.search_php.UserStruct identification, java.lang.String title, java.lang.String author, java.lang.String defencedate) throws java.rmi.RemoteException;
}
