package com.corlogy.common;

public class CommonCheck {
	public static boolean isNullOrEmpty (String str) {
		return str == null || str.length() == 0;
	}
	
	public static boolean isNull(Object object) {
		return object == null;
	}
}
