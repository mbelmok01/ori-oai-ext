/**
 * 
 */
package org.orioai.ext.hal.beans;

import org.springframework.stereotype.Component;

import fr.archives_ouvertes.hal.ws.submit_php.ArticleIdentStruct;
import fr.archives_ouvertes.hal.ws.submit_php.AuthorStruct;
import fr.archives_ouvertes.hal.ws.submit_php.ContributorStruct;
import fr.archives_ouvertes.hal.ws.submit_php.FullTextStruct;
import fr.archives_ouvertes.hal.ws.submit_php.LaboratoryStruct;
import fr.archives_ouvertes.hal.ws.submit_php.MetaStruct;
import fr.archives_ouvertes.hal.ws.submit_php.MetasStruct;

/**
 * @author neuville
 *
 */
@Component
public class HalDTO {

	/**
	 * halPortalName.
	 */
	private String halPortalName = "hal";

	// private String halPortalName = "paol";
	
	private ArticleIdentStruct artIdentStruct;

	/**
	 * contributor.
	 */
	private ContributorStruct contributor;

	/**
	 * les auteurs.
	 */
	private AuthorStruct[] authors;

	/**
	 * les laboratories.
	 */
	private LaboratoryStruct[] laboratories;

	/**
	 * Metadonnees simples.
	 */
	private MetaStruct[] simplesMetadatas;

	/**
	 * /Metadata author/laboratory.
	 */
	private MetasStruct metadatas;

	/**
	 * 
	 */
	private FullTextStruct fullTextStruct;

	/**
	 * 
	 */
	public HalDTO() {
		//
	}

	/**
	 * @param halPortalName
	 *            the halPortalName to set.
	 */
	public void setHalPortalName(final String halPortalName) {
		this.halPortalName = halPortalName;
	}
	
	public ArticleIdentStruct getArtIdentStruct() {
		return artIdentStruct;
	}

	public void setArtIdentStruct(ArticleIdentStruct artIdentStruct) {
		this.artIdentStruct = artIdentStruct;
	}

	/**
	 * @param contributor
	 *            the contributor to set
	 */
	public void setContributor(final ContributorStruct contributor) {
		this.contributor = contributor;
	}

	/**
	 * @param authors
	 *            the authors to set.
	 */
	public void setAuthors(final AuthorStruct[] authors) {
		this.authors = authors;
	}

	/**
	 * @param laboratories
	 *            the laboratories to set
	 */
	public void setLaboratories(final LaboratoryStruct[] laboratories) {
		this.laboratories = laboratories;
	}

	/**
	 * @param fullTextStruct
	 *            the fullTextStruct to set.
	 */
	public void setFullTextStruct(final FullTextStruct fullTextStruct) {
		this.fullTextStruct = fullTextStruct;
	}

	/**
	 * @return the halPortalName
	 */
	public String getHalPortalName() {
		return halPortalName;
	}

	/**
	 * @return the contributor
	 */
	public ContributorStruct getContributor() {
		return contributor;
	}

	/**
	 * @return the authors
	 */
	public AuthorStruct[] getAuthors() {
		return authors;
	}

	/**
	 * @return the laboratories
	 */
	public LaboratoryStruct[] getLaboratories() {
		return laboratories;
	}

	/**
	 * @return the simplesMetadatas
	 */
	public MetaStruct[] getSimplesMetadatas() {
		return simplesMetadatas;
	}

	/**
	 * @param simplesMetadatas
	 *            the simplesMetadatas to set
	 */
	public void setSimplesMetadatas(final MetaStruct[] simplesMetadatas) {
		this.simplesMetadatas = simplesMetadatas;
	}

	/**
	 * @return the fullTextStruct
	 */
	public FullTextStruct getFullTextStruct() {
		return fullTextStruct;
	}

	/**
	 * @return the metadatas
	 */

	public MetasStruct getMetadatas() {
		return metadatas;
	}

	/**
	 * @param metadatas
	 *            the metadatas to set
	 */
	public void setMetadatas(final MetasStruct metadatas) {
		this.metadatas = metadatas;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 */
	public boolean equals(final Object object) {
		if (object instanceof HalDTO) {
			HalDTO halDTO = (HalDTO) object;

			return halDTO.getArtIdentStruct().equals(this.artIdentStruct)
					&& halDTO.getContributor().equals(this.contributor)
					&& halDTO.getAuthors().equals(this.authors)
					&& halDTO.getLaboratories().equals(this.laboratories)
					&& halDTO.getSimplesMetadatas().equals(this.simplesMetadatas)
					&& halDTO.getMetadatas().equals(this.metadatas)
					&& halDTO.getFullTextStruct().equals(this.fullTextStruct);
		}
		return false;
	}

	/**
	 * a hash code value for the HalDTO object.
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
