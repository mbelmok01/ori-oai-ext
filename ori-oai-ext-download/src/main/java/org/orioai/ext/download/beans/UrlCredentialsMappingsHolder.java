/**
 * 
 */
package org.orioai.ext.download.beans;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author neuville
 *
 */
@Component
public class UrlCredentialsMappingsHolder {

	@Value("#{urlCredentialsMappingsProperties}")
	private Map<String, String> mappings;

	public void setMappings(Map<String, String> mappings) {
		this.mappings = mappings;
	}

	public Map<String, String> getMappings() {
		return mappings;
	}
	
}
