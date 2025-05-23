package com.cdac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class to manage database connection (open, get, close)
public class DBUtils {
	private static Connection connection; // static variable to hold single DB connection instance

	// Database connection details
	private static final String DB_URL = "jdbc:mysql://localhost:3306/adv_java"; // Database URL with DB name
	private static final String USER_NAME = "root"; // MySQL username
	private static final String PASSWORD = "cdac"; // MySQL password

	// Method to open a connection to the database
	public static void openConnection() throws ClassNotFoundException, SQLException {
		// (Optional) Load the JDBC driver class (needed in older Java versions)
		// Class.forName("com.mysql.cj.jdbc.Driver");

		/*
		 * DriverManager.getConnection() is used to establish a connection
		 * Returns a Connection object if successful
		 * We are creating a SINGLETON connection instance (lazy loading)
		 */
		if (connection == null) {
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		}
	}

	// Getter method to retrieve the existing DB connection
	public static Connection getConnection() {
		return connection;
	}

	// Method to close the DB connection
	public static void closeConnection() throws SQLException {
		// Check if connection is not null (i.e., already opened)
		if (connection != null) {
			connection.close(); // close the connection
			connection = null;  // reset to null so that it can be reopened later
		}
	}
}
