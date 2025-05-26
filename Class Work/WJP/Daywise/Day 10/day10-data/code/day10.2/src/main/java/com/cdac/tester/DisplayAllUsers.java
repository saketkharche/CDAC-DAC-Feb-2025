package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entities.User;

public class DisplayAllUsers {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); // DBCP
		) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			
			// invoke dao's method
			System.out.println("All Users - ");
			dao.getAllUsers().forEach(u -> System.out.println(u));//System.out::println
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
