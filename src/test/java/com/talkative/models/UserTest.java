package com.talkative.models;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User user;
		
	@Before
	public void setUp() throws Exception {
		this.user = new User();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		assertEquals( null, user.getLastName() );
		user.setLastName("coucou");
		assertEquals( "coucou", user.getLastName() );
	}

	@Test
	public void returnsHTTPCodeWhenUserTriesToConnect() {
		
		WebClient webClient = WebClient.create("http://localhost:8080").path("/talkative/api/comment/get.json"); // ?uid=0&sid=1&pid=1");
		webClient.query("uid", "0");
		webClient.query("sid", "1");
		webClient.query("pid", "1");
		
		assertEquals(401, webClient.get(Response.class).getStatus());

		webClient.replaceQueryParam("uid", "UID");
		assertEquals(204, webClient.get(Response.class).getStatus());
	}
}
