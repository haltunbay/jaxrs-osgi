package org.example.rest1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class ExampleResource {
	@GET
	public String helloWorld() {
		return "Hello world";
	}
}
