package com.cdac.tester;

import static java.lang.System.out; // Importing System.out to use it without prefix
import java.sql.*; // Importing all JDBC classes
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Import all static members from DBUtils class to use openConnection(), getConnection(), closeConnection() directly
import static com.cdac.utils.DBUtils.*;

public class TestConnection {

	public static void main(String[] args) {
		try {
			// Step 1: Open connection to the database using DBUtils
			openConnection();

			// Step 2: Get the current database connection object
			Connection cn = getConnection();

			// Step 3: Print confirmation that connection is established
			System.out.println("Connected to DB ..... " + cn); // Prints the connection object (shows class name)

			// Step 4: Close the database connection
			closeConnection();

			// Uncommented section below demonstrates polymorphism with List
			/*
			List<Integer> myList = new ArrayList<>();
			System.out.println(myList.getClass()); // Output: class java.util.ArrayList
			myList = new LinkedList<>();
			System.out.println(myList.getClass()); // Output: class java.util.LinkedList
			*/
		} catch (Exception e) {
			// Print stack trace if any exception occurs during DB operations
			e.printStackTrace();
		}

		// Final message indicating program has ended
		out.println("main over..");
	}
}
