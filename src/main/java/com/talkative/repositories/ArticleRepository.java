package com.talkative.repositories;

import javax.ws.rs.core.Response;

import com.talkative.models.Article;
import com.talkative.models.User;
import com.talkative.models.WebSite;

public interface ArticleRepository extends GenericRepository<Article>{

	public Article createArticle(String title, String article);
	public Response updateArticle(String title, String article);
	public Response deleteArticleByID(long id);
	public User getAuthorFromArticleID(long id);
	public boolean containsArticle(WebSite webSite, String title);
	public Article loadArticleFromSiteAndTitle(WebSite webSite, String title);
}
