package com.talkative.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import com.talkative.models.Article;
import com.talkative.models.User;

@Singleton
public class ArticleRepositoryHardCoded implements ArticleRepository {

	private Map<User, List<Article>> articles;
	
	public ArticleRepositoryHardCoded() {
		articles = new HashMap<User, List<Article>>();
	}
	
	@Override
	public Article getOrCreatesIfNotExists(User author, String title) {
		
		List<Article> articlesOfUser = articles.get(author);
		
		if (articlesOfUser != null) {
			for (Article a : articlesOfUser) {
				if (a.equals(title))
					return a;
			}
		} else {
			articlesOfUser = new ArrayList<Article>();
			articles.put(author, articlesOfUser);
		}
		
		Article newArticle = new Article();
		newArticle.setTitle(title);
		newArticle.setAuthor(author);
		articlesOfUser.add(newArticle);
		
		return newArticle;
	}

}
