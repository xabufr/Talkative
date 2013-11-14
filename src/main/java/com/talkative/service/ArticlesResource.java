package com.talkative.service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.talkative.models.Article;
import com.talkative.models.WebSite;
import com.talkative.repositories.ArticleRepository;

public class ArticlesResource {
	
	private WebSite webSite;
	
	ArticleRepository articleRepository;
	
	public ArticlesResource(WebSite webSite, ArticleRepository articleRepository) {
		this.webSite = webSite;
		this.articleRepository = articleRepository;
	}
	
	@Path("{article}")
	public ArticleResource getArticleResource(@PathParam("article") String title) {
		
		if (!this.articleRepository.containsArticle(webSite, title))
			throw new WebApplicationException(Status.NOT_FOUND);
		
		Article article = this.articleRepository.loadArticleFromSiteAndTitle(webSite, title);
		return new ArticleResource(article, articleRepository);
	}
}
