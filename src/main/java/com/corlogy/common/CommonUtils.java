package com.corlogy.common;

import org.mindrot.jbcrypt.BCrypt;

public class CommonUtils {
	public static String getHashBCrypt(String str) {
		return BCrypt.hashpw(str, BCrypt.gensalt(CommonConst.BcryptRound));
	}
	
	public static boolean mapHashBCrypt(String srcString, String hashString) {
		return BCrypt.checkpw(srcString, hashString);
	}
}
