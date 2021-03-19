package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.*;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.ReimbursementForm;
import com.revature.services.EmployeeServices;
import com.revature.services.UserServices;

public class RequestHelper {
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// We want to turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		

		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		log.info(body + "RH");

		

		Employee loginAttempt = om.readValue(body, Employee.class); // from JSON --> Java Object

		
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();	
		
		log.info("User attempted to login with username: " + username);
		Employee e = UserServices.confirmLogin(username, password);
			
		if (e != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			// Attaching the print writer to our response
			PrintWriter pw = resp.getWriter();
			resp.setContentType("application/json");
			
			// this is converting our Java Object (with property firstName!) 
			// to JSON format....that means we can grab the firstName property
			// after we parse it. (We parse it in JavaScript)
			pw.println(om.writeValueAsString(e));

			
			log.info(username + " has successfully logged in");	
		} else {
			resp.setStatus(204); // this means that we still have a connection, but no user is found
		}
	}

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false); 
		
		
		log.info("Processing logout");
		
		
		if (session != null) {
			
			String username = (String) session.getAttribute("username");
			log.info( username + " has logged out");
							
			session.invalidate();
		}
		
		res.setStatus(200);
	
	}

	public static void processEmpReimbList(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		String line = reader.readLine();
		

		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		log.info(body + "employeeList");
		
		
		Employee reimbOwner = om.readValue(body, Employee.class);

		resp.setContentType("application/json");
		List<ReimbursementForm> empReimbursements = EmployeeServices.getAllEmpForms(reimbOwner.getId());
		log.info(empReimbursements);
		String jsonList = om.writeValueAsString(empReimbursements);
		PrintWriter pw = resp.getWriter();
		pw.println(jsonList);
		log.info(jsonList);
	}
	
	public static void processForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// We want to turn whatever we receive as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();

		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		

		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		log.info(body);


		ReimbursementForm tempForm = om.readValue(body, ReimbursementForm.class); // from JSON --> Java Object
		
		int formAmount = tempForm.getAmount();
		LocalDateTime creationDate = tempForm.getSubmitTime();
		LocalDateTime resolveTime = tempForm.getResolveTime();
		String formDescription = tempForm.getDescription();
		Object receipt = tempForm.getReceipt();
		int authorId = tempForm.getAuthorId();
		int resolverId = tempForm.getResolverId();
		int statusId = tempForm.getStatusId();
		int typeId = tempForm.getTypeId();
		
		log.info("User attempted to submit form");
		ReimbursementForm form = new ReimbursementForm(formAmount, creationDate, resolveTime,  formDescription, receipt, authorId, resolverId, statusId, typeId);
			
		if (form != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("newForm", form);
			
			// Attaching the print writer to our response
			PrintWriter pw = resp.getWriter();
			resp.setContentType("application/json");
			
			// this is converting our Java Object (with property firstName!) 
			// to JSON format....that means we can grab the firstName property
			// after we parse it. (We parse it in JavaScript)
			pw.println(om.writeValueAsString(form));

			
			
		} 
	}
}
