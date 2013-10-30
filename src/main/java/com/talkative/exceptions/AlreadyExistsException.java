package com.talkative.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class AlreadyExistsException extends WebApplicationException {
	public AlreadyExistsException() {
		super(Status.CONFLICT);
	}
}
