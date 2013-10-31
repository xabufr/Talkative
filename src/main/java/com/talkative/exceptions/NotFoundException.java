package com.talkative.exceptions;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;


@SuppressWarnings("serial")
@ApplicationException
public class NotFoundException extends WebApplicationException {
	public NotFoundException() {
		super(404);
	}
}
