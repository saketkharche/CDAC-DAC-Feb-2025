package com.cdac.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.entities.Restaurant;

import jakarta.persistence.EntityManager;

@Repository //to declare a spring bean - containing Data access logic
//singleton n eager
public class RestaurantDaoImpl implements RestaurantDao {
	/*depcy - jakarata.persistence.EntityManager
	 * EntityManager - super i/f of Session
	 */
	@Autowired // byType OR @PersistenceContext - JPA annotation
	private EntityManager manager;

	@Override
	public List<Restaurant> getAllRestaurants() {
		String jpql="select r from Restaurant r";		
		return manager //HibernateExc - curnt session can't be configured!!!!!
				.createQuery(jpql, Restaurant.class)
				.getResultList();
	}

}
