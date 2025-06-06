package com.cdac.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantMenuDTO extends BaseDTO {
//restaurant details + list of food items
	private String name;
	private String address;	
	private String city;
	private String description;	
	private List<FoodItemDTO> foodItems;
}
