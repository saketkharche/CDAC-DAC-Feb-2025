package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.FoodItemDao;
import com.cdac.dao.FoodItemDaoImpl;

public class RemoveFoodItemFromRestaurant {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc=new Scanner(System.in)) {
			FoodItemDao dao=new FoodItemDaoImpl();
			System.out.println("Enter restaurant id n food item id");			
			System.out.println(dao.
					removeFoodItem(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
