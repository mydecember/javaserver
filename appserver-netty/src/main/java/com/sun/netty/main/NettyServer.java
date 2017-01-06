package com.sun.netty.main;

import com.sun.netty.server.TimeServer;

public class NettyServer {
	 public static void main( String[] args ){
	        System.out.println( "Hello World!" );
	        System.out.println(NettyServer.class.getClass().getResource("/").getPath() );
	        try {
				new TimeServer().bind(8888);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }
	 
}
