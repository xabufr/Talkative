package com.talkative.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.talkative.models.Article;
import com.talkative.models.User;
import com.talkative.repositories.ArticleRepository;

public class ArticlesResource {
	
	private RepositoryFactory repositoryFactory;
	private User user;
	
	public ArticlesResource(RepositoryFactory factory, User user) {
		this.repositoryFactory = factory;
		this.user = user;
	}
	
	@Path("{title}")
	public ArticleResource getArticleResource(@PathParam("title") String title) {
		
		ArticleRepository repository = repositoryFactory.getArticleRepository();
		Article article = repository.getOrCreatesIfNotExists(user, title);
		
		
		return new ArticleResource(article);
	}
}
