package com.talkative.service;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.talkative.models.Article;
import com.talkative.repositories.ArticleRepository;

public class ArticleResource {
	
	private Article article;
	
	@EJB
	private ArticleRepository article_repository;
	
	public ArticleResource(Article article) {
		this.article = article;
	}

	@GET
	@Path("comments")
	public Response getComments() {
		return Response.noContent().build();
	}
}
