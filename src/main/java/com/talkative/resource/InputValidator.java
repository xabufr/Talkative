package com.talkative.resource;

public class InputValidator {

	public static boolean isAValidPassword(String password) {
		if (password.length() < 8)
			return false;
		return true;
	}

	public static boolean isAValidLogin(String login) {
		if (login.length() < 4)
			return false;		
		return login != null && login.matches("^[a-zA-Z].*[a-zA-Z0-9_]");
	}

	public static boolean isAValidEMail(String eMail) {
		return eMail != null && eMail.matches("^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}.[a-z]{2,4}$");
	}

}
