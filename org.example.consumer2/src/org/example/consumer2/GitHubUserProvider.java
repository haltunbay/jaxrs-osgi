/*******************************************************************************
 * Copyright (c) 2012 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Holger Staudacher - initial API and implementation
 ******************************************************************************/
package org.example.consumer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;

@Provider
public class GitHubUserProvider implements MessageBodyReader<GitHubUser> {

  @Override
  public boolean isReadable( Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType ) {
    return GitHubUser.class.isAssignableFrom( type );
  }

  @Override
  public GitHubUser readFrom( Class<GitHubUser> type,
                              Type genericType,
                              Annotation[] annotations,
                              MediaType mediaType,
                              MultivaluedMap<String, String> httpHeaders,
                              InputStream entityStream )
    throws IOException, WebApplicationException
  {
    try {
      Gson gson =new Gson();
      return gson.fromJson(convertStreamToString( entityStream ), GitHubUser.class);
    } catch( Exception shouldNotHappen ) {
      throw new IllegalStateException( shouldNotHappen );
    }
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
