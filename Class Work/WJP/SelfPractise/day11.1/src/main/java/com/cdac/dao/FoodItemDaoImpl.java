package com.cdac.dao;

import static com.cdac.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

public class FoodItemDaoImpl implements FoodItemDao {

	@Override
	public String addFoodItemToResturant(Long restaurantId, FoodItem foodItem) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// 3 . get Restaurant from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			if (restaurant != null) {
				// restaurant - persistent
				// establish Restaurant 1<----> * FoodItem
				restaurant.addFoodItem(foodItem);
				session.persist(foodItem);
				mesg = "added food item to the restaurant !";
			}

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String addFoodItemsToResturant(Long restaurantId, 
			List<FoodItem> foodItems) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// 3. Get Restaurant from its id
			Restaurant restaurant = session.get(Restaurant.class, restaurantId);
			if (restaurant != null) {
				// restaurant - persistent - 
				// establish Restaurant 1<----> * FoodItem
				foodItems.forEach(foodItem -> {
					restaurant.addFoodItem(foodItem);//bi dir asso
					//modifying the state of the persistent entity
			//		session.persist(foodItem); //implicitly - persist (due to cascading)
				});
				mesg="added multiple food items to the restaurant";
			}
			tx.commit();//session.flush -> state of restaurant is updated 
			// -> chks cascade type : ALL -> food items - no rec in db
			// to sync up the state - auto fires - insert query + assigns FK
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public String removeFoodItem(Long restaurantId, Long foodItemId) {
		String mesg = "failed !!!!!!!!!";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			//3. Get restaurant details from its id
			Restaurant restaurant= session.get(Restaurant.class, restaurantId);
			//4. Get food item from its id
			FoodItem foodItem =session.get(FoodItem.class, foodItemId);
			//5 . validate if restaurant exists , food item exists n restaurant
			//matches with the food items
			if(restaurant != null 
			&& foodItem != null 
			&& foodItem.getMyRestaurant().getId()== restaurantId) {
				//all valid i/ps
				restaurant.removeFoodItem(foodItem);
				mesg="deleted food item from the restaurant";
			}
			tx.commit();// DML delete - food_item
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return mesg;
	}

}
