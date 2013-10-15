package com.talkative.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	private long id;
	private String uid;
	private String lastName;
	private String firstName;
	private List<WebSite> ownedWebSites;
	
	public User() {
		ownedWebSites = new ArrayList<WebSite>();
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
}
