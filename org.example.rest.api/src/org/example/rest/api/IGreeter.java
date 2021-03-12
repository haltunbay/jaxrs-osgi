package org.example.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public interface IGreeter {
	
	@GET
	public String greet( );
}
