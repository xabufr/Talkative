package com.talkative.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.talkative.exceptions.AlreadyExistsException;
import com.talkative.exceptions.NotFoundException;
import com.talkative.models.User;

@Singleton
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
	public User loadByLogin(String login) {
		for( User user : users){
			if(user.getLogin()==login){
				return user;
			}
		}
		throw new WebApplicationException(Status.NOT_FOUND);
	}
	

	@Override
	public User createUser(
			String login,
			String password,
			String email) {
		User user=new User();
		User userToTest = new User(login, email);
		for (User u : users){
			if ((u.equals(userToTest))){
				throw new AlreadyExistsException();
			}
		}
		user.setPassword(password);	
		user.setLogin(login);
		user.setEmail(email);
		user.setId(lastUserId++);
		users.add(user);
		
		return user;
	}
	
	@Override
	public List<User> loadAll() {
		return this.users;
	}
}
