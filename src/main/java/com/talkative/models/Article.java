package com.talkative.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article {

	private String title;
	private User author;
	private int lastID = 0;
	
	private Map<Integer, Comment> comments;
	
	public Article() {
		comments = new HashMap<Integer, Comment>();
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof String) {
			return ((String) o).equalsIgnoreCase(title);
		} if (o instanceof Article) {
			return o == this || ((Article) o).title.equalsIgnoreCase(title);
		}
		return false;
	}

	public int addComment(Comment comment) {
		comments.put(lastID, comment);
		return lastID++;
	}
	
	public Map<Integer, Comment> getComments() {
		return comments;
	}
	
	public Comment getComment(int key) {
		return comments.get(key);
	}
}
