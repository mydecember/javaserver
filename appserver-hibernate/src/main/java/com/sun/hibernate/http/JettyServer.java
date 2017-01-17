package com.sun.hibernate.http;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.hibernate.http.jettyservlet.HelloMessage;




public class JettyServer {
private static final Logger log = LoggerFactory.getLogger(JettyServer.class);
	private static final int port = 8082;

	
	private JettyServer(){}
	
	private static JettyServer instance;
	
	public static JettyServer getInstance(){
		if(instance == null)
			instance = new JettyServer();
		
		return instance;
	}
	
	public void start() throws Exception{
		 Server server = new Server(port);  
		  
	        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);  
	        context.setContextPath("/");  
	        server.setHandler(context);  
	  
	        // http://localhost:8080/hello  
	        context.addServlet(new ServletHolder(new HelloMessage()), "/hello");  
	        
	        server.start();  
//      server.join();

        log.info("Jetty server started at port [" + port + "]");
	}
}
