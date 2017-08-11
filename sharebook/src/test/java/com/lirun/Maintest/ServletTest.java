package com.lirun.Maintest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doget(HttpServletRequest request,HttpServletResponse response){
		ServletContext servletContext = getServletContext();
	}

}
