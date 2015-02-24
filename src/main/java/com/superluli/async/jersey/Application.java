package com.superluli.async.jersey;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.log.Logger;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Application extends ResourceConfig {

	public static void main(String[] args) throws Exception{
		
		System.getProperties().put("org.eclipse.jetty.util.log.class", "com.superluli.sync.jersey.Application.DummyLogger");
		
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
		ResourceConfig config = new ResourceConfig(RestService.class);
		Server server = JettyHttpContainerFactory.createServer(baseUri, config);
		server.start();
	}
	
	static class DummyLogger implements Logger{

		@Override
		public void debug(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void debug(String arg0, Object... arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void debug(String arg0, long arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void debug(String arg0, Throwable arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Logger getLogger(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void ignore(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void info(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void info(String arg0, Object... arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void info(String arg0, Throwable arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean isDebugEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setDebugEnabled(boolean arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void warn(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void warn(String arg0, Object... arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void warn(String arg0, Throwable arg1) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
