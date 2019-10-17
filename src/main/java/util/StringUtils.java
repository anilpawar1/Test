package util;


public final class StringUtils {
	private StringUtils() {}
	// test comment added for jenkins test.....
	public static boolean isValidString(String string) {
		return string != null && !string.isEmpty();
	}

}
