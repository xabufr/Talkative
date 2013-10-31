package com.talkative.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

@SuppressWarnings("serial")
@ApplicationException
public class AlreadyExistsException extends WebApplicationException {
	public AlreadyExistsException() {
		super(Status.CONFLICT);
	}
}
