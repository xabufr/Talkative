package com.talkative.resource;

import javax.ws.rs.Path;

import com.talkative.models.Website;

public class ArticlesResource {
	
	private RepositoryFactory repositoryFactory;
	private Website site;
	
	public ArticlesResource(RepositoryFactory factory, Website site) {
		this.repositoryFactory = factory;
		this.site = site;
	}
	
	@Path("{article}")
	public ArticleResource getArticleResource() {
		return new ArticleResource(site);
	}
}
