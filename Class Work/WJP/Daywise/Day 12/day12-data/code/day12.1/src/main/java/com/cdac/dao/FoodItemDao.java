package com.cdac.dao;

import java.util.List;

import com.cdac.entities.FoodItem;

public interface FoodItemDao {
	String addFoodItemToResturant(Long restaurantId, FoodItem foodItem);
	String addFoodItemsToResturant(Long restaurantId, List<FoodItem> foodItems);
	String removeFoodItem(Long restaurantId, Long foodItemId);

}
