package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entities.User;
import com.cdac.entities.UserRole;

public class UserRegistration {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user details - firstName,  lastName,  " + "email,  password,  dob,  userRole");
			// create user instance
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					UserRole.valueOf(sc.next().toUpperCase()));
			//invoke dao's method
			System.out.println(dao.signUp(user));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
