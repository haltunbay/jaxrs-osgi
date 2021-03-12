package org.example.consumer1;

import org.example.rest.api.IGreeter;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.eclipsesource.jaxrs.consumer.ConsumerFactory;

@Component
public class RestConsumer {
	
	@Activate
	public void activate() {
		//ClientConfig config = new ClientConfig().register( new TextProvider() );
		String baseUrl = "http://localhost:9090/services";
		IGreeter g = ConsumerFactory.createConsumer(baseUrl,  IGreeter.class);
		System.out.printf("greeter endpoint : %s, response is %s \n", baseUrl, g.greet());
	}

}
