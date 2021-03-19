package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	private static Logger log = Logger.getLogger(ConnectionUtil.class);

	private ConnectionUtil() {
		super();
	}
	
	public static Connection getConnection() {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			log.warn("Cannot load the driver");
			e.printStackTrace();
		}
		
		Connection connection = null;
		
		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try {
			props.load(loader.getResourceAsStream("connection.properties"));
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			
			try {
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				log.info(e.getMessage());
			}
		} catch(IOException e) {
			log.info(e.getMessage());
		}
		return connection;
	}
}
