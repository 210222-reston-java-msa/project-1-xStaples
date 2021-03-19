package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;



import com.revature.util.RequestHelper;

public class FrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch(URI) {
		case "login": 
			RequestHelper.processLogin(req, resp);
			break;
		case "logout": 
			RequestHelper.processLogout(req, resp);
			break;

		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
