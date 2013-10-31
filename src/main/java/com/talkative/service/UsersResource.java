package com.talkative.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.talkative.models.User;
import com.talkative.repositories.UserRepository;
import com.talkative.repositories.UserRepositoryHardcoded;

@Path("users")
public class UsersResource {
	@Inject
	UserRepository userRepository;

	public UsersResource() {
		this.userRepository = new UserRepositoryHardcoded();
	}

	@Path("/")
	@POST
	public Response createUser(
			@FormParam("login") String login,
			@FormParam("password") String password,
			@FormParam("email") String email) {
		ResponseBuilder responseBuilder = Response.noContent();

		if (password.length() < 8) {
			responseBuilder.status(412);
			return responseBuilder.build();
		}

		userRepository.createUser(login, password, email);
		
		return responseBuilder.build();
	}

	@Path("{user}/sites")
	@GET
	public SitesResource articlesResource(@PathParam("user") String uid) {
		User user = userRepository.loadByLogin(uid);
		return new SitesResource(user);
	}
	
	@Path("list")
	@GET
	public String printAllUsers() {
		
		List<User> users = this.userRepository.loadAll();
		String liste = "liste des utilisateurs:<br>";
		
		for( User u : users) {
			liste += u.getLogin() + " - " + u.getEmail() + " - " + u.getPassword() + "<br>";
		}
		
		return liste;
	}
	
	@Path("{user}")
	@GET
	public User getUser(@PathParam("user") String uid) {
		return this.userRepository.loadByLogin(uid);
	}
	
	@Path("formulaire")
	@GET
	public String getForm() {
		
		return "<form action=\"http://localhost:8080/talkative/api/users\" method=\"post\">"
				+ "login : <input name=\"login\" type=\"text\" /><br>"
				+ "mail : <input name=\"email\" type=\"email\" /><br>"
				+ "mot de passe : <input name=\"password\" type=\"text\" /><br>"
				+ "<input type=\"submit\" />"
				+ "</form>";
	}
	
	
}
