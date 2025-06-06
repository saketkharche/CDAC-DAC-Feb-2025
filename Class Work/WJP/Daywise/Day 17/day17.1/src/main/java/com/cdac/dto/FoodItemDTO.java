package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemDTO extends BaseDTO{	
	private String itemName;	
	private String itemDescription;	
	private boolean isVeg;
	private int price;
	
}
