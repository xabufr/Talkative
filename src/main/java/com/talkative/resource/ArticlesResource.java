package com.talkative.resource;

import javax.ws.rs.Path;

import com.talkative.models.User;

public class ArticlesResource {
	
	private RepositoryFactory repositoryFactory;
	private User user;
	
	public ArticlesResource(RepositoryFactory factory, User user) {
		this.repositoryFactory = factory;
		this.user = user;
	}
	
	@Path("{article}")
	public ArticleResource getArticleResource() {
		return new ArticleResource(user);
	}
}
