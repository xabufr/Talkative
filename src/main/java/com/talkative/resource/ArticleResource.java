package com.talkative.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.talkative.models.Website;

public class ArticleResource {
	private Website site;
	public ArticleResource(Website site) {
		this.site = site;
	}
	
	@Path("comments")
	@GET
	public Response getComments() {
		return Response.noContent().build();
	}
}
