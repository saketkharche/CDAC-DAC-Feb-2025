package com.cdac.tester;

import java.sql.*;
import java.util.Scanner;

import static com.cdac.utils.DBUtils.*; // Import static methods from DBUtils for DB connection handling

public class TestPreparedStatement {

	public static void main(String[] args) {
		// Try-with-resources to auto-close Scanner
		try (Scanner sc = new Scanner(System.in)) {

			// SQL query with placeholders (?) for parameters
			String sql = "select * from users where email=? and password=?";

			// Step 1: Open DB connection using our utility method
			openConnection();
			Connection cn = getConnection(); // Get the connection instance

			// Step 2: Create a PreparedStatement object using the SQL query
			/*
			 * prepareStatement() is a method of Connection interface
			 * It returns a PreparedStatement object for executing parameterized SQL
			 */
			PreparedStatement pst = cn.prepareStatement(sql);

			// Step 3: Prompt user to enter email and password
			System.out.println("Enter email and password");

			// Step 4: Set input (IN) parameters in PreparedStatement
			// These replace the ? placeholders in the SQL query
			pst.setString(1, sc.next()); // Set 1st ? with email
			pst.setString(2, sc.next()); // Set 2nd ? with password

			// Step 5: Execute the query and store result in ResultSet
			// executeQuery() is used for SELECT queries, returns a ResultSet object
			try (ResultSet rst = pst.executeQuery()) {
				// Step 6: Use ResultSet to read data row by row
				// Initially, the cursor is before the first row
				if (rst.next()) {
					// If a record is found, extract and print the details
					System.out.println("Login Successful - Your Details : ");
					System.out.printf(
							"ID %d Name %s %s Email %s "
									+ "Pwd %s Dob %s Voting Status %b Role %s %n",
							rst.getInt(1),     // id
							rst.getString(2),  // first_name
							rst.getString(3),  // last_name
							rst.getString(4),  // email
							rst.getString(5),  // password
							rst.getDate(6),    // dob
							rst.getBoolean(7), // voting status
							rst.getString(8)); // role
				} else {
					// If no matching record is found
					System.out.println("Invalid email or password !!!!!");
				}
			} // rst.close() is automatically called by JVM here due to try-with-resources

			// Step 7: Close DB connection
			closeConnection();
		} catch (Exception e) {
			// Handle any exception that occurs during DB operations
			e.printStackTrace();
		}
	}
}
