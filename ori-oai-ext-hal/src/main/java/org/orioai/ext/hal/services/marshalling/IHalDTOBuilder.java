/**
 * 
 */
package org.orioai.ext.hal.services.marshalling;

import org.orioai.ext.hal.beans.HalDTO;
import org.orioai.ws.ext.exceptions.OriOaiExtException;

/**
 * @author neuville
 *
 */
public interface IHalDTOBuilder {

	public HalDTO buildHalDTO(String xmlContent) throws OriOaiExtException;
	
	public String serializeHalDTO(HalDTO halDTO) throws OriOaiExtException;
}
