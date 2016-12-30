package com.sun.hibernate.main;
import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.sun.hibernate.dao.hbm.HistoryMessage;
import com.sun.hibernate.http.JettyServer;


public class MyServer {
	private static final Logger log = LoggerFactory.getLogger(MyServer.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("1111111111");
		DOMConfigurator.configure("conf/log4j.xml");
        System.out.println( "Hello World!" );
        log.error("1111");
        log.info("fghhhfffffffffff");
        log.info("kkkkkkkkkkkkk");
        
//        Configuration cfr = new Configuration().configure(new File("conf/hibernate.cfg.xml"));  
//        SessionFactory factory = cfr.buildSessionFactory();
//        Session session = null;
//        try{
//        	session = factory.openSession();
//        	session.beginTransaction();
//        	HistoryMessage msg = new HistoryMessage();
//        	
//        	msg.setMessage("11111111");
//        	msg.setId(2);
//        	msg.setLocalMsgId("dfgd");
//        	session.save(msg);
//        	session.getTransaction().commit();
//        }catch(Exception e) {
//        	e.printStackTrace();
//        	session.getTransaction().rollback();
//        }finally {
//        	if (session != null) {
//        		if (session.isOpen()) {
//        			session.close();
//        		}
//        	}
//        }
      //启动HTTP服务器（文件传输）
  		try {
  			JettyServer.getInstance().start();
  			log.info("jetty service started..");
  		} catch (Exception e2) {
  			e2.printStackTrace();
  			log.error("", e2);
  		}
        	
        
        
		
	}

}
