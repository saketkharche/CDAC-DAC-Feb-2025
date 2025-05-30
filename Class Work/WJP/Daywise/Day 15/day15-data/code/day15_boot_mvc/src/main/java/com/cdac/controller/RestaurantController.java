package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

@Controller //spring managed bean - req handling logic
//singleton n eager
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
	/*
	 * URL - http://host:post/ctx_path/restaurants/delete?id=...
	Method - GET
	Payload - request param - restaurantId
	Action - soft delete restaurant details 
	Resp - redirect resp , redirect location - /restaurants/list
	(Why redirect n not forward?)
	 @RequestParam - Method arg level annotation
	  - To bind incoming req paramter to method argument
	  - parsing will be auto done by SC
	  - Long id=Long.parseLong(request.getPramter("id"));
	  Simply match the names , o.w add name param
	 */
	@GetMapping("/delete")
	public String softDeleteRestaurantDetails(@RequestParam Long id)
	{
		System.out.println("in delete "+id);
		//invoke service layer method
		restaurantService.deleteDetails(id);
		return "redirect:/restaurants/list";		
		//SC - response.sendRedirect(response.encodeRedirectURL("restaurants/list"));
		//sends temp redirect resp
		//clnt browser sends a next request
		// URL - http://host:post/ctx_path/restaurants/list -> D.S -> H.M -> 
	// not null -> D.S invokes - renderRestList
	}
	/*
	 * Add req handling method - to show add rest form
	 * URL - http://host:port/ctx_path/restaurants/add_form
	 * Method - GET
	 * Resp - render restaurant add form
	 */
	@GetMapping("/add_form")
	public String showAddRestaurantForm(@ModelAttribute Restaurant r) {
		System.out.println("in show add form "+r);//empty POJO
		return "restaurants/add";//AVN - /WEB-INF/views/restaurants/add.jsp
	}
	
	/*
	 * Add req handling method - to process the form
	 * URL - http://host:port/ctx_path/restaurants/add_form
	 * Method - POST
	 * Resp - add new restaurant details in db n redirect the client to list
	 */
	
	@PostMapping("/add_form")
	public String processAddRestaurantForm(@ModelAttribute Restaurant newRestaurant) {
		System.out.println("in process form "+newRestaurant);
		//invoke service method
		restaurantService.addNewRestaurant(newRestaurant);
		return "redirect:/restaurants/list";
	}
	
	

}
