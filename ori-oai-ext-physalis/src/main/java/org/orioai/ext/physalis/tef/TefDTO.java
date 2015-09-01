package org.orioai.ext.physalis.tef;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.orioai.ext.physalis.beans.Jury;
import org.orioai.ext.physalis.beans.Rapporteur;

public class TefDTO {
	public String CODE_THESE;
	public String CODE_ETUDIANT;
	public String CODE_INE;
	public String NOM_ETUDIANT;
	public String NOM_USUEL_ETUDIANT;
	public String MAIL_PERSO;
	public String MAIL_PRO;
	public String PRENOM_ETUDIANT;
	public String DATE_NAISSANCE_ETUDIANT;
	public String SEXE_ETUDIANT;
	public String NATIONALITE;
	public String TYPE;
	public String CODE_ETAB_SOUT;
	public String LIBELLE_ETAB_SOUT;
	public String TITRE;
	public String DISCIPLINE;
	public String DISCIPLINE_WEB;
	public String AVIS_DE_REPRODUCTION;
	public String DATE_FIN_CONFIDENTIALITE;
	public String DATE_SOUTENANCE;
	public String CODE_COTUTELLE;
	public String NOM_COTUTELLE;
	public String CODE_ECOLE_DOCTORALE;
	public String LIBELLE_ECOLE_DOCTORALE;
	public String CODE_EQUIPE_RECHERCHE;
	public String LIBELLE_EQUIPE_RECHERCHE;
	public String NOM_DIRECTEUR;
	public String PRENOM_DIRECTEUR;
	public String NOM_CODIRECTEUR;
	public String PRENOM_CODIRECTEUR;
	
	public String TRAVAUX;
	
	public List<Jury> juries = new ArrayList<Jury> ();
	public List<Rapporteur> rapporteurs = new ArrayList<Rapporteur> ();
	
	public void addJuries(String NOM_JURY, String PRENOM_JURY){
		juries.add(new Jury(NOM_JURY, PRENOM_JURY));
	}
	
	public void addRapporteurs(String NOM_RAPPORTEUR, String PRENOM_RAPPORTEUR){
		rapporteurs.add(new Rapporteur(NOM_RAPPORTEUR, PRENOM_RAPPORTEUR));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Field[] fields = TefDTO.class.getDeclaredFields();
		for(Field field : fields){
			String fName = field.getName();
			Object value;
			try {
				value = field.get(this);
				if(value != null && value instanceof java.lang.String){
					sb.append("[").append(fName).append(" = ").append(value).append("] \r\n");
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public String getCODE_THESE() {
		return CODE_THESE;
	}
	public void setCODE_THESE(String cODE_THESE) {
		CODE_THESE = cODE_THESE;
	}
	public String getCODE_ETUDIANT() {
		return CODE_ETUDIANT;
	}
	public void setCODE_ETUDIANT(String cODE_ETUDIANT) {
		CODE_ETUDIANT = cODE_ETUDIANT;
	}
	public String getCODE_INE() {
		return CODE_INE;
	}
	public void setCODE_INE(String cODE_INE) {
		CODE_INE = cODE_INE;
	}
	public String getNOM_ETUDIANT() {
		return NOM_ETUDIANT;
	}
	public void setNOM_ETUDIANT(String nOM_ETUDIANT) {
		NOM_ETUDIANT = nOM_ETUDIANT;
	}
	public String getNOM_USUEL_ETUDIANT() {
		return NOM_USUEL_ETUDIANT;
	}
	public void setNOM_USUEL_ETUDIANT(String nOM_USUEL_ETUDIANT) {
		NOM_USUEL_ETUDIANT = nOM_USUEL_ETUDIANT;
	}
	public String getMAIL_PERSO() {
		return MAIL_PERSO;
	}
	public void setMAIL_PERSO(String mAIL_PERSO) {
		MAIL_PERSO = mAIL_PERSO;
	}
	public String getMAIL_PRO() {
		return MAIL_PRO;
	}
	public void setMAIL_PRO(String mAIL_PRO) {
		MAIL_PRO = mAIL_PRO;
	}
	public String getPRENOM_ETUDIANT() {
		return PRENOM_ETUDIANT;
	}
	public void setPRENOM_ETUDIANT(String pRENOM_ETUDIANT) {
		PRENOM_ETUDIANT = pRENOM_ETUDIANT;
	}
	public String getDATE_NAISSANCE_ETUDIANT() {
		return DATE_NAISSANCE_ETUDIANT;
	}
	public void setDATE_NAISSANCE_ETUDIANT(String dATE_NAISSANCE_ETUDIANT) {
		DATE_NAISSANCE_ETUDIANT = dATE_NAISSANCE_ETUDIANT;
	}
	public String getSEXE_ETUDIANT() {
		return SEXE_ETUDIANT;
	}
	public void setSEXE_ETUDIANT(String sEXE_ETUDIANT) {
		SEXE_ETUDIANT = sEXE_ETUDIANT;
	}
	public String getNATIONALITE() {
		return NATIONALITE;
	}
	public void setNATIONALITE(String nATIONALITE) {
		NATIONALITE = nATIONALITE;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getCODE_ETAB_SOUT() {
		return CODE_ETAB_SOUT;
	}
	public void setCODE_ETAB_SOUT(String cODE_ETAB_SOUT) {
		CODE_ETAB_SOUT = cODE_ETAB_SOUT;
	}
	public String getLIBELLE_ETAB_SOUT() {
		return LIBELLE_ETAB_SOUT;
	}
	public void setLIBELLE_ETAB_SOUT(String lIBELLE_ETAB_SOUT) {
		LIBELLE_ETAB_SOUT = lIBELLE_ETAB_SOUT;
	}
	public String getTITRE() {
		return TITRE;
	}
	public void setTITRE(String tITRE) {
		TITRE = tITRE;
	}
	public String getDISCIPLINE() {
		return DISCIPLINE;
	}
	public void setDISCIPLINE(String dISCIPLINE) {
		DISCIPLINE = dISCIPLINE;
	}
	public String getAVIS_DE_REPRODUCTION() {
		return AVIS_DE_REPRODUCTION;
	}
	public void setAVIS_DE_REPRODUCTION(String aVIS_DE_REPRODUCTION) {
		AVIS_DE_REPRODUCTION = aVIS_DE_REPRODUCTION;
	}
	public String getDATE_FIN_CONFIDENTIALITE() {
		return DATE_FIN_CONFIDENTIALITE;
	}
	public void setDATE_FIN_CONFIDENTIALITE(String dATE_FIN_CONFIDENTIALITE) {
		DATE_FIN_CONFIDENTIALITE = dATE_FIN_CONFIDENTIALITE;
	}
	public String getDATE_SOUTENANCE() {
		return DATE_SOUTENANCE;
	}
	public void setDATE_SOUTENANCE(String dATE_SOUTENANCE) {
		DATE_SOUTENANCE = dATE_SOUTENANCE;
	}
	public String getCODE_COTUTELLE() {
		return CODE_COTUTELLE;
	}
	public void setCODE_COTUTELLE(String cODE_COTUTELLE) {
		CODE_COTUTELLE = cODE_COTUTELLE;
	}
	public String getNOM_COTUTELLE() {
		return NOM_COTUTELLE;
	}
	public void setNOM_COTUTELLE(String nOM_COTUTELLE) {
		NOM_COTUTELLE = nOM_COTUTELLE;
	}
	public String getCODE_ECOLE_DOCTORALE() {
		return CODE_ECOLE_DOCTORALE;
	}
	public void setCODE_ECOLE_DOCTORALE(String cODE_ECOLE_DOCTORALE) {
		CODE_ECOLE_DOCTORALE = cODE_ECOLE_DOCTORALE;
	}
	public String getLIBELLE_ECOLE_DOCTORALE() {
		return LIBELLE_ECOLE_DOCTORALE;
	}
	public void setLIBELLE_ECOLE_DOCTORALE(String lIBELLE_ECOLE_DOCTORALE) {
		LIBELLE_ECOLE_DOCTORALE = lIBELLE_ECOLE_DOCTORALE;
	}
	public String getCODE_EQUIPE_RECHERCHE() {
		return CODE_EQUIPE_RECHERCHE;
	}
	public void setCODE_EQUIPE_RECHERCHE(String cODE_EQUIPE_RECHERCHE) {
		CODE_EQUIPE_RECHERCHE = cODE_EQUIPE_RECHERCHE;
	}
	public String getLIBELLE_EQUIPE_RECHERCHE() {
		return LIBELLE_EQUIPE_RECHERCHE;
	}
	public void setLIBELLE_EQUIPE_RECHERCHE(String lIBELLE_EQUIPE_RECHERCHE) {
		LIBELLE_EQUIPE_RECHERCHE = lIBELLE_EQUIPE_RECHERCHE;
	}
	public String getNOM_DIRECTEUR() {
		return NOM_DIRECTEUR;
	}
	public void setNOM_DIRECTEUR(String nOM_DIRECTEUR) {
		NOM_DIRECTEUR = nOM_DIRECTEUR;
	}
	public String getPRENOM_DIRECTEUR() {
		return PRENOM_DIRECTEUR;
	}
	public void setPRENOM_DIRECTEUR(String pRENOM_DIRECTEUR) {
		PRENOM_DIRECTEUR = pRENOM_DIRECTEUR;
	}
	public String getNOM_CODIRECTEUR() {
		return NOM_CODIRECTEUR;
	}
	public void setNOM_CODIRECTEUR(String nOM_CODIRECTEUR) {
		NOM_CODIRECTEUR = nOM_CODIRECTEUR;
	}
	public String getPRENOM_CODIRECTEUR() {
		return PRENOM_CODIRECTEUR;
	}
	public void setPRENOM_CODIRECTEUR(String pRENOM_CODIRECTEUR) {
		PRENOM_CODIRECTEUR = pRENOM_CODIRECTEUR;
	}
	public List<Jury> getJuries() {
		return juries;
	}
	public void setJuries(List<Jury> juries) {
		this.juries = juries;
	}
	public List<Rapporteur> getRapporteurs() {
		return rapporteurs;
	}
	public void setRapporteurs(List<Rapporteur> rapporteurs) {
		this.rapporteurs = rapporteurs;
	}
	
	public String getDISCIPLINE_WEB() {
		return DISCIPLINE_WEB;
	}

	public void setDISCIPLINE_WEB(String dISCIPLINE_WEB) {
		DISCIPLINE_WEB = dISCIPLINE_WEB;
	}
	
	//////////////////////////////////////////////////////////////

	public String getTRAVAUX() {
		if(TYPE.trim().equals("TRAVAUX")){
			TRAVAUX = "oui";
		}else
			TRAVAUX = "non";
		return TRAVAUX;
	}
	
	public void clear() {
		Field[] fields = TefDTO.class.getDeclaredFields();
		for (Field field : fields) {
			String fName = field.getName();
			if (fName.equals("juries")) {
				juries.clear();
			} else if (fName.equals("rapporteurs")) {
				rapporteurs.clear();
			} else {
				try {
					field.set(this, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
