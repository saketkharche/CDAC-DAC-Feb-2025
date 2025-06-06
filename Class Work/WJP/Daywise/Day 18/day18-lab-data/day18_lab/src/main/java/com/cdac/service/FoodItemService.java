package com.cdac.service;

import java.util.Set;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.FoodItemDTO;

public interface FoodItemService {

	ApiResponse addFoodItem(Long restaurantId, FoodItemDTO dto);

	ApiResponse addFoodItems(Long restaurantId, Set<FoodItemDTO> dtos);

}
