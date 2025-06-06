package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {
	//find all available restaurants
	List<Restaurant> findByStatusTrue();
	//find all restaurants whose description contains specific keyword
	List<Restaurant> findByDescriptionContaining(String keyword);
	//exists by name
	boolean existsByName(String restaurantName);

}
