package com.talkative.models;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.openejb.jee.WebApp;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Classes;
import org.apache.openejb.testing.EnableServices;
import org.apache.openejb.testing.Module;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ApplicationComposer.class)
@EnableServices("jaxrs")
public class EditorTest {

	@Module
	@Classes(UsersRessource.class)
	public WebApp webapp() {
		return new WebApp().contextRoot("talkative");
	}
	
	@Test
	public void canReturnHTTPCodeWhenUserTriesToConnect() {
		
		WebClient webClient = this.createWebClient();
		
		webClient.path("user/no+name").get(String.class);
		
		Assert.assertEquals(204, webClient.getResponse().getStatus());
        Assert.assertEquals("http://www.epsi.fr/i4/mon%20article.html; rel=\"article\"", webClient.getResponse().getMetadata().getFirst("Link"));
        Assert.assertNull(message)
	}
	
	private WebClient createWebClient() {
        WebClient client = WebClient.create("http://localhost:4204/talkative/api");
        ClientConfiguration config = WebClient.getConfig(client);
        config.getInInterceptors().add(new LoggingInInterceptor());
        config.getOutInterceptors().add(new LoggingOutInterceptor());
        return client;
	}
}
