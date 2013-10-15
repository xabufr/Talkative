package com.talkative.models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.talkative.repositories.UserRepositoryHardcoded;

public class UserRepositoryHardcodedTest {
	private UserRepositoryHardcoded repositoryHardcoded;

	@Before
	public void setUp() throws Exception {
		this.repositoryHardcoded = new UserRepositoryHardcoded();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(null, repositoryHardcoded.load(2));
		assertEquals(null, repositoryHardcoded.loadByUid("uidD"));
		assertNotEquals(null, repositoryHardcoded.loadByUid("uid"));
		assertNotEquals(null, repositoryHardcoded.loadByUid("uId"));
		assertNotEquals(null, repositoryHardcoded.loadByUid("UID"));
		assertNotEquals(null, repositoryHardcoded.load(1));
	}

}
