package com.cdac.exception_handler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dto.ApiResponse;

import jakarta.validation.ConstraintViolationException;

/*
 * to declare a spring bean containing common exc handling advice
meant for all
 * rest controllers (all methods)
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	// equivalent to - catch-all block
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		System.out.println("in catch all");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
	}

	// to declare exc handling method - catch block - B.L exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		System.out.println("in handle res not found exc");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
	// to declare exc handling method - catch block - P.L exception
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<?> handleMethodArgumentNotValidException
		(MethodArgumentNotValidException e) {
			System.out.println("in handle method  arg invalid  exc : P.L validation failures");
			//1. Get List of rejected fields
			List<FieldError> rejectedFields = e.getFieldErrors();
			//2. Convert List<FieldError> -> Map<String:Field name,String-def mesg>
			Map<String, String> errorMap = rejectedFields.stream() //Stream<FieldError>
			.collect(
					Collectors.toMap
					(FieldError::getField,FieldError::getDefaultMessage));
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(errorMap);
		}
		
		// to declare exc handling method - catch block - P.L failures for req params or path vars
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
			System.out.println("in handle constraint violation  exc");
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
		}

}
