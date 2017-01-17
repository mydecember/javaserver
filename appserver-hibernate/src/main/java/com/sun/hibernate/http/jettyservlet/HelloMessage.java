package com.sun.hibernate.http.jettyservlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.hibernate.main.MyServer;
@SuppressWarnings("serial")
public class HelloMessage extends HttpServlet{
	private static final Logger log = LoggerFactory.getLogger(HelloMessage.class);
	private int access = 0;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		log.info("do post3");
		access++;
		log.info("accesss num is:"+access);
		doGet(req, resp);
		log.info(req.getContentType());
		ServletInputStream in = req.getInputStream();
		byte[]  content= new byte[1000];
		int n = in.read(content);
		log.info(new String(content, "utf-8"));
		
		
		
	}


	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		log.info("111111111");
	}


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
		log.info("222222222");
	}


	/**
	 * 
	 */
	  private static final String greeting = "Hello Jetty";
	  
	  @Override
      protected void doGet(HttpServletRequest request,  
              HttpServletResponse response) throws ServletException,  
              IOException {  
		  
		  
		  System.out.println("getRequestURL: "+request.getRequestURL());  
	        System.out.println("getRequestURI: "+request.getRequestURI());  
	        System.out.println("getQueryString: "+request.getQueryString());  
	        System.out.println("getRemoteAddr: "+request.getRemoteAddr());  
	        System.out.println("getRemoteHost: "+request.getRemoteHost());  
	        System.out.println("getRemotePort: "+request.getRemotePort());  
	        System.out.println("getRemoteUser: "+request.getRemoteUser());  
	        System.out.println("getLocalAddr: "+request.getLocalAddr());  
	        System.out.println("getLocalName: "+request.getLocalName());  
	        System.out.println("getLocalPort: "+request.getLocalPort());  
	        System.out.println("getMethod: "+request.getMethod());  
	        System.out.println("-------request.getParamterMap()-------");  
	        //得到请求的参数Map，注意map的value是String数组类型  
	        Map<String, String[]> map = request.getParameterMap();  
	        Set<String> keySet = map.keySet();  
	        for (String key : keySet) {  
	        String[] values = (String[]) map.get(key);  
	        for (String value : values) {  
	            System.out.println(key+"="+value);  
	        }  
	     }  
	        System.out.println("--------request.getHeader()--------");  
	        //得到请求头的name集合  
	        Enumeration<String> em = request.getHeaderNames();  
	        while (em.hasMoreElements()) {  
	        String name = (String) em.nextElement();  
	        String value = request.getHeader(name);  
	        System.out.println(name+"="+value); 
      
	        }
	        response.setContentType("text/html");  
	          response.setStatus(HttpServletResponse.SC_OK);  
	          response.getWriter().println(greeting);  
	  }
}
