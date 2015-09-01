package org.orioai.ext.core.utils;

/**
 * Classe contenant des méthodes de codage et de décodage de chaînes au format
 * hexadécimal.
 * 
 * @author kkouleow
 */
public class HexUtils {
	/**
	 * empty private constructor.
	 */
	private HexUtils() {
		//
	}

	/**
	 * Décode la séquence de caractères hexadécimaux spécifiée sous forme de
	 * tableau d'octets.
	 * 
	 * @param data
	 *            Données à décoder.
	 * @return Données décodées.
	 * 
	 * @throws IllegalArgumentException
	 *             <var>data</var> contient un nombre impair de caractères ou
	 *             des caractères invalides.
	 */
	public static byte[] decode(final String data) {
		// Vérification des arguments
		int length = data.length();
		int i;
		int j;
		final int intVal = 16;
		if ((length % 2) != 0) {
			throw new IllegalArgumentException("Odd number of characters.");
		}

		// 2 caractères hexadécimaux sont utilisés pour représenter un octet
		try {
			byte[] bytes = new byte[length / 2];
			for (i = 0, j = 0; i < length; i = i + 2) {
				bytes[j++] = (byte) Integer.parseInt(data.substring(i, i + 2), intVal);
			}
			return bytes;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Illegal hexadecimal character.", e);
		}
	}

	/**
	 * Code les données spécifiées sous forme de chaîne composée de caractères
	 * hexadécimaux.
	 * 
	 * @param data
	 *            Données à coder.
	 * @return Données codées sous forme de chaîne hexadécimale.
	 */
	public static String encode(final byte[] data) {
		StringBuilder builder = new StringBuilder();
		for (byte dataByte : data) {
			// Un octet est représenté par 2 caractères hexadécimaux
			builder.append(Integer.toHexString((dataByte & 0xF0) >> 4));
			builder.append(Integer.toHexString(dataByte & 0x0F));
		}

		return builder.toString();
	}
}
