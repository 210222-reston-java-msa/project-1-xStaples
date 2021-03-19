package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.ReimbursementForm;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImp implements EmployeeDao{

	private static Logger log = Logger.getLogger(EmployeeDaoImp.class);
	@Override
	public boolean submitRequestForm(ReimbursementForm form) {
		PreparedStatement stmt = null;
		LocalDateTime createTimestamp = LocalDateTime.now();
		try {
			Connection connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
			+ "VALUES(?,?,?,?,?,?,?,?,?)";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, form.getAmount());
			stmt.setObject(2, createTimestamp);
			stmt.setObject(3, null);
			stmt.setString(4, form.getDescription());
			stmt.setObject(5, form.getReceipt());
			stmt.setInt(6, form.getAuthorId());
			stmt.setInt(7, form.getResolverId());
			stmt.setInt(8, form.getStatusId());
			stmt.setInt(9, form.getTypeId());
			
			if(!stmt.execute()) {
				return false;
			}
		} catch(SQLException e) {
			log.info(e.getMessage());
		}
		return true;
	}
	@Override
	public boolean update(Employee emp) {
		
		return false;
	}
	@Override
	public Employee getAccountInfo(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ReimbursementForm> getAllEmpForms(int userId) {
		List<ReimbursementForm> allEmpForms = new ArrayList<ReimbursementForm>();

		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_authorid = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				do{
					int id = rs.getInt("reimb_id");
					int amount = rs.getInt("reimb_amount");
					LocalDateTime submitDate = (LocalDateTime) rs.getObject("reimb_submitted");
					LocalDateTime resolveDate = (LocalDateTime) rs.getObject("reimb_resolved");
					String description = rs.getString("reimb_description");
					Object receipt = rs.getObject("reimb_receipt");
					int authorId = rs.getInt("reimb_authorId");
					int resolverId = rs.getInt("reimb_resolverId");
					int statusId = rs.getInt("reimb_status_id");
					int typeId = rs.getInt("reimb_type_id");

					ReimbursementForm form = new ReimbursementForm(id,  amount,  submitDate,  resolveDate, description, receipt, authorId,  resolverId,  statusId,  typeId);

					allEmpForms.add(form);

				}while(rs.next());
			}
		} catch (Exception e) {
			//TODO: handle exception
		}
		return allEmpForms;
	}

	

}
