package com.talkative.service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.talkative.models.User;
import com.talkative.models.WebSite;
import com.talkative.repositories.ArticleRepository;
import com.talkative.repositories.WebSiteRepository;

public class SitesResource {
	
	private WebSiteRepository webSiteRepository;
	private ArticleRepository articleRepository;
	
	private User user;
	
	public SitesResource(User user, WebSiteRepository webSiteRepository, ArticleRepository articleRepository) {
		this.webSiteRepository = webSiteRepository;
		this.articleRepository = articleRepository;
		this.user = user;
	}
	
	@Path("{site}")
	public SiteResource getSiteResource(@PathParam("site") String sid) {
		WebSite site = webSiteRepository.load(user, sid);
		return new SiteResource(site, articleRepository);
	}
}
