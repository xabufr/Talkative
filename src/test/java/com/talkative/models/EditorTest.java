package com.talkative.models;

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

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.repositories.UserRepository;
import com.talkative.repositories.UserRepositoryHardcoded;
import com.talkative.resource.RepositoryFactory;
import com.talkative.resource.UsersResource;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class EditorTest {

	@Module
	@Classes(UsersResource.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}
	
	@Module
	@Classes({RepositoryFactory.class, UserRepositoryHardcoded.class})
	public EjbJar ejbjar() {
		return new EjbJar();
	}
	
	@Test
	public void canReturnHTTPCodeWhenUserTriesToConnect() {
		
		WebClient webClient = this.createWebClient();
		
		try{
			webClient.path("users/unknown/").get(String.class);
			fail("Exception expected");
		}catch( Exception e ){
			assertEquals(Status.NOT_FOUND.getStatusCode(), webClient.getResponse().getStatus());
		}
	}
	
	@Test
	public void canCreatesUser() {

		WebClient webClient = this.createWebClient();
		User user = new User();
		user.setLogin("toto");
		user.setEmail("toto@toto.fr");
		user.setPassword("123456789");

		webClient.path("users/").post(user, Response.class);
		assertEquals(Status.CREATED.getStatusCode(), webClient.getResponse().getStatus());
		
		webClient.post(user, Response.class);
		assertEquals(Status.CONFLICT.getStatusCode(), webClient.getResponse().getStatus());
	}
	
	@Test
	public void returnsErrorWhileInscriptionIfLoginMissing() {
		
		WebClient webClient = this.createWebClient();
		User user = new User();
		user.setEmail("toto@toto.fr");
		user.setPassword("123456789");
		webClient.path("users/").post(user, Response.class);
		
		assertEquals(Status.NOT_ACCEPTABLE.getStatusCode(), webClient.getResponse().getStatus());
		
	}
	
	private WebClient createWebClient() {
        WebClient client = WebClient.create("http://localhost:4204/talkative"); ///api/");
        ClientConfiguration config = WebClient.getConfig(client);
        config.getInInterceptors().add(new LoggingInInterceptor());
        config.getOutInterceptors().add(new LoggingOutInterceptor());
        return client;
	}
}
