package com.cdac.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.Restaurant;

public interface RestaurantDao extends JpaRepository<Restaurant, Long> {
	//find all available restaurants
	List<Restaurant> findByStatusTrue();
	//find all restaurants whose description contains specific keyword
	List<Restaurant> findByDescriptionContaining(String keyword);
	//exists by name
	boolean existsByName(String restaurantName);
	//custom query method - join fetch
	@Query("select r from Restaurant r left join fetch r.foodItems where r.id=:id1")
	Optional<Restaurant> fetchCompleteDetails(Long id1);
}
