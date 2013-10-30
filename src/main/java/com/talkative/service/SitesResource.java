package com.talkative.service;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.talkative.models.User;
import com.talkative.models.WebSite;
import com.talkative.repositories.WebSiteRepository;

public class SitesResource {
	private User user;
	@Inject
	private WebSiteRepository webSiteRepository;
	public SitesResource(User user) {
		this.user = user;
	}
	
	@Path("{site}/")
	public SiteResource getSiteResource(@PathParam("site") String sid) {
		WebSite site = webSiteRepository.load(user, sid);
		return new SiteResource(site);
	}
}
