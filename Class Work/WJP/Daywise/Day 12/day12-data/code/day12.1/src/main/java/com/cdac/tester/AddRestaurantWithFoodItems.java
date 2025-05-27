package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.FoodItemDao;
import com.cdac.dao.FoodItemDaoImpl;
import com.cdac.dao.RestaurantDao;
import com.cdac.dao.RestaurantDaoImpl;
import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

public class AddRestaurantWithFoodItems {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			// create dao
			RestaurantDao dao=new RestaurantDaoImpl();
			System.out.println("Enter restaurant details - name address city desc ");
			Restaurant restaurant=new Restaurant(sc.next(), 
					sc.next(), sc.next(), sc.next());
		
		
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter food itemName, itemDescription,  isVeg,  price");
				FoodItem foodItem = new FoodItem(sc.next(), sc.next(), sc.nextBoolean(), sc.nextInt());
				restaurant.addFoodItem(foodItem);
			}
			System.out.println(dao.addResturant(restaurant));
		}
	}

}
