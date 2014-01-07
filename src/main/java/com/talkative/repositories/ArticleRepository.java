package com.talkative.repositories;

import com.talkative.models.Article;
import com.talkative.models.User;

public interface ArticleRepository {

	public Article getOrCreatesIfNotExists(User author, String title);
	
}
