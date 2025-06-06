package com.cdac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.UserSignupRequest;
import com.cdac.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	//depcy 
	private final UserService userService;
	/*
	 * 
	 * Desc - user signup 
	 * URL - http://host:port/users
	 * Method - POST
	 * Payload - user reg request dto
	 * Resp -  success - SC201 n api resp - success mesg
	 * 
	 */
	@PostMapping
	@Operation(description = "User sign up")
	public ResponseEntity<?> userSignUp(
			@RequestBody @Valid  UserSignupRequest dto ) {
		System.out.println("in user sign up "+dto);
		//invoke service method
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.registerNewUser(dto));
		
	}
	

}
