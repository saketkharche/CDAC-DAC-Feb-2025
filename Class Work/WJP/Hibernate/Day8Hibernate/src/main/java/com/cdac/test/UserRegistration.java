package com.cdac.test;

import static com.cdac.utils.Hibernateutils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entites.User;
import com.cdac.entites.UserRole;

public class UserRegistration {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter User Details--> userId, firstName, lastName, email, password, dob,userRole");
			System.out.println("Hibernate up n running!");
			// create user instance
			User user = new User(null, sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					UserRole.valueOf(sc.next().toUpperCase()));
			System.out.println(dao.signup(user));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
