package com.talkative.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.talkative.models.WebSite;
import com.talkative.repositories.WebSiteRepository;

public class SitesResource {
	
	@EJB
	private WebSiteRepository webSiteRepository;
	
	@Path("{site}")
	public SiteResource getSiteResource(@PathParam("site") String domain) {
		
		if (!webSiteRepository.containsDomain(domain))
			throw new WebApplicationException(Status.NOT_FOUND);
		
		WebSite site = webSiteRepository.loadByDomain(domain);
		return new SiteResource(site);
	}
}
