package com.revature.services;

import java.sql.*;


import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class UserServices {
	public static Logger log = Logger.getLogger(UserServices.class);
	public static Employee confirmLogin(String username, String password){
		Employee profile = null;
		Employee loginInfo = new Employee(username, password);
		
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM ers_users eu WHERE eu.username = ? AND eu.password = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, loginInfo.getUsername());
			stmt.setString(2, loginInfo.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				int id = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				String email = rs.getString("email");
				int userRole = rs.getInt("role_id");

				profile = new Employee(id, firstName, lastName, userName, passWord, email, userRole);
			}
		} catch (SQLException e) {
			log.warn("Username or Password is Incorrect" + e);
		}
		
		return profile;

	}

	
}
