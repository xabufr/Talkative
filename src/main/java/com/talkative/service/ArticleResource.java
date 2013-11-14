package com.talkative.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.talkative.models.Article;
import com.talkative.repositories.ArticleRepository;

public class ArticleResource {
	
	private Article article;
	
	private ArticleRepository articleRepository;
	
	public ArticleResource(Article article, ArticleRepository articleRepository) {
		this.article = article;
		this.articleRepository = articleRepository;
	}

	@GET
	@Path("comments")
	public Response getComments() {
		return Response.noContent().build();
	}
}
