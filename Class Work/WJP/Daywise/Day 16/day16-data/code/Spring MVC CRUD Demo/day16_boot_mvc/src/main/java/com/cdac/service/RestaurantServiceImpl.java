package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;

@Service // to declare a spring bean containing B.L
@Transactional // to auto manage txs (TransactioManager bean - spring supplied)
public class RestaurantServiceImpl implements RestaurantService {
	// depcy - dao layer i.f
	@Autowired // byType , field level D.I
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> getAllRestaurants() {

		return restaurantDao.findByStatusTrue();
	}

	@Override
	public Restaurant getRestaurantDetailsByName(String name) {
		// invoke dao's method n handle Optional
		return restaurantDao.findByName(name) // Optional<Restaurant>
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Restaurant name - not found !!!"));
	}

	@Override
	public String deleteDetails(Long id) {
		// soft delete operation
		// 1. get restaurant details
		Restaurant restaurant = restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restaurant id !!!!"));
		// => restaurant : PERSISTENT
		// 2. simply call setter - to modify the state
		restaurant.setStatus(false);
		return "status updated : soft delete";
	}
	/*
	 * When @Transactional method rets - Tx mgr (spring supplied) bean - commits tx
	 * - in case of no RuntimeExc - session.flush -> auto dirty checking -> DML -
	 * update - session.close() - l1 cache is destroyed n db cn rets to spring boot
	 * chosen - Hikari DBCP
	 */

	@Override
	public String addNewRestaurant(Restaurant newRestaurant) {
		// set status - true
		newRestaurant.setStatus(true);
		Restaurant persistentEntity = restaurantDao.save(newRestaurant);
		System.out.println("new rest added with id " + persistentEntity.getId());
		return "Added new restaurant with id " + persistentEntity.getId();
	}

	@Override
	public Restaurant getRestaurantDetailsById(Long id) {

		return restaurantDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Id , Restaurant not found!!!"));
	}

	@Override
	public String updateRestaurant(Long id, Restaurant restaurant) {
		Restaurant existingRestaurant = getRestaurantDetailsById(id);
		// => existingRestaurant : persistent
		// restaurant - contains new state
		// invoke setters
		existingRestaurant.setAddress(restaurant.getAddress());
		existingRestaurant.setName(restaurant.getName());
		existingRestaurant.setCity(restaurant.getCity());
		existingRestaurant.setDescription(restaurant.getDescription());
		return "restaurant details updated ...";
	}

}
