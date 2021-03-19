package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.util.RequestHelper;


public class EmpController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch(URI) {
		case "submitform":
			RequestHelper.processForm(req, resp);
			break;
		case "myReimbursements":
			RequestHelper.processEmpReimbList(req, resp);
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
