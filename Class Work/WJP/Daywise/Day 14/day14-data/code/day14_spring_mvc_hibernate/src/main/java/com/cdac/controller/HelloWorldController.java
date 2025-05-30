package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //sub type of @Component .
//spring bean - managed by SC
//singleton , eager
public class HelloWorldController {
	public HelloWorldController() {
		System.out.println("in ctor of "+getClass());
	}
	/*
	 * add request handling method
	 * Req URL - http://host:port/ctx_path/
	 * Resp - index page (welcome contents)
	 * In the HandlerMapping bean -
	 * Key - /
	 * Value -com.cdac.controller.HelloWorldController.renderIndexPage
	 * 
	 */
	@GetMapping("/") //can intercept ONLY HTTP GET request
	//invoked by D.S - once per request 
	public String renderIndexPage() {
		System.out.println("in render index page");
		return "index";//index - Logical(Forward) View name(LVN)	
		//AVN(actual view name) - /WEB-INF/views/index.jsp
	}
	

}
