package com.cdac.tester;

import java.sql.*;
import java.util.Scanner;

import static com.cdac.utils.DBUtils.*;

public class TestPreparedStatement {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)) {
			String sql="select * from users where email=? and password=?";
			// open cn
			openConnection();
			Connection cn = getConnection();
			// create JDBC Preparedstatement
			/*
			 * Connection i/f method 
			 * public PreparedStatement prepareStatement(String sql) throws SQLException
			 */
			PreparedStatement pst=cn.prepareStatement(sql);
			//prompt user for email n password
			System.out.println("Enter email n password");
			//set IN parameters - email ,pwd
			/*
			 * Method of PreparedStatement
			 * public void setType(int paramPosition , Type value) throws SQLException
			 * Type - Generic SQL type | JDBC data type
			 */
			pst.setString(1, sc.next());//set email
			pst.setString(2,sc.next()); //set pwd		
			
			// execute the query n get ResultSet - selected rows n columns
			/*
			 * Method of PreparedStatement i/f
			 *  public ResultSet executeQuery() throws
			 * SQLException
			 */
			try (ResultSet rst = pst.executeQuery()) {
				// RST - cursor - before the 1st row
				/*
				 * ResultSet Method -  public boolean next() throws SQLException
				 * 
				 */
				/*
				 * id | first_name | last_name | email | password 
				 * | dob | status | role
				 */
				if (rst.next()) {
					System.out.println("Login Successful - Your Details : ");
					System.out.printf("ID %d Name %s %s Email %s "
							+ "Pwd %s Dob %s Voting Status %b Role %s %n",
							rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),
							rst.getString(5),rst.getDate(6),rst.getBoolean(7),rst.getString(8));
				}
				else 
					System.out.println("Invalid email or password !!!!!");
			} //JVM - rst.close();
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
