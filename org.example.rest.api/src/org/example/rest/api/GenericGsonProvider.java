package org.example.rest.api;

import com.google.gson.Gson;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericGsonProvider<T> implements MessageBodyReader<T>  {
	private T t;
	@Override
	public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
		return t.getClass().isAssignableFrom(arg0);
	}

	@Override
	public T readFrom(Class<T> arg0, Type arg1, Annotation[] arg2, MediaType arg3, MultivaluedMap<String, String> arg4,
			InputStream s) throws IOException, WebApplicationException {
		Gson gson = new Gson();
		return (T) gson.fromJson(new InputStreamReader(s), t.getClass());
	}

}
