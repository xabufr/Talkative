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
import com.talkative.repositories.UserRepository;

@Path("users")
public class UsersResource {
	
	@EJB
	private RepositoryFactory repositoryFactory;

	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response add(User user) {
		
		UserRepository repo = repositoryFactory.getUserRepo();
		
		if (!user.isValid())
			return Response.status(Status.NOT_ACCEPTABLE.getStatusCode()).entity(user.getMissingElements()).build();
		
		if (repo.loginExistsInRepository(user.getLogin()) || repo.emailExistsInRepository(user.getEmail()))
			return Response.noContent().status(Status.CONFLICT).build();
		
		return Response.status(Status.CREATED.getStatusCode()).entity(repo.createUser(user)).build();
	}
	
	@Path("{login}")
	public UserResource alter(@PathParam("login") String login) {
		
		if (!repositoryFactory.getUserRepo().loginExistsInRepository(login))
			throw new WebApplicationException(Status.NOT_FOUND);
		
		return new UserResource(repositoryFactory, login);
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<User> retreiveAll() {
		return repositoryFactory.getUserRepo().loadAll();
	}
}
