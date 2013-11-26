package com.talkative.repositories;

import com.talkative.models.User;

public interface UserRepository extends GenericRepository<User> {
	
	User loadByLogin(String login);
	boolean loginExistsInRepository(String login);
	boolean emailExistsInRepository(String mail);
	
	User createUser(String login, String password, String email);
	User createUser(User user);
	boolean mergeUserData(String login, User newUser);
}
