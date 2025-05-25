package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entities.User;
import com.cdac.entities.UserRole;

public class GetUserDetailsById {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user id");
			Long userId=sc.nextLong();//auto boxing (prim -> wrapper)
			//invoke dao's method
			System.out.println(dao.getUserDetails(userId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
