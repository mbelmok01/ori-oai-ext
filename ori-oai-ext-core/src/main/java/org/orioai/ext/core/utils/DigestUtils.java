package org.orioai.ext.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Message digest utilities.
 * 
 * @author kkouleow
 * 
 */
public class DigestUtils {
	/**
	 * Constructeur privé : interdit l'instanciation de cette classe.
	 */
	private DigestUtils() {
		//
	}

	// =======================================================================================
	/**
	 * Calcule et retourne le hachage MD5 (RSA Data Security MD5
	 * Message-DigestUtils Algorithm) du tableau d'octets spécifié.
	 * 
	 * @param data
	 *            Données dont on doit calculer le MD5.
	 * @return Nombre de 32 caractères hexadécimaux.
	 * 
	 * @throws NoSuchAlgorithmException
	 *             Le hachage MD5 n'est pas disponible sur cette plate-forme.
	 */
	public static String md5(final byte[] data) throws NoSuchAlgorithmException {
		return HexUtils.encode(digest(data, "MD5"));
	}

	/**
	 * Calcule et retourne le hachage MD5 (RSA Data Security MD5
	 * Message-DigestUtils Algorithm) de la chaîne spécifiée.
	 * 
	 * @param value
	 *            Chaîne dont on doit calculer le MD5.
	 * @return Nombre de 32 caractères hexadécimaux.
	 * 
	 * @throws NoSuchAlgorithmException
	 *             Le hachage MD5 n'est pas disponible sur cette plate-forme.
	 */
	public static String md5(final String value) throws NoSuchAlgorithmException {
		return md5(value.getBytes());
	}

	// =======================================================================================
	/**
	 * Calcule et retourne le hachage SHA-1 (US Secure Hash Algorithm 1) du
	 * tableau d'octets spécifié.
	 * 
	 * @param data
	 *            Données dont on doit calculer le SHA-1.
	 * @return Nombre de 40 caractères hexadécimaux.
	 * 
	 * @throws NoSuchAlgorithmException
	 *             Le hachage SHA-1 n'est pas disponible sur cette plate-forme.
	 */
	public static String sha1(final byte[] data) throws NoSuchAlgorithmException {
		return HexUtils.encode(digest(data, "SHA-1"));
	}

	/**
	 * Calcule et retourne le hachage SHA-1 (US Secure Hash Algorithm 1) de la
	 * chaîne spécifiée.
	 * 
	 * @param value
	 *            Chaîne dont on doit calculer le SHA-1.
	 * @return Nombre de 40 caractères hexadécimaux.
	 * 
	 * @throws NoSuchAlgorithmException
	 *             Le hachage SHA-1 n'est pas disponible sur cette plate-forme.
	 */
	public static String sha1(final String value) throws NoSuchAlgorithmException {
		return sha1(value.getBytes());
	}

	// =======================================================================================
	/**
	 * Calcule et retourne la somme de contrôle des données spécifiées en
	 * utilisant l'algorithme de hachage spécifié.
	 * 
	 * @param data
	 *            Données dont on doit calculer la somme de contrôle.
	 * @param algorithm
	 *            Chaîne spécifiant l'algorithme de hachage à utiliser.
	 * @return Somme de contrôle calculée à partir des données.
	 * 
	 * @throws NoSuchAlgorithmException
	 *             Le hachage MD5 n'est pas disponible sur cette plate-forme.
	 */
	private static byte[] digest(final byte[] data, final String algorithm) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(algorithm).digest(data);
	}

}
