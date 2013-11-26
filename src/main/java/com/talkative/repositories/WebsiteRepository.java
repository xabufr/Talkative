package com.talkative.repositories;

import java.util.List;

import com.talkative.models.User;
import com.talkative.models.Website;

public interface WebsiteRepository extends GenericRepository<Website> {
	Website load(User user, String websiteName);
	Website loadByName(String websiteName);
	
	boolean exists(User user, String websiteName);
	List<Website> loadAll(User user);
	
	boolean addWebsite(User user, Website website);
	boolean mergeWebsiteData(Website website);
}
