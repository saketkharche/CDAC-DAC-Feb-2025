//package com.cdac.tester;
//
//import static com.cdac.utils.HibernateUtils.getFactory;
//
//import java.util.Scanner;
//
//import org.hibernate.SessionFactory;
//
//import com.cdac.dao.UserDao;
//import com.cdac.dao.UserDaoImpl;
//
//public class GetUserNamesByCity {
//
//	public static void main(String[] args) {
//		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
//			// create user dao instance
//			UserDao userDao = new UserDaoImpl();
//			System.out.println("Enter city name to search users");
//			userDao.getUserNamesByCity(sc.next())
//					.forEach(u -> System.out.println(u.getFirstName() + " " + u.getLastName()));
//		} // JVM sf.close() => cleaning up of DBCP
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}
