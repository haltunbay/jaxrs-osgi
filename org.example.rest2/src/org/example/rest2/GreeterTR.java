package org.example.rest2;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.example.rest.api.IGreeter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Path("/hellotr")
@Component
public class GreeterTR implements IGreeter {
	

	@Activate
	public void activate() {
		
	}

	@GET
	@Override
	public String greet() {
		return "Merhaba !!";
	}
	
}
