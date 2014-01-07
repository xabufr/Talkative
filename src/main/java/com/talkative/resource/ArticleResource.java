package com.talkative.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.talkative.models.Article;
import com.talkative.models.Comment;
import com.talkative.models.User;

public class ArticleResource {
	private Article article;
	
	public ArticleResource(Article article) {
		this.article = article;
	}

	@Path("comments")
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response createsComment(Comment comment) throws URISyntaxException {
		
		comment.throwAnExceptionIfNotValid();
		int idComment = article.addComment(comment);
		return Response.created(new URI("/comments/" + String.valueOf(idComment))).build();
	}
	
	@Path("comments")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getComments() {
		return Response.ok().entity(article.getComments()).build();
	}
	
	@Path("comments/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getComment(@PathParam("id") int idComment) {
		return Response.ok().entity(article.getComment(idComment)).build();
	}
	
}
