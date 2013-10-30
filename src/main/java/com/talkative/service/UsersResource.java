package com.talkative.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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
	public Response createUser(@QueryParam("LastName") String lastName,
			@QueryParam("password") String password,
			@QueryParam("firstName") String firstName,
			@QueryParam("email") String email) {
		ResponseBuilder responseBuilder = Response.noContent();

		if (password.length() < 8) {
			responseBuilder.status(412);
		}
		userRepository.createUser(lastName, firstName, password, email);
		return responseBuilder.build();

	}
	@Path("{user}/sites")
	public SitesResource articlesResource(@PathParam("user") String uid) {
		User user = userRepository.loadByUid(uid);
		return new SitesResource(user);
	}
}
