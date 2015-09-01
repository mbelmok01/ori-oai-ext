/**
 * Hal_WebServices_SubmitPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fr.archives_ouvertes.hal.ws.submit_php;

public interface Hal_WebServices_SubmitPort extends java.rmi.Remote {

    /**
     * Dépôt d'un document avec ou sans fichier
     */
    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct upload(java.lang.String instance, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct contributor, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException;

    /**
     * Modification d'un document après modération
     */
    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct modify(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct contributor, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException;

    /**
     * Nouvelle version d'un dépôt avec fichier
     */
    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct replace(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct contributor, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException;

    /**
     * Modification des métadonnées d'un dépôt
     */
    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct update(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.MetasStruct metadatas) throws java.rmi.RemoteException;

    /**
     * Ajout|Modification des refs biblios
     */
    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct jref(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, java.lang.String typePubli, fr.archives_ouvertes.hal.ws.submit_php.MetaStruct[] metas) throws java.rmi.RemoteException;

    /**
     * Ajout d'un domaine scientifique à un dépôt en ligne
     */
    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct cross(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, java.lang.String domain) throws java.rmi.RemoteException;

    /**
     * Ajout de fichier pour une notice (dépôt sans fichier)
     */
    public fr.archives_ouvertes.hal.ws.submit_php.PendingArticleStruct addFile(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct fullText) throws java.rmi.RemoteException;

    /**
     * Ajout de fichiers annexes pour un dépôt avec fichier.
     * Fonctionalité accessible que par les adminstrateurs.
     */
    public boolean addSupplementaryData(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, fr.archives_ouvertes.hal.ws.submit_php.FileStruct[] files) throws java.rmi.RemoteException;

    /**
     * Ajout d'une collection à un dépôt en ligne
     */
    public fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct addCollection(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification, java.lang.String collection) throws java.rmi.RemoteException;

    /**
     * Mise en ligne des fichiers pour un dépôt sous embargo
     */
    public boolean putOnLine(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification) throws java.rmi.RemoteException;

    /**
     * Retourne le statut d'un dépôt
     */
    public fr.archives_ouvertes.hal.ws.submit_php.ArticleStatusStruct status(fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct article, fr.archives_ouvertes.hal.ws.submit_php.UserStruct identification) throws java.rmi.RemoteException;
}
