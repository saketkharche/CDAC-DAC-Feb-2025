package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.FoodItemDao;
import com.cdac.dao.FoodItemDaoImpl;
import com.cdac.entities.FoodItem;

public class AddMultipleFoodItemsToRestaurant {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			// create dao
			FoodItemDao dao = new FoodItemDaoImpl();
			System.out.println("Enter restaurant id ");
			Long restaurantId = sc.nextLong();
			List<FoodItem> items = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				System.out.println("Enter food itemName, itemDescription,  isVeg,  price");
				FoodItem foodItem = new FoodItem(sc.next(), sc.next(), sc.nextBoolean(), sc.nextInt());
				items.add(foodItem);
			}
			System.out.println(dao.addFoodItemsToResturant(restaurantId, items));
		}
	}

}
