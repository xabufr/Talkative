package com.talkative.service;

import javax.ws.rs.Path;

import com.talkative.models.User;
import com.talkative.repositories.ArticleRepository;
import com.talkative.repositories.WebSiteRepository;

public class UserResource {

	private User user;
	
	private WebSiteRepository webSiteRepository;
	private ArticleRepository articleRepository;

	public UserResource(User user, WebSiteRepository webSiteRepository, ArticleRepository articleRepository) {
		this.user = user;
		this.articleRepository = articleRepository;
		this.webSiteRepository = webSiteRepository;
	}
	
	@Path("sites")
	public SitesResource getSitesResource() {
		return new SitesResource(user, webSiteRepository, articleRepository);
	}
	
	@Path("/")
	public String getUserInfos() {
		return "le nom de l'utilisateur est:" + this.user.getLogin();
	}
}
