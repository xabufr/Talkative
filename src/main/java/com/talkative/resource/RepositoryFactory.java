package com.talkative.resource;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.talkative.repositories.ArticleRepository;
import com.talkative.repositories.UserRepository;

@Singleton
public class RepositoryFactory {

	@EJB
	private UserRepository userRepository;
	
	@EJB
	private ArticleRepository articleRepository;
	
	public UserRepository getUserRepo() {
		return userRepository;
	}

	public ArticleRepository getArticleRepository() {
		return articleRepository;
	}
	
}
