package com.cdac.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem, Long> {
	boolean existsByItemNameAndMyRestaurantId(String itemName,Long id);

	@Query("select f.itemName from FoodItem f where f.myRestaurant.id=:id")
	Set<String> findAllItemNamesByRestaurantId(Long id);
	
}
