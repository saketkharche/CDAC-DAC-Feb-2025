package com.cdac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.UserSignInRequest;
import com.cdac.dto.UserSignupRequest;
import com.cdac.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController  //spring bean - containing P.L (req n rs handling logic)
//singleton , eager
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
	 * Payload - user registration request dto
	 * Resp -  success - SC201 n sign up  resp 
	 * Error - error code , ApiResp - err mesg
	 * 
	 */
	@PostMapping("/signup")
	@Operation(description = "User sign up")
	public ResponseEntity<?> userSignUp(
			@RequestBody @Valid  UserSignupRequest dto ) {
		System.out.println("in user sign up "+dto);
		//invoke service method
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.registerNewUser(dto));
		
	}
	/*
	 * - URL - http://host:port/users/signin
Method - POST
Payload - req DTO - email , password
Resp 
success - SC 200 + user resp dto
error - SC 401 + error mesg 
 - custom exc - AuthenticationException
(no try-catch pls , add exc handling method - global handler)
	 */
	@PostMapping("/signin")
	@Operation(description = "User sign in")
	public ResponseEntity<?> userSignIn
	(@RequestBody @Valid UserSignInRequest dto)
	{
		System.out.println("in user sign in "+dto);
		//invoke service layer method n return resp packet
		return ResponseEntity.ok(userService.authenticateUser(dto));
	}
	

}
