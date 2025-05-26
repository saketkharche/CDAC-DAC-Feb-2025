package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entities.UserRole;

public class DisplayUserFirstNamesByRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter role");			
			//invoke dao's method
			System.out.println("Selected User first names - ");
			dao.getSelectedUsersFirstNames(
					UserRole.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);//name -> sop(name)
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
