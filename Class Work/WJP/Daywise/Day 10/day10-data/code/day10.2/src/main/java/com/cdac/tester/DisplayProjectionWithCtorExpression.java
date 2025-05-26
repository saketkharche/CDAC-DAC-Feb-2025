package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entities.UserRole;

public class DisplayProjectionWithCtorExpression {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); // DBCP
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter role");
			// invoke dao's method
			System.out.println("Selected Projection - ");
			dao.getSelectedUsersDetails(UserRole.valueOf(sc.next().toUpperCase()))
					.forEach(u -> System.out.println(u.getFirstName() + " " + u.getLastName() + " " + u.getDob()));// u
																													// ->
																													// sop(u.getFn
																													// ,
																													// u.getln,
																													// u.getdob)
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
