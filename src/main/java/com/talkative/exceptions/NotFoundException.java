package com.talkative.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


@SuppressWarnings("serial")
@ApplicationException
public class NotFoundException extends WebApplicationException {
	public NotFoundException() {
		super(Response.status(Response.Status.NOT_FOUND).entity("not found exception").build());
	}
}
