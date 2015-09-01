/**
 * 
 */
package org.orioai.ext.core.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.digest.DigestUtils;



/**
 * @author neuville
 *
 */
public class EncodingUtils {
	
	/**
	 * encode a string to utf-8.
	 * 
	 * @param aString
	 *            string to convert
	 * @return string converted
	 */
	public static String convertToUTF8(final String aString) {
		String out = null;
		try {
			out = new String(aString.getBytes("UTF-8"));
		} catch (java.io.UnsupportedEncodingException e) {
			return null;
		}
		return out;
	}

	/**
	 * Encode un fichier en base64. Cet encodage est fait pour permettre aux
	 * informations binaires d'être manipulees par les systèmes qui ne gèrent
	 * pas correctement les 8 bits
	 * 
	 * @param file
	 * @return retourne data contenu dans fichier, encodé en base64.
	 */
	public static String base64encode(final File file) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		final int constante = 1024;
		byte[] tabBytes = new byte[constante];
		try {
			is.read(tabBytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String contenuFichier = new String(Base64.encodeBase64(tabBytes));
		return contenuFichier;
	}

	public static String base64encode(final InputStream istream) {
		InputStream is = new BufferedInputStream(new Base64InputStream(istream, true));
		byte[] buffer = new byte[1024];
		StringBuilder strBuilder = new StringBuilder();
		try {
			while(is.read(buffer) != -1) {
				String tempContent = new String(buffer); 
				strBuilder.append(tempContent);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return strBuilder.toString();
	}
	
	/**
	 * Calculates the MD5 digest and returns the value as a 32 characters hex
	 * string.
	 * 
	 * @param path
	 * @return hex string.
	 */

	public static String signupContent(String content) {
		String hash = "";
		hash = DigestUtils.md5Hex(content);
		return hash;
	}

	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex
	 * string.
	 * 
	 * @param data
	 * @return hex string
	 */

	public static String signupData(final String data) {
		// TODO Test me.
		return DigestUtils.md5Hex(data);
	}

	public static String base64encode(URL url) {
		String contenuFichier = null;
		try {
			URLConnection urlConn;
			urlConn = url.openConnection();
			urlConn.setDoInput(true);
			urlConn.setUseCaches(false);
			InputStream in = urlConn.getInputStream();
			final int constante = 1024;
			byte[] tabBytes = new byte[constante];
			in.read(tabBytes);
			contenuFichier = new String(Base64.encodeBase64(tabBytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenuFichier;
	}
}
