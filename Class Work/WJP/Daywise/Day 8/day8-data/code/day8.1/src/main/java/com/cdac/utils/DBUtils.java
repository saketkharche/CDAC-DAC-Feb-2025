package com.cdac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection connection;

	// open connection - to open DB connection
	public static void openConnection(String dbURL,
			String userName,String password) throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(
					dbURL,userName,password);
			System.out.println("db connection opened....");
		}
		
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
			System.out.println("db cn closed");
		}
	}

}
