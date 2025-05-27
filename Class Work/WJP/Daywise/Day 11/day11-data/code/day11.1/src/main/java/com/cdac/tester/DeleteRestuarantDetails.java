package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.RestaurantDao;
import com.cdac.dao.RestaurantDaoImpl;
import com.cdac.entities.Restaurant;
public class DeleteRestuarantDetails {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);
				SessionFactory sf=getFactory()) {
			//create dao
			RestaurantDao dao=new RestaurantDaoImpl();
			System.out.println("Enter restaurant name , to delete details");
			
			System.out.println(dao.deleteResturant(sc.next()));
		}
	}

}
