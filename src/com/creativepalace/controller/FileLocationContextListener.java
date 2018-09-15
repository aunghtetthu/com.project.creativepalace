package com.creativepalace.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FileLocationContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		String rootPath = System.getProperty("catalina.home");
		ServletContext ctx = servletContextEvent.getServletContext();
		
		String [] fileDirs = {"staffphoto.dir", "studentphoto.dir"};
		for(String fileDir: fileDirs) {
			setFileAttribute(fileDir, rootPath, ctx);
		}		
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		// do cleanup if needed
	}
	
	private void setFileAttribute(String fileDir, String rootPath, ServletContext ctx) {
		String relativePath = ctx.getInitParameter(fileDir);
		File file = new File(rootPath + File.separator + relativePath);
		if(!file.exists()) 
			file.mkdirs();
	}
}
