/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.orioai.ext.physalis.beans;

/**
 *
 * @author Mohamed
 */
public class DirecteurThese {
    String nom;
    String prenom;

    public DirecteurThese(String nom_directeur, String prenom_directeur) {
        this.nom = nom_directeur;
        this.prenom = prenom_directeur;
    }
    
    public void DirecteurThese(String nom, String prenom){
        
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getPrenom(){
        return this.prenom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
}