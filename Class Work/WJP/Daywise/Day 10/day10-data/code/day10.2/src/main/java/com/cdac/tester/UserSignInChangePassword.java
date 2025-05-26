package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;

public class UserSignInChangePassword {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter email n password");			
			//invoke dao's method
			System.out.println(dao.userSignIn(sc.next(),sc.next()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
