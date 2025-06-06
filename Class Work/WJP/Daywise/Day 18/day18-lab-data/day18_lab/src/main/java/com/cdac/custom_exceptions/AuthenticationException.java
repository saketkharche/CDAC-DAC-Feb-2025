package com.cdac.custom_exceptions;

public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String mesg) {
		super(mesg);
	}
}
