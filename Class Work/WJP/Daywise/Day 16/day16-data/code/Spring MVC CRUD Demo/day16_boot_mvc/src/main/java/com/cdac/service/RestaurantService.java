package com.cdac.service;

import java.util.List;

import com.cdac.entities.Restaurant;

public interface RestaurantService {
	List<Restaurant> getAllRestaurants();
	//get restaurant by its name
	Restaurant getRestaurantDetailsByName(String name);
	String deleteDetails(Long id);
	String addNewRestaurant(Restaurant newRestaurant);
	Restaurant getRestaurantDetailsById(Long id);
	String updateRestaurant(Long id , Restaurant restaurant);
}
