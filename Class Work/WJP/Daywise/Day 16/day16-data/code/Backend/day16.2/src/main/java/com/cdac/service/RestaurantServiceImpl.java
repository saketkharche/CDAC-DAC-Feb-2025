package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
import com.cdac.entities.Restaurant;

@Service
@Transactional // import from o.s
public class RestaurantServiceImpl implements RestaurantService {
	// depcy - dao layer i/f
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> findAllAvailableRestaurants() {
		// TODO Auto-generated method stub
		return restaurantDao.findByStatusTrue();
	}

	@Override
	public String addRestaurant(Restaurant restaurant) {
		// first validate if restaurant with the same name exists ?
		if (restaurantDao.existsByName(restaurant.getName()))
			throw new ApiException("Dup restaurant name !!!!!");
		// enable status - true
		restaurant.setStatus(true);
		// invoke dao's method
		Restaurant restaurant2 = restaurantDao.save(restaurant);
		// restaurant2 : PERSISTENT
		return "Added new restaurant with generated ID " + restaurant2.getId();
	}

	@Override
	public List<Restaurant> findAllRestaurantsByKeyord(String keyword) {
		// TODO Auto-generated method stub
		return restaurantDao.findByDescriptionContaining(keyword);
	}

	@Override
	public String deleteDetails(Long restaurantId) {
		if (restaurantDao.existsById(restaurantId)) {
			restaurantDao.deleteById(restaurantId);
			return "Deleted restaurant details...";
		}
		throw new 
		ResourceNotFoundException("Invalid restaurant id - Deletion Failed!!!!!");
	}

	@Override
	public Restaurant getRestaurantDetails(Long id) {
		// get details
		return restaurantDao.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException
				("Invalid restaurant id !!!!!"));
	}

	@Override
	public ApiResponse updateDetails(Long restaurantId, 
			Restaurant restaurant) {
		//validate
		if(restaurantDao.existsById(restaurantId)) {
			Restaurant restaurant2 = restaurantDao.save(restaurant);
			return new ApiResponse("Updated restaurant details ....");
		}
		throw new ResourceNotFoundException
		("Invalid restaurant id !!!!!");
	}//DML - update
	
	
	

}
