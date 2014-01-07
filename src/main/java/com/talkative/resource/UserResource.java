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
import com.talkative.repositories.UserRepository;

public class UserResource {
	
	private RepositoryFactory repositoryFactory;

	private String login;

	public UserResource(RepositoryFactory factory, String login) {
		this.repositoryFactory = factory;
		this.login = login;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response retreive() {
		
		UserRepository repo = repositoryFactory.getUserRepo();
		
		if (!repo.loginExistsInRepository(login))
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return Response.ok(repo.loadByLogin(login)).build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response alter(User user) {
		
		UserRepository repo = repositoryFactory.getUserRepo();
		
		if (repo.mergeUserData(login, user))
			return Response.ok(repo.loadByLogin(user.getLogin())).build();
		
		return Response.noContent().status(Status.CONFLICT).build();
	}
	
	@Path("articles")
	public ArticlesResource getSitesResource() {
		return new ArticlesResource(repositoryFactory, repositoryFactory.getUserRepo().loadByLogin(login));
	}
}
