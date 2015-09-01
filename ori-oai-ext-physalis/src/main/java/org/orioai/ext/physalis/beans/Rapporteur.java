package org.orioai.ext.physalis.beans;

public class Rapporteur {
	
	public Rapporteur(String nOM_RAPPORTEUR, String pRENOM_RAPPORTEUR) {
		super();
		NOM_RAPPORTEUR = nOM_RAPPORTEUR;
		PRENOM_RAPPORTEUR = pRENOM_RAPPORTEUR;
	}
	private String NOM_RAPPORTEUR;
	private String PRENOM_RAPPORTEUR;
	public String getNOM_RAPPORTEUR() {
		return NOM_RAPPORTEUR;
	}
	public void setNOM_RAPPORTEUR(String nOM_RAPPORTEUR) {
		NOM_RAPPORTEUR = nOM_RAPPORTEUR;
	}
	public String getPRENOM_RAPPORTEUR() {
		return PRENOM_RAPPORTEUR;
	}
	public void setPRENOM_RAPPORTEUR(String pRENOM_RAPPORTEUR) {
		PRENOM_RAPPORTEUR = pRENOM_RAPPORTEUR;
	}
	
}