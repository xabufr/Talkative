package com.talkative.models;

import javax.xml.bind.annotation.XmlRootElement;

import com.talkative.exceptions.UserInputException;
import com.talkative.resource.InputValidator;

@XmlRootElement
public class Comment {
	
	private String comment;
	private String pseudo;
	private String eMail;
	private long date;
	
	public void throwAnExceptionIfNotValid() {
		String message = "";
		if (!InputValidator.isAValidEMail(eMail))
			message += "wrong email,";
		
		if (!InputValidator.isAValidLogin(pseudo))
			message += "wrong pseudo,";
		
		if (comment.isEmpty())
			message += "empty comment";
		
		if (!message.isEmpty())
			throw new UserInputException(message);
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getEmail() {
		return eMail;
	}
	public void setEmail(String eMail) {
		this.eMail = eMail;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
}
