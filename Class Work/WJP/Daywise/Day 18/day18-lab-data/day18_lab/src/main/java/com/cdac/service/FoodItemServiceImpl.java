package com.cdac.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.FoodItemDao;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
import com.cdac.dto.FoodItemDTO;
import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

@Service
@Transactional
public class FoodItemServiceImpl implements FoodItemService {
	// depcy - dao layer i.f
	@Autowired
	private FoodItemDao foodItemDao;
	// restaurant dao
	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse addFoodItem(Long restaurantId, FoodItemDTO dto) {
		// 1. get restaurant from its id
		Restaurant restaurantEntity = restaurantDao.findById(restaurantId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Invalid restaurant id !!!!!"));
		// 2. food item name - dup chking
		if (foodItemDao.existsByItemNameAndMyRestaurantId(dto.getItemName(), restaurantId))
			throw new ApiException("Dup food item name in the same restaurant !!!!!");
		// => restaurant : persistent , food item name - distinct
		// 3 . Map food item dto -> entity
		FoodItem foodItemEntity = modelMapper.map(dto, FoodItem.class);
		// 4 . IMPORTANT - establish a bi dir asso between entities
		restaurantEntity.addFoodItem(foodItemEntity);// modifying state of persistent entity
	
		return new ApiResponse("Added new food item ....");
	}// tx .commit -> session.flush -> dirty chking , DML - insert : food_items

	@Override
	public ApiResponse addFoodItems(Long restaurantId, Set<FoodItemDTO> dtos) {
		List<String> dupItemNames = new ArrayList<>();
		// 1. get restaurant from its id
		Restaurant restaurantEntity = restaurantDao.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid restaurant id !!!!!"));
		// 2. food item name - dup chking
		dtos.stream().filter(dto -> {
			boolean exists = foodItemDao.existsByItemNameAndMyRestaurantId(dto.getItemName(), restaurantId);
			if (exists)
				dupItemNames.add(dto.getItemName());
			return !exists;
		}).forEach(dto -> {
			FoodItem entity = modelMapper.map(dto, FoodItem.class);
			restaurantEntity.addFoodItem(entity);
		});
		if (dupItemNames.isEmpty())
			return new ApiResponse("Added all new non dup food item ....");
		return new ApiResponse("These items with dup names are not added  - " + dupItemNames);
	}

}
