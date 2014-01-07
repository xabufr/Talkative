package com.talkative.resource;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.talkative.repositories.UserRepository;

@Singleton
public class RepositoryFactory {

	@EJB
	private UserRepository userRepository;
	
	public UserRepository getUserRepo() {
		return userRepository;
	}
	
}
