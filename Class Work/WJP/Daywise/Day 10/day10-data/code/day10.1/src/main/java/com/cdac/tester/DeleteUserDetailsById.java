package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;

public class DeleteUserDetailsById {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user id to delete user details");
			Long userId=sc.nextLong();//auto boxing (prim -> wrapper)
			//invoke dao's method
			System.out.println(dao.deleteUserDetails(userId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
