package utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Helper {

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

	public static String toSQLDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	public static Date toJavaDate(String date) {
		if (null == date) {
			return null;
		}
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
