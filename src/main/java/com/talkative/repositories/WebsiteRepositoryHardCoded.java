package com.talkative.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.talkative.exceptions.NotFoundException;
import com.talkative.models.User;
import com.talkative.models.Website;

@Singleton
public class WebsiteRepositoryHardCoded implements WebsiteRepository {

	private List<Website> websites;
	private int lastWebsiteId;

	public WebsiteRepositoryHardCoded (){
		websites = new ArrayList<Website>();
		lastWebsiteId = 0;
	}
	
	@Override
	public Website load(long id) {
		for (Website w : websites)
			if (w.getId() == id)
				return w;
		throw new NotFoundException();
	}

	@Override
	public List<Website> loadAll() {
		throw new NotFoundException();
	}

	@Override
	public Website load(User user, String siteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Website> loadAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Website loadByName(String websiteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(User user, String websiteName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWebsite(User user, Website website) {
		
		for (Website w : websites)
			if (w.getDomain().equalsIgnoreCase(website.getDomain()))
				return false;
		website.setOwner(user);
		website.setId(lastWebsiteId++);
		websites.add(website);
		return true;
	}

	@Override
	public boolean mergeWebsiteData(Website website) {
		// TODO Auto-generated method stub
		return false;
	}

}
