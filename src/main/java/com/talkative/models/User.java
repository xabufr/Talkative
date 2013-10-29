package com.talkative.models;

import java.util.ArrayList;
import java.util.List;

public class User extends Object {
	private long id;
	private String uid;
	private String lastName;
	private String firstName;
	private List<WebSite> ownedWebSites;
	private String password;
	private String email;

	public User() {
		ownedWebSites = new ArrayList<WebSite>();
	}

	public User(String lastName2, String firstName2, String email) {
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.setEmail(email);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<WebSite> getOwnedWebSites() {
		return ownedWebSites;
	}

	public void setOwnedWebSites(List<WebSite> ownedWebSites) {
		this.ownedWebSites = ownedWebSites;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		if (oUser.getUid() != null && this.getUid() != null) {
			return oUser.getUid().equalsIgnoreCase(this.getUid());
		}
		return oUser.getEmail().equalsIgnoreCase(getEmail())
				&& oUser.getLastName().equalsIgnoreCase(this.getLastName())
				&& oUser.getFirstName().equalsIgnoreCase(this.getFirstName());
	}
}
