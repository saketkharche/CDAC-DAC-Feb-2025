package com.cdac.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of="itemName",callSuper = false)
public class FoodItemDTO extends BaseDTO{	
	private String itemName;	
	private String itemDescription;	
	private boolean isVeg;
	private int price;
	
}
