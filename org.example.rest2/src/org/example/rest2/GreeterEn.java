package org.example.rest2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.example.rest.api.IGreeter;
import org.osgi.service.component.annotations.Component;

@Path("/hello")
@Component
public class GreeterEn implements IGreeter {
	
	@GET
	public String greet() {
		return "Hello !! ";
	}
}
