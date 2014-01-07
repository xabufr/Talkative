package com.talkative.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@SuppressWarnings("serial")
@ApplicationException
public class UserInputException extends WebApplicationException {
	public UserInputException(String message) {
		super(Response.status(Status.BAD_REQUEST).entity(message).build());
	}
}
