package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImp;
import com.revature.models.Employee;
import com.revature.models.ReimbursementForm;

public class EmployeeServices {

	public static EmployeeDao empDao;
	
	public EmployeeServices(){
		empDao = new EmployeeDaoImp();
	}

//	public static getRequestsByUserName(Employee employee){
//		Employee emp = null;
//		
//	}
	public static List<ReimbursementForm> getAllEmpForms(int userId){
		List<ReimbursementForm> allForms = new ArrayList<ReimbursementForm>();

		allForms = empDao.getAllEmpForms(userId);

		return allForms;
	}
	
	
}
