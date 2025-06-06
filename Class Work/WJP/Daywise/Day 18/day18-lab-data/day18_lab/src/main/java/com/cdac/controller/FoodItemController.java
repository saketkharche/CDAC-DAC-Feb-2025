package com.cdac.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.ApiResponse;
import com.cdac.dto.FoodItemDTO;
import com.cdac.service.FoodItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController // @Controller + @RespBody
@RequestMapping("/food_items")
public class FoodItemController {
	// depcy
	@Autowired
	private FoodItemService foodItemService;

	public FoodItemController() {
		System.out.println("in ctor " + getClass());
	}
	
	/*
	 *
	 * Desc -Add new food Item to the Restaurant
	 * URL - http://host:port/food_items/restaurants/{restaurantId}
	 * Method - POST
	 * Payload - req body - food item details (FoodItemDTO)
	 * Resp -  success - SC 201 , ApiResp - success mesg
	 *   Error - invalid restaurant id | dup food item ... ApiResp - err mesg
	 * 
	 */
	@PostMapping("/restaurants/{restaurantId}")
	@Operation(description = "Add new food Item to the Restaurant")
	public ResponseEntity<?> addFoodItemToRestaurant(
			@PathVariable Long restaurantId,@RequestBody FoodItemDTO dto) {
		System.out.println("in add food item "+restaurantId+" "+dto);
		try {
			//invoke service layer method
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(foodItemService.addFoodItem(restaurantId,dto));
			
		} catch (RuntimeException e) {
			System.out.println("err in controller "+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
			
		}
	}
	
	/*
	 *
	 * Desc -Add new multiple food Items to the Restaurant
	 * URL - http://host:port/food_items/restaurants/{restaurantId}
	 * Method - POST
	 * Payload - req body - food item details (FoodItemDTO)
	 * Resp -  success - SC 201 , ApiResp - success mesg
	 *   Error - invalid restaurant id | dup food item ... ApiResp - err mesg
	 * 
	 */
	@PostMapping("/multiple/restaurants/{restaurantId}")
	@Operation(description = "Add new multiple  food Items to the Restaurant")
	public ResponseEntity<?> addMultipleFoodItemsToRestaurant(
			@PathVariable Long restaurantId,
			@RequestBody Set<FoodItemDTO> dtos) {
		System.out.println("in add food item "+restaurantId+" "+dtos);
		try {
			//invoke service layer method
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(foodItemService.addFoodItems(restaurantId,dtos));
			
		} catch (RuntimeException e) {
			System.out.println("err in controller "+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
			
		}
	}


}
