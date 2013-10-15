package com.talkative.models;

import static org.junit.Assert.*;

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

}
