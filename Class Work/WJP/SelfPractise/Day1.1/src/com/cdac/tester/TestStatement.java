package com.cdac.tester;

import java.sql.*;
import static com.cdac.utils.DBUtils.*; // Importing static methods from DBUtils for managing DB connection

public class TestStatement {

	public static void main(String[] args) {
		try {
			// Step 1: Open database connection using DBUtils
			openConnection();
			Connection cn = getConnection(); // Get the connection instance

			// Step 2: Create a Statement object using the connection
			/*
			 * createStatement() is a method of Connection interface
			 * It returns a Statement object used to execute static SQL queries
			 */
			Statement st = cn.createStatement();

			// Step 3: Execute a SELECT query using Statement
			/*
			 * executeQuery(String sql) is used to execute SELECT statements
			 * It returns a ResultSet containing rows returned from the query
			 */
			try (ResultSet rst = st.executeQuery("select * from users")) {
				// ResultSet is like a cursor - initially positioned before the first row

				/*
				 * ResultSet method next()
				 * Moves the cursor to the next row and returns true if there is data
				 */
				/*
				 * Table columns assumed:
				 * id | first_name | last_name | email | password | dob | status | role
				 */
				while (rst.next()) {
					// Read and print data from the current row
					System.out.printf("ID %d Name %s %s Email %s "
									+ "Pwd %s Dob %s Voting Status %b Role %s %n",
							rst.getInt(1),     // id
							rst.getString(2),  // first_name
							rst.getString(3),  // last_name
							rst.getString(4),  // email
							rst.getString(5),  // password
							rst.getDate(6),    // dob
							rst.getBoolean(7), // voting status
							rst.getString(8)); // role
				}
			} // ResultSet will be automatically closed here (try-with-resources)

			// Step 4: Close DB connection
			closeConnection();
		} catch (Exception e) {
			// Print stack trace if any error occurs
			e.printStackTrace();
		}
	}
}
