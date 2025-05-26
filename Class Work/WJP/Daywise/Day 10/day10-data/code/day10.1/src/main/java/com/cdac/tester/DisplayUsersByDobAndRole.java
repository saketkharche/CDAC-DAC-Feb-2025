package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;
import com.cdac.entities.UserRole;

public class DisplayUsersByDobAndRole {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter begin date , end date role");			
			//invoke dao's method
			System.out.println("Selected Users - ");
			dao.getSelectedUsers(LocalDate.parse(sc.next()),
					LocalDate.parse(sc.next()),
					UserRole.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);//u -> sop(u)
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
