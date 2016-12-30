package com.sun.hibernate.util;
import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.cfg.Configuration;  
import org.hibernate.tool.hbm2ddl.SchemaExport;  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.hibernate.main.MyServer;
public class ExoprtDB {
	private static final Logger log = LoggerFactory.getLogger(ExoprtDB.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("conf/log4j.xml");
	    //默认读取hibernate.cfg.xml文件  
        Configuration cfr = new Configuration().configure(new File("conf/hibernate.cfg.xml"));  
          
        SchemaExport export = new SchemaExport(cfr);  
        export.create(true, true);  
	}

}
