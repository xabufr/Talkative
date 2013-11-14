package com.talkative.models;

public class Article {
	private long id;
	private String title;
	private String text;
	private User author;
	private WebSite web_site;
	
	public Article() {}
	
	public Article(String title, String article, User author) {
		this.title = title;
		this.text = article;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle() {
		return text;
	}

	public void setArticle(String article) {
		this.text = article;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public WebSite getWebSite() {
		return web_site;
	}

	public void setWebSite(WebSite web_site) {
		this.web_site = web_site;
	}
	
	@Override
	public boolean equals(Object a) {
		if (!(a instanceof Article))
			return false;
		Article article = (Article) a;
		
		if (article.author != null && this.author != null && article.title != null && article.text != null && this.title != null && this.text != null)
			return article.getAuthor().equals(this.author) && article.title.equals(this.title) && article.id == this.id;
		
		return false;
	}
	
}
