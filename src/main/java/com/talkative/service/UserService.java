package com.talkative.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.talkative.models.User;
import com.talkative.repositories.UserRepository;
import com.talkative.repositories.UserRepositoryHardcoded;

@Path("/api/user/")
public class UserService {
	UserRepository userRepository;

	public UserService() {
		this.userRepository = new UserRepositoryHardcoded();
	}

	@Path("add/")
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
}
