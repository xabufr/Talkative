package com.talkative.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("test")
public class TestFonctionnement {

	@GET
	@Path("{nom}")
	public String retournerNom(@PathParam("nom") String nom) {
		return nom;
	}
}
