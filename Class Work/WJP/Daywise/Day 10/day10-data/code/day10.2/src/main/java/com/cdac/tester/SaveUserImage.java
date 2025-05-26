package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.UserDao;
import com.cdac.dao.UserDaoImpl;

public class SaveUserImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); //DBCP 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			UserDao dao = new UserDaoImpl();
			System.out.println("Enter user id");
			Long userId=sc.nextLong();//auto boxing (prim -> wrapper)
			sc.nextLine();
			System.out.println("Enter image file name(path)");
			String path=sc.nextLine();
			//invoke dao's method
			System.out.println(dao.saveImage(userId,path));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
