package com.talkative.service;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.talkative.models.WebSite;

public class ArticleResource {
	private WebSite site;
	public ArticleResource(WebSite site) {
		this.site = site;
	}
	
	@Path("comments")
	public Response getComments() {
		return Response.noContent().build();
	}
}
