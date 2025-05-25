package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;

public class UpdateUserDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter date and discount");
			
			//invoke dao's method
			System.out.println(dao.
					updateUserDetails
					(LocalDate.parse(sc.next()),sc.nextDouble()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
