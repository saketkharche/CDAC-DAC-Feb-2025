package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;

public class RestoreUserImagefromDB {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user email");
			String email=sc.next();
			sc.nextLine();//to read off CR/LF
			System.out.println("Enter image file name(path) to store the img data");
			String path=sc.nextLine();
			//invoke dao's method
			System.out.println(dao.restoreImage(email,path));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
