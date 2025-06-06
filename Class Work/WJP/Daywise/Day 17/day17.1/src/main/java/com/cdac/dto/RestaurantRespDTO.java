package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRespDTO extends BaseDTO{
	private String name;
	private String address;	
	private String city;
	private String description;	
}
