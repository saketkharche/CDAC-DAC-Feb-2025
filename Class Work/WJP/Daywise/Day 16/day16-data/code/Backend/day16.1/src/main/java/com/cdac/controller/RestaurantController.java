package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Day15RestApplication;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.ApiResponse;
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

    private final RestaurantDao restaurantDao;
	//depcy - service layer i/f
	@Autowired
	private RestaurantService restaurantService;
	
	public RestaurantController(RestaurantDao restaurantDao, Day15RestApplication day15RestApplication) {
		System.out.println("in ctor of "+getClass());
		this.restaurantDao = restaurantDao;		
	}
	/*
	 * Add REST API end point
	 * Desc - Get all restaurants
	 * URL - http://host:port/restaurants
	 * Method - GET
	 * Payload - none
	 * Resp -  success(available restaurants - SC 200 , (List<Restaurant>) -> JSON Array
	 * no restaurants  -only  SC 204 
	 * 
	 */
	@GetMapping
	public ResponseEntity<?> getAvailableRestaurants() {
		System.out.println("in get available");
		List<Restaurant> restaurants = restaurantService.findAllAvailableRestaurants();
		if(restaurants.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(restaurants);
	}
	/*
	 * RestController rets -> @ResponseBody List -> D.S 
	 * Jackson - serialization -> Json[] -> sent to the REST clnt
	 */
	
	/*
	 * Add new REST API end point
	 * Desc - Add new restaurant
	 * URL - http://host:port/restaurants
	 * Method - POST
	 * Payload - JSON representation of resource (Restaurant)
	 * Resp -  String mesg - success SC OK
	 *  | failure - SC CONFLICT + err mesg
	 */
	@PostMapping
	public ResponseEntity<?> addNewRestaurant(
			@RequestBody Restaurant restaurant) {
		System.out.println("in add "+restaurant);//transient entity 
		try {
		//invoke service method
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(restaurantService.addRestaurant(restaurant));
		} catch (RuntimeException e) {
			System.out.println("err in controller "+e);
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(e.getMessage());
			
		}
	}
	
	/*
	 * Add new REST API end point
	 * Desc - Hard delete a restaurant
	 * URL - http://host:port/restaurants/{restaurantId}
	 * Method - DELETE
	 * Payload - none
	 * Resp -  String mesg - success | failure
	 */
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<?> deleteRestaurantDetails(
			@PathVariable Long restaurantId)
	{
		System.out.println("in delete "+restaurantId);
		try {
		//invoke service layer's method
		return ResponseEntity.ok(
				restaurantService.deleteDetails(restaurantId));
		} catch (RuntimeException e) {
			System.out.println("err "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	/*
	 * Add new REST API end point
	 * Desc - Get restaurant details by id
	 * URL - http://host:port/restaurants/{restaurantId}
	 * Method - GET
	 * Payload - none
	 * Resp -  succes - JSON for Restaurant
	 * error - ApiResp DTO + error mesg
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getRestaurantDetails(@PathVariable Long id)
	{
		System.out.println("in get details "+id);
		//call service layer method
		try {
			return ResponseEntity.
					ok(restaurantService.getRestaurantDetails(id));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	/*
	 * Add new REST API end point
	 * Desc - Update restaurant details by id
	 * URL - http://host:port/restaurants/{restaurantId}
	 * Method - PUT
	 * Payload - json -> Restaurant (updated details)
	 * Resp -  success - ApiResp DTO + success mesg
	 * error - ApiResp DTO + error mesg
	 */
	@PutMapping("/{restaurantId}")
	public ResponseEntity<?> updateDetails(@PathVariable Long restaurantId,
			@RequestBody Restaurant restaurant)
	{
		System.out.println("in update "+restaurantId+" "+restaurant);
		try {
			return ResponseEntity.ok
			(restaurantService.
					updateDetails(restaurantId,restaurant));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	

}
