package com.talkative.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.talkative.repositories.WebsiteRepositoryHardCoded;
import com.talkative.resource.UsersResource;

@ApplicationPath("api")
public class TalkativeApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(UsersResource.class);
		return classes;
	}
//	
//	@Override
//	public Set<Object> getSingletons() {
//		HashSet<Object> singletons = new HashSet<>();
//		singletons.add(new WebsiteRepositoryHardCoded());
//		return singletons;
//	}
}
