package com.talkative.repositories.hardcoded;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import org.apache.commons.lang.NotImplementedException;

import com.talkative.exceptions.NotFoundException;
import com.talkative.models.User;
import com.talkative.models.WebSite;
import com.talkative.repositories.WebSiteRepository;

@Singleton
public class WebSiteRepositoryHardcoded implements WebSiteRepository {
	private Map<User, List<WebSite>> webSites = new HashMap<>();

	@Override
	public WebSite load(long id) {
		throw new NotImplementedException();
	}

	@Override
	public List<WebSite> loadAll() {
		throw new NotImplementedException();
	}

	@Override
	public WebSite load(User user, String sid) {
		for (User currentUser : webSites.keySet()) {
			if (currentUser.equals(user)) {
				for (WebSite currentWebSite : webSites.get(currentUser)) {
					if (currentWebSite.getSid().equalsIgnoreCase(sid))
						return currentWebSite;
				}
			}
		}
		throw new NotFoundException();
	}
}
