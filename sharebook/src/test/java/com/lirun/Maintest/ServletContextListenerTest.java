package com.lirun.Maintest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
			System.out.println("-------enter servletContextListener test class");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
