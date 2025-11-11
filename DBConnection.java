package com.employeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL="jdbc:mysql://localhost:3306/may5";
	private static final String USER="root";
	private static final String PASSWORD="Lakshmi2004@";
	
	
	public static Connection getConnection() {
		try {
			return 
					DriverManager.getConnection(URL,USER,PASSWORD);
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
