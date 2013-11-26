package com.talkative.resource;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.talkative.repositories.UserRepository;
import com.talkative.repositories.WebsiteRepository;

@Singleton
public class RepositoryFactory {

	@EJB
	private UserRepository userRepository;
	
	@EJB
	private WebsiteRepository websiteRepository;

	public UserRepository getUserRepo() {
		return userRepository;
	}
	
	public WebsiteRepository getWebsiteRepo() {
		return websiteRepository;
	}
}
