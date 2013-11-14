package com.talkative.models;

import javax.ws.rs.core.MediaType;
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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.repositories.hardcoded.UserRepositoryHardcoded;
import com.talkative.service.TalkativeApplication;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class EditorTest {

	@Module
	@Classes(TalkativeApplication.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}
	
	@Module
	public EjbJar ejbJar() {
		return new EjbJar().enterpriseBean(new SingletonBean(UserRepositoryHardcoded.class));
	}

	@Test
	public void canReturnHTTPCodeWhenUserTriesToConnect() {

		WebClient webClient = this.createWebClient();

		try {
			webClient.path("/users/unknown").get(String.class);
		} catch (Exception e) {
			Assert.assertEquals(Status.NOT_FOUND.getStatusCode(), webClient
					.getResponse().getStatus());
		}
	}

	@Test
	public void canCreatesUser() {

		WebClient webClient = this.createWebClient();
		webClient.path("/users/");
		webClient.type(MediaType.APPLICATION_FORM_URLENCODED);
		webClient.post("login=toto&password=12345678&email=toto@toto.fr");
		Assert.assertEquals(Status.CREATED.getStatusCode(), webClient
				.getResponse().getStatus());

		try {
			webClient.post("login=toto&password=12345678&email=toto@toto.fr");
		} catch (Exception e) {
			Assert.assertEquals(Status.CONFLICT.getStatusCode(), webClient
					.getResponse().getStatus());
		}
	}

	private WebClient createWebClient() {
		WebClient client = WebClient.create("http://localhost:4204/talkative/api");
		ClientConfiguration config = WebClient.getConfig(client);
		config.getInInterceptors().add(new LoggingInInterceptor());
		config.getOutInterceptors().add(new LoggingOutInterceptor());
		return client;
	}
}
