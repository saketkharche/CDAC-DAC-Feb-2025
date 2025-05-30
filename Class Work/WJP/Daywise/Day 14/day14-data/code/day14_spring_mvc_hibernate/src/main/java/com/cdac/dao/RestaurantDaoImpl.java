package com.cdac.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Restaurant;

@Repository //to declare a spring bean - containing Data access logic
//singleton n eager
public class RestaurantDaoImpl implements RestaurantDao {
	//depcy - SessionFactory
	@Autowired // byType
	private SessionFactory factory;

	@Override
	public List<Restaurant> getAllRestaurants() {
		String jpql="select r from Restaurant r";		
		return factory.getCurrentSession()
				.createQuery(jpql, Restaurant.class)
				.getResultList();
	}

}
