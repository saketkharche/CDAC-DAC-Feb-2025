package com.cdac.service;

import java.util.List;

import com.cdac.dto.AddRestaurantDTO;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.RestaurantMenuDTO;
import com.cdac.dto.RestaurantRespDTO;
import com.cdac.entities.Restaurant;

public interface RestaurantService {
	List<RestaurantRespDTO> findAllAvailableRestaurants();

	// to do later -
	List<Restaurant> findAllRestaurantsByKeyord(String keyword);

	RestaurantRespDTO addRestaurant(AddRestaurantDTO requestDTO);

	String deleteDetails(Long restaurantId);

	RestaurantRespDTO getRestaurantDetails(Long id);

	ApiResponse updateDetails(Long restaurantId, Restaurant restaurant);

	RestaurantMenuDTO getRestaurantWithMenu(Long restaurantId);

}
