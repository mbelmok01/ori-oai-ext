/**
 * 
 */
package org.orioai.ext.hal.stubs;

import java.io.File;
import java.io.IOException;

import org.orioai.ext.core.utils.EncodingUtils;
import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ext.hal.services.marshalling.IHalDTOBuilder;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.Log4jLoggerAdapter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct;
import fr.archives_ouvertes.hal.ws.submit_php.AutLabStruct;
import fr.archives_ouvertes.hal.ws.submit_php.AuthorStruct;
import fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct;
import fr.archives_ouvertes.hal.ws.submit_php.FileStruct;
import fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct;
import fr.archives_ouvertes.hal.ws.submit_php.LaboratoryStruct;
import fr.archives_ouvertes.hal.ws.submit_php.MetaStruct;
import fr.archives_ouvertes.hal.ws.submit_php.MetasStruct;

/**
 * @author neuville
 *
 */
@Component
public class HalDTOBuilderStub implements IHalDTOBuilder {

	private Log4jLoggerAdapter log = (Log4jLoggerAdapter) LoggerFactory.getLogger(getClass());

	// the HalDTO to build
	protected HalDTO halDTO;

	/**
	 * labs id.
	 */
	private int[] labIds = { 1, 2 };

	@Override
	public HalDTO buildHalDTO(String xmlContent) throws OriOaiExtException {
		return buildHalDTO();
	}
	
	public HalDTO buildHalDTO() throws OriOaiExtException {
		if(log.isInfoEnabled())
			log.info("HalWSSubmitCaller.constructHalDTO method called");
		halDTO = new HalDTO();
		buildArtIdent();
		buildPortal();
		buildContributor();
		buildLaboratories();
		buildAuthors();
		buildSimplesMetadatas();
		buildmetadatas();
		buildFullTextStruct();
		return halDTO;
	}

	private void buildArtIdent() {
		ArticleIdentStruct artIdentStruct = new ArticleIdentStruct();
		artIdentStruct.setIdentifiant("artId");
		artIdentStruct.setVersion(1);
		artIdentStruct.setPasswd("toto");
		this.halDTO.setArtIdentStruct(artIdentStruct);
	}

	protected void buildAuthors() {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildAuthors action called");
		AuthorStruct raymond =
				new AuthorStruct(labIds, "Raymond", "Bourges", "admin", "Raymond.Bourges@univ-rennes1.fr", "url", "CRI", "team1",false);
		AuthorStruct vincent =
				new AuthorStruct(labIds, "Bonamy", "Vincent", "vbonamy", "vbonamy@univ-rennes1.fr", "url", "UNIT", "team2", false);
		AuthorStruct[] authors = { raymond, vincent };
		this.halDTO.setAuthors(authors);
	}


	protected void buildContributor() {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildContributor action called");
		String nom = "kouleowoun";
		ContributorStruct contrib = new ContributorStruct(nom, "kossi", "kossi.kouleowoun@univ-rennes1.fr");
		this.halDTO.setContributor(contrib);
	}


	public FullTextStruct buildFullTextStruct() throws OriOaiExtException {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildFullTextStruct action called");
		String signatureMD5 = "";
		String nomFichier = "testArticle.xml";
		String format = "XML";

		ClassPathResource res = new ClassPathResource("META-INF/xml/testArticle.xml");
		File file;
		try {
			file = res.getFile();
		} catch (IOException e) {
			throw new OriOaiExtException("file not found ", e);
		}

		String contenuFichier = EncodingUtils.base64encode(file);
		FileStruct fichier = new FileStruct(nomFichier, signatureMD5, format, "", contenuFichier, true);
		// droit sur les fichiers
		int droit = 1;
		// tableau de différents fichiers deposés
		FileStruct[] fileStruct = { fichier };
		FullTextStruct fullTextStruct = new FullTextStruct(droit, fileStruct);
		this.halDTO.setFullTextStruct(fullTextStruct);
		return fullTextStruct;
	}

	protected void buildLaboratories() {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildLaboratoiries action called");

		// must match labIds
		int idFirstlab = labIds[0];
		// 114,23
		final int firstKnownlab = 23;
		String[] affiliationsFirstLab = { "INRA", "EDF" };
		LaboratoryStruct firstLab = new LaboratoryStruct(idFirstlab, firstKnownlab, "", "", "", "", "", affiliationsFirstLab);
		// must much labIds
		int idSecondLab = labIds[1];
		final int secondKnownlab = 2;
		String[] affiliationsSecondLab = { "INRA", "EDF", "" };
		LaboratoryStruct secondLab = new LaboratoryStruct(idSecondLab, secondKnownlab, "", "", "", "", "", affiliationsSecondLab);
		LaboratoryStruct[] labs = { firstLab, secondLab };
		this.halDTO.setLaboratories(labs);

	}

	protected void buildmetadatas() {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildmetadatas action called");
		AutLabStruct autLabStruct = new AutLabStruct(this.halDTO.getAuthors(), this.halDTO.getLaboratories());
		MetasStruct metadonnees = new MetasStruct(this.halDTO.getSimplesMetadatas(), autLabStruct);
		this.halDTO.setMetadatas(metadonnees);
	}

	protected void buildSimplesMetadatas() {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildSimpesMetadatas action called");
		// String utf8_encode = new String (convertToUTF8("le titre du dépot"));
		String title = new String("le titre du  nouveau dépot");
		MetaStruct metaStruct1 = new MetaStruct("title", title);
		MetaStruct metaStruct2 = new MetaStruct("typePubli", "ART_ACL");
		// MetaStruct metaStruct2 = new MetaStruct("abstract",
		// new String(convertToUTF8("Le résumé de l'article")));
		MetaStruct metaStruct3 = new MetaStruct("abstract", new String("Le résumé de l'article"));
		MetaStruct metaStruct4 = new MetaStruct("langue", "EN");
		MetaStruct metaStruct5 = new MetaStruct("domain", "MATH:MATH_AC");
		MetaStruct metaStruct6 = new MetaStruct("keyword", "key1");
		MetaStruct[] metaSimple = { metaStruct1, metaStruct2, metaStruct3, metaStruct4, metaStruct5, metaStruct6 };
		this.halDTO.setSimplesMetadatas(metaSimple);

	}

	protected void buildPortal() {
		if(log.isInfoEnabled())
			log.info("SimpleHalDTOBuilder.buildPortail action called");
		this.halDTO.setHalPortalName("hal");
	}

	@Override
	public String serializeHalDTO(HalDTO halDTO) throws OriOaiExtException {
		// TODO Auto-generated method stub
		return null;
	}

}
