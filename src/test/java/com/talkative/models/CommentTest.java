package com.talkative.models;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.repositories.ArticleRepositoryHardCoded;
import com.talkative.repositories.CommentRepositoryHardCoded;
import com.talkative.repositories.UserRepositoryHardcoded;
import com.talkative.resource.RepositoryFactory;
import com.talkative.resource.UsersResource;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class CommentTest {

	private WebClient webClient;
	
	@Module
	@Classes(UsersResource.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}

	@Module
	@Classes({ RepositoryFactory.class, UserRepositoryHardcoded.class, ArticleRepositoryHardCoded.class, CommentRepositoryHardCoded.class })
	public EjbJar ejbjar() {
		return new EjbJar();
	}

	@Before
	public void setUp() {
		webClient = this.createWebClient();
		
	}
	@Test
	public void canAddAnAnonymousCommentOnAnArticle() {
		
		Comment comment = new Comment();
		comment.setPseudo("toto");
		comment.setComment("c'est de la merde!");
		
		webClient.path("users/toto/articles/toto01/comments");
		webClient.post(comment, Response.class);
		
		assertEquals(Status.BAD_REQUEST.getStatusCode(), webClient.getResponse().getStatus());

		comment.setEmail("tructoto@toto.fr");
		webClient.post(comment, Response.class);
		assertEquals(Status.CREATED.getStatusCode(), webClient.getResponse().getStatus());
	}

	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative"); // /api/");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client;
	}
}
