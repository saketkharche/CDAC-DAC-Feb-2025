package com.cdac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	// This static connection will act as a SINGLETON instance
	private static Connection connection;

	// Database URL -> using MySQL at localhost with database named 'adv_java'
	private static final String DB_URL = "jdbc:mysql://localhost:3306/adv_java";
	
	// MySQL login credentials
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "cdac";

	// Method to open a DB connection (called before any DB operation)
	public static void openConnection() throws SQLException {
		/*
		 * DriverManager.getConnection() is used to establish a connection
		 * It returns an object of Connection interface
		 */
		
		// Open connection only if it hasn't been opened already (lazy initialization)
		if (connection == null) {
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("db connection opened....");
		}
	}

	// Getter method to access the existing connection
	public static Connection getConnection() {
		return connection;
	}

	// Method to close the database connection and release resources
	public static void closeConnection() throws SQLException {
		// If connection is active, close it and set the reference to null
		if (connection != null) {
			connection.close();
			connection = null;
			System.out.println("db cn closed");
		}
	}
}
