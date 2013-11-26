package com.talkative.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.talkative.models.User;
import com.talkative.models.Website;
import com.talkative.repositories.WebsiteRepository;

public class WebsiteResource {
	
	private RepositoryFactory repositoryFactory;
	private String websiteName;
	private User user;
	
	public WebsiteResource(RepositoryFactory factory, String websiteName, User user) {
		this.repositoryFactory = factory;
		this.websiteName = websiteName;
		this.user = user;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response retreive() {
		
		WebsiteRepository repo = repositoryFactory.getWebsiteRepo();
		
		if (!repo.exists(user, websiteName))
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return Response.ok(repo.loadByName(websiteName)).build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response alter(Website website) {
		
		WebsiteRepository repo = repositoryFactory.getWebsiteRepo();
		
		if (repo.mergeWebsiteData(website))
			return Response.ok(repo.loadByName(website.getDomain())).build();

		return Response.noContent().status(Status.CONFLICT).build();
	}
	
	@Path("articles")
	public ArticlesResource getArticlesResource() {
		return new ArticlesResource(repositoryFactory, repositoryFactory.getWebsiteRepo().loadByName(websiteName));
	}
}
