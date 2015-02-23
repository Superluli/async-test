package com.superluli.async.jersey;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

	public Application() {
		packages("com.superluli.async.jersey");
	}

	public static void main(String[] args) throws Exception{
		
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
		ResourceConfig config = new ResourceConfig(RestService.class);
		Server server = JettyHttpContainerFactory.createServer(baseUri, config);
		server.start();
	}
}
