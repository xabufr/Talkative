package com.talkative.resource;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.talkative.models.User;
import com.talkative.models.Website;
import com.talkative.repositories.WebsiteRepository;

public class WebsitesResource {
	
	private RepositoryFactory repositoryFactory;

	private User user;
	
	public WebsitesResource(RepositoryFactory factory, User user) {
		this.repositoryFactory = factory;
		this.user = user;
	}

	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response add(Website website) {
		
		if(!repositoryFactory.getWebsiteRepo().addWebsite(user, website))
			return Response.noContent().status(Status.CONFLICT).build();
		
		return Response.status(Status.CREATED).entity(website).build();
	}
	
	@Path("{sitename}")
	public WebsiteResource getSiteResource(@PathParam("sitename") String siteName) {
		
		if (!repositoryFactory.getWebsiteRepo().exists(user, siteName))
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return new WebsiteResource(repositoryFactory, siteName, user);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Website> retreiveAllWebsitesFromUser() {
		return repositoryFactory.getWebsiteRepo().loadAll(user);
	}
}
