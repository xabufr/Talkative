package com.talkative.models;

import static org.junit.Assert.*;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.talkative.service.UsersResource;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class ArticleTest {

	@Module
	@Classes(UsersResource.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}


	private WebClient createWebClient() {
        WebClient client = WebClient.create("http://localhost:4204/talkative"); // /api");
        ClientConfiguration config = WebClient.getConfig(client);
        config.getInInterceptors().add(new LoggingInInterceptor());
        config.getOutInterceptors().add(new LoggingOutInterceptor());
        return client;
	}
}
