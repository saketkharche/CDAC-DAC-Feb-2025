package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;

@Service //to declare a spring bean containing B.L
@Transactional //to auto manage txs  (TransactioManager bean - spring supplied)
public class RestaurantServiceImpl implements RestaurantService {
	//depcy - dao layer i.f
	@Autowired
	private RestaurantDao restaurantDao;
	@Override
	public List<Restaurant> getAllRestaurants() {
		// B.L will be added here ....later
		return restaurantDao.getAllRestaurants();
	}

}
