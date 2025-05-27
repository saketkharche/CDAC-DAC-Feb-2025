package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.RestaurantDao;
import com.cdac.dao.RestaurantDaoImpl;
import com.cdac.entities.Restaurant;
public class AddNewRestaurant {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			//create dao
			RestaurantDao dao=new RestaurantDaoImpl();
			System.out.println("Enter restaurant details -"
					+ " name,  address,  city,  description");
			Restaurant restaurant=new Restaurant(sc.next(), 
					sc.next(), sc.next(), sc.next());// restaurant - transient
			System.out.println(dao.addResturant(restaurant));
		}
	}

}
