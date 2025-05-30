package com.cdac.dao;

import com.cdac.entities.Restaurant;

public interface RestaurantDao {
	String addResturant(Restaurant newRestaurant);
	Restaurant getRestaurantDetails(String restaurantName);
	Restaurant getRestaurantWithMenuDetails(String restaurantName);
	Restaurant getOrLoadRestaurantDetails(Long restaurantId);
	String deleteResturant(String restaurantName);
}
