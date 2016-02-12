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
public class MembreJury {

    
    String nom;
    String prenom;
    String status;
    
    
    public void MembreJury(){
        
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String toString(){
        return "nom = "+this.nom+ " prenom = "+this.prenom+" status = "+this.status;
    }
    
    
}
