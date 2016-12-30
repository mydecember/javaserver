package com.sun.hibernate.http.jettyservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
public class HelloMessage extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}


	/**
	 * 
	 */
	  private static final String greeting = "Hello Jetty";  
	  
	  @Override
      protected void doGet(HttpServletRequest request,  
              HttpServletResponse response) throws ServletException,  
              IOException {  


          response.setContentType("text/html");  
          response.setStatus(HttpServletResponse.SC_OK);  
          response.getWriter().println(greeting);  
      }  
	

}
