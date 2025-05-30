package com.cdac.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * URL - http://host:port/ctx/test/test1 , GET
	 * Resp - dyn resp with time stamp
	 * Entry in H.M (HandlerMapping)
	 * Key - /test/test1
	 * Value - TestController.testModelAndView
	 */
	@GetMapping("/test1")
	public ModelAndView testModelAndView() {
		System.out.println("in test model n view");
		/*
		 * Ctor of o.s.w.s.ModelAndView(String LVN , 
		 * String modelAttrName
		 * ,Object modelAttrValue)
		 * ModelAndView - class that holds model n view together.
		 * 
		 */
		return new ModelAndView("test/display", 
				"server_ts", LocalDateTime.now());
		/*
		 * Handler rets ModelAndView -> D.S 
		 * D.S -> extracts LVN -> V.R
		 * V.R -> AVN (/WEB-INF/views/test/display.jsp) -> D.S
		 * -> chks for model attributes 
		 * -> present -> adds model attribute under req scope
		 * -> forwards (rd.forward) -> view layer
		 * 
		 */
		/*
		 * URL - http://host:port/ctx/test/test2 , GET
		 * Resp - dyn resp with time stamp + List<Integer> => multiple model attrs
		 * Entry in H.M (HandlerMapping)
		 * Key - /test/test2
		 * Value - TestController.testModelMap
		 */
		
	}
	@GetMapping("/test2")
	public String testModelMap(Model modelMap) {
		System.out.println("in test model map "+modelMap);//{} - SC
		/*
		 * API of o.s.ui.Model - i/f
		 * public Model addAttribute(String modelAttrName,Object value)
		 */
		modelMap.addAttribute("server_time", LocalTime.now())
		.addAttribute("number_list", List.of(10, 20, 30));
		//List.of(10, 20, 30) -> rets immutable List<Integer>
		System.out.println("in test model map "+modelMap);//{k1=v1,k2=v2}
		return "test/display2";
	}
	/*
	 *  Handler retes explicitly -  LVN
	 *   SC implicitly adds - model map n sends it to D.S
	 *   D.S -> LVN -> V.R -> AVN :/WEB-INF/views/test/display2.jsp
	 *   -> D.S -> adds 2 model attrs under request scope
	 *   -> rd.foward(rq,rs) -> JSP 
	 *   
	 */
	

}
