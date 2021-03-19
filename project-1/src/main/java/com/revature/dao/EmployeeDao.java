package com.revature.dao;

import java.util.*;

import com.revature.models.Employee;
import com.revature.models.ReimbursementForm;

public interface EmployeeDao {
	public Employee getAccountInfo(Employee emp);
	public boolean update(Employee emp);
	public boolean submitRequestForm(ReimbursementForm form);
	public List<ReimbursementForm> getAllEmpForms(int userId);
}
