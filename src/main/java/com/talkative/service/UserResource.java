package com.talkative.service;

import javax.ws.rs.Path;

import com.talkative.models.User;

public class UserResource {

	private User user;

	public UserResource(User user) {
		this.user = user;
	}
	
	@Path("sites")
	public SitesResource getSitesResource() {
		return new SitesResource();
	}
	
	@Path("/")
	public String getUserInfos() {
		return "le nom de l'utilisateur est:" + this.user.getLogin();
	}
}
