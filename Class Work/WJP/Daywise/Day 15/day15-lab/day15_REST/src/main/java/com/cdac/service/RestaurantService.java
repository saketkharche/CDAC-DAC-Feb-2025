package com.cdac.service;

import java.util.List;

import com.cdac.entities.Restaurant;

public interface RestaurantService {
	List<Restaurant> findAllAvailableRestaurants();

	// to do later -
	List<Restaurant> findAllRestaurantsByKeyord(String keyword);

}
