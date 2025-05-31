package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

@RestController
/*
 * = @Controller added implicitly at the class level
 * + 
 * @ResponseBody - added implicitly on ret type of all req handling methods
 *  =meant for serialization : Java -> JSON | XML
 */
@RequestMapping("/restaurants") //resource name
public class RestaurantController {
	//depcy - service layer i/f
	@Autowired
	private RestaurantService restaurantService;
	
	public RestaurantController() {
		System.out.println("in ctor of "+getClass());
	}
	/*
	 * Add REST API end point
	 * URL - http://host:port/restaurants
	 * Method - GET
	 * Payload - none
	 * Resp -  (List<Restaurant>) -> JSON Array
	 */
	@GetMapping
	public /*@ResponseBody*/ List<Restaurant> getAvailableRestaurants() {
		System.out.println("in get available");
		return restaurantService.findAllAvailableRestaurants();
	}

}
