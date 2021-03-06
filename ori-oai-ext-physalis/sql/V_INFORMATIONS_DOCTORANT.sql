
  CREATE OR REPLACE FORCE VIEW "RECHERCHE"."V_INFORMATIONS_DOCTORANT" ("NOM_PATRONYMIQUE", "NOM_USUEL", "PRENOM", "ETUD_CODE_INE", "C_PAYS_NATIONALITE", "L_NATIONALITE", "ETUD_NUMERO", "DATE_NAISSANCE", "LIEU_SOUTENANCE", "ID_THESE", "SUJET_THESE", "LIBELLE_DOMAINE", "DS_LIBELLE", "RESUME_FR", "DATE_SOUTENANCE", "AVIS_JURY", "ANNEE_REF_OBTENTION", "MENTION", "OBSERVATIONS_SOUTENANCE", "COTUTELLE", "CPT_EMAIL", "DOMAINE", "CON_OBJET_COURT", "MEMBRES_JURY") AS 
  SELECT
GIU.NOM_PATRONYMIQUE ,
GIU.NOM_USUEL ,
GIU.PRENOM ,
GE.ETUD_CODE_INE ,
GIU.C_PAYS_NATIONALITE ,
GP.LL_PAYS ,
GE.ETUD_NUMERO ,
GIU.D_NAISSANCE ,
RDT.LIEU_SOUTENANCE ,
RDT.ID_THESE ,
AC.CON_OBJET ,
RTD.LIBELLE_DOMAINE ,
GDS.DS_LIBELLE ,
RDT.RESUME_THESE ,
RDT.DATE_SOUTENANCE ,
RD.AVIS_COMMISSION ,
RDT.ANNEE_REF_OBTENTION ,
RTM.LIB_MENTION ,
RDT.OBSERVATIONS_SOUTENANCE ,
RDT.COTUTELLE,
GC.CPT_EMAIL ,
GC.CPT_DOMAINE ,
AC.CON_OBJET_COURT ,
RECHERCHE.RECUPERER_MEMBRES_JURY(RDT.ID_DOCTORANT) MJ
FROM
    GRHUM.INDIVIDU_ULR GIU,
    GRHUM.ETUDIANT GE,
    GRHUM.PAYS GP,
    GRHUM.COMPTE GC,
    GRHUM.DOMAINE_SCIENTIFIQUE GDS,
    RECHERCHE.DOCTORANT RD,
    RECHERCHE.DOCTORANT_THESE RDT,
    RECHERCHE.THESE_MENTION RTM,
    ACCORDS.CONTRAT AC,
    ACCORDS.AVENANT AA,
    ACCORDS.AVENANT_DOM_SCIENT AADS,
    RECHERCHE.THESE_DOMAINE RTD  
WHERE
    GIU.NO_INDIVIDU = GE.NO_INDIVIDU   
AND GE.NO_INDIVIDU = RD.NO_INDIVIDU   
AND RD.ID_DOCTORANT = RDT.ID_DOCTORANT (+)  
AND RDT.ID_MENTION = RTM.ID_MENTION(+)   
AND RDT.CON_ORDRE = AC.CON_ORDRE (+)  
AND RDT.ID_THESE_DOMAINE  = RTD.ID_THESE_DOMAINE (+)  
AND GIU.C_PAYS_NATIONALITE = GP.C_PAYS  
AND AC.CON_ORDRE = AA.CON_ORDRE (+)  
AND AA.AVT_ORDRE = AADS.AVT_ORDRE (+)  
AND AADS.DS_ORDRE = GDS.DS_CODE (+)  
AND GC.PERS_ID = GIU.PERS_ID
AND GC.CPT_DOMAINE=(select domaine from GRHUM.VLANS where c_vlan='E')
ORDER BY nom_patronymique, prenom;
 
