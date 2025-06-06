package com.cdac.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.cdac.entities.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // only for debugging
public class UserSignupRequest {
	@NotBlank(message = "first name is required....")
	private String firstName;
	@NotBlank
	@Length(min = 5, max = 20, message = "Invalid length of last name")
	private String lastName;
	@Email(message = "Invalid email format")
	private String email;
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "invalid password format!!!!")
	private String password;
	@NotNull
	@Past(message = "dob must in past !!!!")
	private LocalDate dob;
	@NotNull(message = "role must be supplied...")
	private UserRole role;

}
