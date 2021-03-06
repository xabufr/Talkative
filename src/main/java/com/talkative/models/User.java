package com.talkative.models;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.talkative.resource.InputValidator;

@XmlRootElement
public class User {
	private long id;
	private String login = "";
	private String password = "";
	private String email = "";
	private List<Article> ownedArticle;

	public User() {
		ownedArticle = new ArrayList<Article>();
	}

	public User(String login, String email) {
		this.login = login;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof User))
			return false;
		User oUser = (User) o;
		if (oUser.getLogin() != null && this.getLogin() != null) {
			return oUser.getLogin().equalsIgnoreCase(this.getLogin());
		}
		return oUser.getEmail().equalsIgnoreCase(getEmail());
	}

	public boolean isValid() {
		return InputValidator.isAValidEMail(email)
				&& InputValidator.isAValidLogin(login)
				&& InputValidator.isAValidPassword(password);
	}
	
	public String getMissingElements() {
		String message = "";
		
		if (!InputValidator.isAValidLogin(login))
			message += "login ";
		
		if (!InputValidator.isAValidEMail(email))
			message += "email ";
		
		if (!InputValidator.isAValidPassword(password))
			message += "password ";

		return message;
	}
	
	@Override
	public int hashCode() {
		return login.hashCode();
	}
}
