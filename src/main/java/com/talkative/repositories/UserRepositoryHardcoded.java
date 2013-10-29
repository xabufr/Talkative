package com.talkative.repositories;

import java.util.ArrayList;
import java.util.List;

import com.talkative.exceptions.AlreadyExistsException;
import com.talkative.exceptions.NotFoundException;
import com.talkative.models.User;


public class UserRepositoryHardcoded implements UserRepository {

	private List<User> users;
	private int lastUserId;
	
	public UserRepositoryHardcoded(){
		users = new ArrayList<User>();
		lastUserId=0;
	}
	
	@Override
	public User load(long id) {
		for(User user : users){
			if(user.getId()==id){
				return user;
			}
		}
		throw new NotFoundException();
	}

	@Override
	public User loadByUid(String uid) {
		for( User user : users){
			if(user.getUid()==uid){
				return user;
			}
		}
		throw new NotFoundException();
	}
	

	@Override
	public User createUser( String lastName, String firstName,
			String password, String email) {
		User user=new User();
		User userToTest = new User(lastName, firstName, email);
		for (User u : users){
			if ((u.equals(userToTest))){
				throw new AlreadyExistsException();
			}
		}
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);	
		user.setId(lastUserId++);
		user.setUid(String.valueOf(lastUserId));
		
		users.add(user);
		
		return user;
	}

	
}
