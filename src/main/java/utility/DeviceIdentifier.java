package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class DeviceIdentifier {

	/**
	 * Generates a random token value.
	 */
	public static String generateRandomTokenValue() {
		String randomUUID = UUID.randomUUID().toString();
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
		messageDigest.update(randomUUID.getBytes());
		byte[] digest = messageDigest.digest();
		StringBuilder stringBuilder = new StringBuilder();

		for (byte b : digest) {
			stringBuilder.append(String.format("%02x", b & 0xff));
		}
		return stringBuilder.toString();
	}
}
