package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.service.RestaurantService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	//depcy - service layer i/f
	@Autowired //byType - no ambiguity exc - since there is ONLY 1 imple class
	private RestaurantService restaurantService;
	public RestaurantController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * Add req handling method
	 * URL - http://host:port/ctx_path/restaurants/list
	 * Method - GET
	 * Resp - render list of restaurants
	 */
	@GetMapping("/list")
	public String renderRestaurantList(Model map) {
		System.out.println("in render list "+map);//{}
		//add result(List) as a model attribute
		map.addAttribute("restaurant_list", 
				restaurantService.getAllRestaurants());
		return "restaurants/list";
	}
	/*
	 * Handler rets explicitly - LVN + SC rets impl model map -> D.S
	 * send LVN -> V.R -> AVN (/WEB-INF/views/restaurants/list.jsp)
	 * -> D.S -> adds model attr(list)  under req scope 
	 * -> forwards the clnt req ->
	 *  JSP -> ${requestScope.restaurant_list}
	 */

}
