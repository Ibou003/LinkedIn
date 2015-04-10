package dant.tools.utils;

import java.util.List;

public class StringUtility {
	public static String builder(String val, String part) {
		return val.replaceFirst("%%", part == null ? "" : part);
	}

	public static String builder(String val, List<String> parts) {
		for (String part : parts) {
			val = val.replaceFirst("%%", part == null ? "" : part);
		}
		return val;
	}

	public static String builder(String val, String[] parts) {
		for (String part : parts) {
			val = val.replaceFirst("%%", part == null ? "" : part);
		}
		return val;
	}

}
