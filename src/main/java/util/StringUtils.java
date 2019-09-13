package util;


public final class StringUtils {
	private StringUtils() {}
	
	public static boolean isValidString(String string) {
		return string != null && !string.isEmpty();
	}

}
