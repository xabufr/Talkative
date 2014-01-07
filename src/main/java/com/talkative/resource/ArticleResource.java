package com.talkative.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.talkative.models.User;

public class ArticleResource {
	private User user;
	public ArticleResource(User site) {
		this.user = site;
	}
	
	@Path("comments")
	@GET
	public Response getComments() {
		return Response.noContent().build();
	}
}
