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
		System.out.println("in render list "+map);//{} - empty model attr map
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
	 * @ModelAttribute - annotation that can be added on method arg | method ret type
	 * use case - method arg
	 * To tell SC - to bind entity (Restaurant entity - model -> form)
	 * -i.e modelMap.addAttribute("restaurant",new Restaurant());
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
	 * @ModelAttribute Restaurant newRestaurant 
	 * - SC creates - new Restaurant() 
	 *  - setters on the entity (name, city,adr, desc)
	 *  - inject this entity(model) into the method
	 * 
	 */
	
	@PostMapping("/add_form")
	public String processAddRestaurantForm(@ModelAttribute Restaurant newRestaurant) {
		System.out.println("in process form "+newRestaurant);
		//invoke service method
		restaurantService.addNewRestaurant(newRestaurant);
		return "redirect:/restaurants/list";
	}
	/*
	 * Handler method rets - redirect view name (redirect loaction) -> D.S
	 * D.S -> immediately send temp redirect resp
	 * SC 302 , Header - Location - restaurants/list;jsessionid=DGADF564GFH
	 * body EMPTY
	 * web browser sends redirect request ->
	 * http://host:port/ctx_path/restaurants/list
	 * Method=GET
	 */
	
	/*
	 * Add req handling method - to show update restaurant form
	 * URL - http://host:port/ctx_path/restaurants/update_form?id=...
	 * Method - GET
	 * Resp - render restaurant update form
	 * 
	 */
	@GetMapping("/update_form")
	public String showUpdateForm(@RequestParam Long id,Model map) {
		System.out.println("in show update form "+id);
		map.addAttribute("restaurant", 
				restaurantService.getRestaurantDetailsById(id));
		return "restaurants/update";//AVN - /WEB-INF/views/restaurants/update.jsp
	}
	
	/*
	 * Add req handling method - to process the update form
	 * URL - http://host:port/ctx_path/restaurants/update_form?id=....
	 * Method - POST
	 * Resp - update restaurant details in db n redirect the client to list
	 * @ModelAttribute Restaurant newRestaurant 
	 * - SC creates - new Restaurant() 
	 *  - setters on the entity (name, city,adr, desc)
	 *  - inject this entity(model) into the method
	 * 
	 */
	
	@PostMapping("/update_form")
	public String processUpdateForm(@RequestParam Long id,@ModelAttribute Restaurant restaurant) {
		System.out.println("in process update form "+restaurant);
		//invoke service method
		restaurantService.updateRestaurant(id,restaurant);
		return "redirect:/restaurants/list";
	}
	
	
	

}
