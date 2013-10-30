package com.talkative.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class TalkativeApplication extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		HashSet<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(UsersResource.class);
		return classes;
	}
	@Override
	public Set<Object> getSingletons() {
		HashSet<Object> singletons = new HashSet<>();
		return singletons;
	}
}
