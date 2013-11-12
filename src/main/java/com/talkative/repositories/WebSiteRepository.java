package com.talkative.repositories;

import com.talkative.models.User;
import com.talkative.models.WebSite;

public interface WebSiteRepository extends GenericRepository<WebSite> {
	WebSite load(User user, String sid);
	WebSite loadByDomain(String domain);
	boolean containsDomain(String domain);	
}
