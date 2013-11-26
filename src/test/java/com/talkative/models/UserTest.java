package com.talkative.models;

import static org.junit.Assert.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.SingletonBean;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.repositories.UserRepositoryHardcoded;
import com.talkative.service.TalkativeApplication;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class UserTest {

	private WebClient webClient;

	@Module
	@Classes(TalkativeApplication.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}

	@Module
	public EjbJar ejb() {
		return new EjbJar().enterpriseBean(new SingletonBean(UserRepositoryHardcoded.class));
	}
	
	@Before
	public void setUp() {
		this.webClient = this.createWebClient();
	}

	@Test
	public void canReturn404IfUserDoesntExist() {
//		WebClient webClient = this.createWebClient();
		webClient.path("users").path("unknown/");
		
		try {
			User user = webClient.get(User.class);
		} catch (WebApplicationException e) {
			assertEquals(404, webClient.getResponse().getStatus());
		}
	}
	
	@Test
	public void canCreateNewUsers() {
		
		for (int i = 0; i < 10; i++){
//			WebClient webClient = this.createWebClient();
			webClient = this.createWebClient();
			webClient.path("users/");
			webClient.type(MediaType.APPLICATION_XML);
			
			String userName = "user_" + i;
			User user = new User(userName, userName + "@mail.fr");
			user.setPassword("0123456789");
			webClient.post(user, Response.class);
			assertEquals(Status.CREATED.getStatusCode(), webClient.getResponse().getStatus());
		}		
	}
	
	@Test
	public void canReturnConflictWhenLoginOrMailAlreadyExist() {
//		WebClient webClient = this.createWebClient();
		webClient.path("users/");
		webClient.type(MediaType.APPLICATION_XML);
		User user = new User("user_0", "user_0@mail.fr");
		user.setPassword("0123456789");
		Response resp = webClient.post(user, Response.class);
		
		// login déjà utilisé
		user = new User("user_0", "user@mail.fr");
		user.setPassword("0123456789");
		resp = webClient.post(user, Response.class);
		assertEquals(Status.CONFLICT.getStatusCode(), webClient.getResponse().getStatus());
		
		// email déjà utilisé
		user = new User("user", "user_0@mail.fr");
		user.setPassword("0123456789");
		resp = webClient.post(user, Response.class);
		assertEquals(Status.CONFLICT.getStatusCode(), webClient.getResponse().getStatus());
	}
	
	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client;
	}
}
