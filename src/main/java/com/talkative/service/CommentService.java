package com.talkative.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.talkative.models.User;
import com.talkative.repositories.UserRepository;
import com.talkative.repositories.UserRepositoryHardcoded;

@Path("api/comment/")
public class CommentService {
	UserRepository userRepository;
	
	public CommentService() {
		this.userRepository = new UserRepositoryHardcoded();
	}
	
	@Path("get.json")
	@GET
	public Response getComments(@QueryParam("uid") String uid,
			@QueryParam("sid") String sid,
			@QueryParam("pid") String pid) {
		ResponseBuilder responseBuilder = Response.noContent();
		User user = this.userRepository.loadByUid(uid);
		if(user != null) {
			responseBuilder.status(204);
		} else {
			responseBuilder.status(401);
		}
		return responseBuilder.build();
	}
}
