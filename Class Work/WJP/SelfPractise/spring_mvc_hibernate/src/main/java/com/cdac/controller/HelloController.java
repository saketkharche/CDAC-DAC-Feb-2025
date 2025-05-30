package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory cls level annotation to declare -
//a spring bean as request handling controller(handler)
//singleton n eager
public class HelloController {

	public HelloController() {
		System.out.println("in ctor of " + getClass());
	}
	@RequestMapping("/") //mandatory method level annotation to declare 
	//req handling method : equivalent to service(rq,rs) 
	public String renderWelcomePage() {
		System.out.println("in render welcome page ....");
		return "index";//handler -> rets -> LVN (logical view name) -> D.S -> V.R -> AVN -> 
		//   /WEB-INF/views/index.jsp
	}
	

}
