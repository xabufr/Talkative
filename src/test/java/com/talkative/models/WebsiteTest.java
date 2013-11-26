package com.talkative.models;

import static org.junit.Assert.*;

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
import com.talkative.repositories.WebsiteRepositoryHardCoded;
import com.talkative.resource.RepositoryFactory;
import com.talkative.service.TalkativeApplication;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class WebsiteTest {

	private WebClient webClient;
	private User user;

	@Module
	@Classes(TalkativeApplication.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}

	@Module
	public EjbJar ejb() {
		return new EjbJar().enterpriseBean(new SingletonBean(RepositoryFactory.class));
	}
	
	@Before
	public void setUp() {
		webClient = this.createWebClient();
		webClient.path("users");
		user = new User("toto", "toto@mail.fr");
		user.setPassword("123456789");
		webClient.post(user);
	}
	
	@Test
	public void canCreateANewWebsite() {
		webClient.path(user.getLogin()).path("sites");
		
		Website website = new Website();
		website.setDomain("www.toto.fr");
		webClient.post(website);
		assertEquals(Status.CREATED.getStatusCode(), webClient.getResponse().getStatus());
	}

	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:8080/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client;
	}
}
