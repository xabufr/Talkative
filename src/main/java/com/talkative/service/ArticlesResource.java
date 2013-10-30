package com.talkative.service;

import javax.ws.rs.Path;

import com.talkative.models.WebSite;

public class ArticlesResource {
	private WebSite site;
	public ArticlesResource(WebSite site) {
		this.site = site;
	}
	
	@Path("{article}")
	public ArticleResource getArticleResource() {
		return new ArticleResource(site);
	}
}
