package org.orioai.ext.apogee.beans;

public class Jury {
	

	public Jury(String nOM_JURY, String pRENOM_JURY) {
		super();
		NOM_JURY = nOM_JURY;
		PRENOM_JURY = pRENOM_JURY;
	}
	public String getNOM_JURY() {
		return NOM_JURY;
	}
	public void setNOM_JURY(String nOM_JURY) {
		NOM_JURY = nOM_JURY;
	}
	public String getPRENOM_JURY() {
		return PRENOM_JURY;
	}
	public void setPRENOM_JURY(String pRENOM_JURY) {
		PRENOM_JURY = pRENOM_JURY;
	}
	private String NOM_JURY;
	private String PRENOM_JURY;
	
	
}
