package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

public class FinanceController implements HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch(URI) {
		case "approveform":
			RequestHelper.approveForm(req, resp);
			break;
		case "pendingrequest": System.out.println("pending list");
			break;
		case "myaccount":
			break;

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
