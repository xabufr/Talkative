package com.talkative.repositories;

import com.talkative.models.User;

public class UserRepositoryHardcoded implements UserRepository {

	@Override
	public User load(long id) {
		if(id != 1)
			return null;
		return getUser();
	}

	@Override
	public User loadByUid(String uid) {
		if(!uid.equalsIgnoreCase("UID"))
			return null;
		return getUser();
	}
	private User getUser() {
		User u = new User();
		u.setId(1);
		u.setFirstName("first_name");
		u.setLastName("last_name");
		u.setUid("UID");
		return u;
	}
}
