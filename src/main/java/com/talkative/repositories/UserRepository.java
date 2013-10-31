package com.talkative.repositories;

import com.talkative.models.User;

public interface UserRepository extends GenericRepository<User> {
	
	User loadByLogin(String login);
	User createUser(String login, String password, String email);
}
