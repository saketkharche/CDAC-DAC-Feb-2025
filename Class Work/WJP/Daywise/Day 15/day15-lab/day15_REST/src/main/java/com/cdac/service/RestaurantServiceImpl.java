package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.RestaurantDao;
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
	public List<Restaurant> findAllRestaurantsByKeyord(String keyword) {
		// TODO Auto-generated method stub
		return restaurantDao.findByDescriptionContaining(keyword);
	}

}
