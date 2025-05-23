package com.cdac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/adv_java";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";

	// open connection - to open DB connection
	public static void openConnection() throws ClassNotFoundException, SQLException {
		// 1. In earlier versions -mandatory to load JDBC driver - (currently optional
		// step )
	//	Class.forName("com.mysql.cj.jdbc.Driver");// fully qualified JDBC driver class name
		// 2. Get fixed DB connection from DriverManager
		/*
		 * java.sql.DriverManager -class Method - public static Connection
		 * getConnection(String url,String userName, String password) throws
		 * SQLException
		 */
		// achieve SINGLETON instance of the DB connection (LAZY)
		if (connection == null)
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

	}
	// getter for connection

	public static Connection getConnection() {
		return connection;
	}

	// close connection
	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}

}
