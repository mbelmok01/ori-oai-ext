/**
 * 
 */
package org.orioai.ext.core.exceptions;

import org.esupportail.commons.exceptions.EsupException;

/**
 * @author neuville
 *
 */
@SuppressWarnings("serial")
public class XmlException extends EsupException {

	/**
	 * 
	 */
	public XmlException() {
	}

	/**
	 * @param message
	 */
	public XmlException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public XmlException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public XmlException(String message, Throwable cause) {
		super(message, cause);
	}

}
