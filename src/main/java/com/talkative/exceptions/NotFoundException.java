package com.talkative.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class NotFoundException extends WebApplicationException {
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(Status.NOT_FOUND);
	}
}
