package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.RestaurantDao;
import com.cdac.dao.RestaurantDaoImpl;
import com.cdac.entities.Restaurant;
import static com.cdac.utils.HibernateUtils.getFactory;

public class GetRestaurantDetailsByName {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
			// create Restaurant dao instance
			RestaurantDao dao = new RestaurantDaoImpl();
			System.out.println("Enter Restaurant name");
			Restaurant restaurant = dao.getRestaurantDetails(sc.nextLine());
			System.out.println("Restaurant details ");
			System.out.println(restaurant);
			
		
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
