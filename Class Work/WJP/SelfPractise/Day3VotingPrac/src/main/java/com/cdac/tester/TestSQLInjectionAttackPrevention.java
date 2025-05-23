package com.cdac.tester;

import static com.cdac.utils.DBUtils.*;

import java.sql.*;
import java.util.Scanner;

public class TestSQLInjectionAttackPrevention {

	public static void main(String[] args) {
		System.out.println("Enter User id");
		try (Scanner sc = new Scanner(System.in)) {
			openConnection();
			Connection cn = getConnection();
		// create JDBC PreparedStatement from connection
				PreparedStatement pst = 
						cn.prepareStatement("select * from users where id=?"); 

			String id = sc.nextLine();
			// set IN params
			pst.setInt(1, Integer.parseInt(id));
			ResultSet rst = pst.executeQuery();
			System.out.println("User Details - ");
			while (rst.next()) {
				System.out.printf("ID %d Name %s %s Email %s" + "Pwd %s Dob %s Status %b Role %s %n", rst.getInt(1),
						rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
			}
			rst.close();
			pst.close();
			closeConnection();

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
