package com.talkative.service;

import javax.ws.rs.Path;

import com.talkative.models.WebSite;

public class SiteResource {
	private WebSite site;
	
	public SiteResource(WebSite site) {
		this.site = site;
	}
	
	@Path("articles")
	public ArticlesResource getArticlesResource() {
		return new ArticlesResource(site);
	}
}
