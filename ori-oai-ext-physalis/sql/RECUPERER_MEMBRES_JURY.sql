create or replace FUNCTION           RECUPERER_MEMBRES_JURY 
(
  iddoctorant IN number 
) RETURN CHAR
IS
  -- Action : AFFECTATION
  CURSOR c1
  IS    
    SELECT DISTINCT I.NOM_USUEL as NOM_MEMBRE_JURY, I.PRENOM as PRENOM_MEMBRE_JURY, CORPS.LL_CORPS, TITRE_SPECIAL, ASS_CODE, LL_RNE, LIBELLE_STRUCT_EXTERNE    
    FROM RECHERCHE.DOCTORANT D
    LEFT OUTER JOIN RECHERCHE.DOCTORANT_THESE T ON D.ID_DOCTORANT = T.ID_DOCTORANT
    INNER JOIN RECHERCHE.MEMBRE_JURY_THESE MJT ON MJT.ID_THESE = T.ID_THESE
    LEFT OUTER JOIN GRHUM.CORPS ON GRHUM.CORPS.C_CORPS = MJT.C_CORPS
    LEFT OUTER JOIN GRHUM.RNE ON GRHUM.RNE.C_RNE = MJT.C_RNE
    INNER JOIN ACCORDS.CONTRAT_PARTENAIRE CP ON CP.CP_ORDRE = MJT.CP_ORDRE
    INNER JOIN ACCORDS.CONTRAT C ON CP.CON_ORDRE = C.CON_ORDRE
    INNER JOIN GRHUM.INDIVIDU_ULR I ON I.PERS_ID = CP.PERS_ID
    INNER JOIN GRHUM.REPART_ASSOCIATION RA ON RA.PERS_ID = CP.PERS_ID AND RA.C_STRUCTURE = C.CON_GROUPE_PARTENAIRE
    INNER JOIN GRHUM.ASSOCIATION A ON A.ASS_ID = RA.ASS_ID
    INNER JOIN GRHUM.ASSOCIATION_RESEAU AR ON A.ASS_ID = AR.ASS_ID_FILS   
    WHERE D.ID_DOCTORANT = iddoctorant
    -- membre du jury sauf invité
   -- AND ASS_ID_PERE = (select ass_id from GRHUM.ASSOCIATION where ass_code = 'D_TYPE_JURY')
    AND ASS_CODE != 'D_JR_INV'
    ORDER BY DECODE(ASS_CODE,'D_JR_PRES', 1, 'D_JR_MEM', 2, 3);
    
 -- variables
  r_membre c1%ROWTYPE;
  membres  VARCHAR2(500);
  president VARCHAR2(250);
  rapporteur VARCHAR2(250);
  json VARCHAR2(500);
  indiceR number:=0;
  indiceM number:=0;
  indice number:=0;
  
BEGIN
  
  json:='[';
  
  -- Action 1
  OPEN c1;
  LOOP
     FETCH c1 INTO r_membre;
     EXIT WHEN c1%NOTFOUND;
      
    json:=json||'{"id" : '||indice||','||'"nom" :"'||r_membre.NOM_MEMBRE_JURY||'", '||'"prenom" : "'||r_membre.PRENOM_MEMBRE_JURY||'", "role" : "'|| r_membre.ASS_CODE ||'"},';indice:=indice+1;
   
   END LOOP;
  CLOSE c1;
  --membres:=membres||']}}}';
  --json:=json||president||','||rapporteur||membres;
  --json:=json||']';
  IF ((membres = '') OR (membres IS NULL))
  THEN membres := 'Membre inconnu...';
  END IF;
  
  
  RETURN json;
  END RECUPERER_MEMBRES_JURY;