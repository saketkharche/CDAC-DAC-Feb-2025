package com.cdac.tester;

import static java.lang.System.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// import ALL static members fo the DBUtils class
import static com.cdac.utils.DBUtils.*;

public class TestConnection {

	public static void main(String[] args) {
		try {
			// open connection
			openConnection();
			// get connection
			Connection cn=getConnection();
			System.out.println("connected to DB ....."+cn);//imple class name
			// close
			closeConnection();
//			List<Integer> myList=new ArrayList<>();
//			System.out.println(myList.getClass());
//			myList=new LinkedList<>();
//			System.out.println(myList.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("main over..");

	}

}
