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
public class EtablissementCotutelle {

    public String getnOM_COTUTELLE() {
        return nOM_COTUTELLE;
    }

    public void setnOM_COTUTELLE(String nOM_COTUTELLE) {
        this.nOM_COTUTELLE = nOM_COTUTELLE;
    }

    public String getcODE_COTUTELLE() {
        return cODE_COTUTELLE;
    }

    public void setcODE_COTUTELLE(String cODE_COTUTELLE) {
        this.cODE_COTUTELLE = cODE_COTUTELLE;
    }
     private String nOM_COTUTELLE;
     private String cODE_COTUTELLE;
     
     public void EtablissementCotutelle(String nom, String code){
         this.nOM_COTUTELLE = nom;
         this.cODE_COTUTELLE = code;
     }
     
     
}
