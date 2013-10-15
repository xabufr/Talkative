package com.talkative.repositories;

import com.talkative.models.User;

public interface UserRepository extends GenericRepository<User> {
	User loadByUid(String uid);
}
