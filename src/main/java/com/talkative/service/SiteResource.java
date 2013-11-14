package com.talkative.service;

import javax.ws.rs.Path;

import com.talkative.models.WebSite;
import com.talkative.repositories.ArticleRepository;

public class SiteResource {
	private WebSite site;
	
	private ArticleRepository articleRepository;
	
	public SiteResource(WebSite site, ArticleRepository articleRepository) {
		this.site = site;
		this.articleRepository = articleRepository;
	}
	
	@Path("articles")
	public ArticlesResource getArticlesResource() {
		return new ArticlesResource(site, articleRepository);
	}
}
