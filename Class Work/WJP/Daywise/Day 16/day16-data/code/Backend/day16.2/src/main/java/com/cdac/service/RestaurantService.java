package com.cdac.service;

import java.util.List;

import com.cdac.dto.ApiResponse;
import com.cdac.entities.Restaurant;

public interface RestaurantService {
	List<Restaurant> findAllAvailableRestaurants();

	// to do later -
	List<Restaurant> findAllRestaurantsByKeyord(String keyword);

	String addRestaurant(Restaurant restaurant);

	String deleteDetails(Long restaurantId);

	Restaurant getRestaurantDetails(Long id);

	ApiResponse updateDetails(Long restaurantId, Restaurant restaurant);

}
