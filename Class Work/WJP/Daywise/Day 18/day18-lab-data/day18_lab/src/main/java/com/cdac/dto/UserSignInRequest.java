package com.cdac.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignInRequest {
	@NotBlank
	private String email;
	@NotBlank
	private String password;
}
