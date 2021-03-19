package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.ReimbursementForm;

public interface FinancerDao {
	public List<Employee> getAllEmployyes();
	public List<ReimbursementForm> getAllReimbursements();
}
