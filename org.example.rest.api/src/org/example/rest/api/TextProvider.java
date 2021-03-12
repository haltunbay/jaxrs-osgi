package org.example.rest.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
public class TextProvider implements MessageBodyReader<String> {

	@Override
	public boolean isReadable( Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType ) {
		return String.class.isAssignableFrom( type );
	}

	@Override
	public String readFrom(Class<String> type,
            Type genericType,
            Annotation[] annotations,
            MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException {
		return convertStreamToString(entityStream);
	}
	
	public String convertStreamToString( InputStream is ) throws IOException {
	    Writer writer = new StringWriter();
	    char[] buffer = new char[ 1024 ];
	    try {
	      Reader reader = new BufferedReader( new InputStreamReader( is, "UTF-8" ) );
	      int n;
	      while( ( n = reader.read( buffer ) ) != -1 ) {
	        writer.write( buffer, 0, n );
	      }
	    } finally {
	      is.close();
	    }
	    return writer.toString();
	  }
}
