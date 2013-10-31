package com.talkative.models;

import java.util.ArrayList;
import java.util.List;

public class User extends Object {
	private long id;
	private String login;
	private String password;
	private String email;
	private List<WebSite> ownedWebSites;

	public User() {
		ownedWebSites = new ArrayList<WebSite>();
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

	public List<WebSite> getOwnedWebSites() {
		return ownedWebSites;
	}

	public void setOwnedWebSites(List<WebSite> ownedWebSites) {
		this.ownedWebSites = ownedWebSites;
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
}
