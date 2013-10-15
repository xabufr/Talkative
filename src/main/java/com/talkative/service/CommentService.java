package com.talkative.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("api/comment/")
public class CommentService {
	@Path("get.json")
	@GET
	public String getComments(@QueryParam("uid") String uid,
			@QueryParam("sid") String sid,
			@QueryParam("pid") String pid) {
		return "commentService";
	}
}
