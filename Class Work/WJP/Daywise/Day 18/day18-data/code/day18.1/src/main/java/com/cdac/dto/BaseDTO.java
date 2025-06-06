package com.cdac.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BaseDTO {	
	/*
	 * To specify to Jackson(=lib auto chosen by
	 *  spring boot for ser n de-ser) 
	 *  skip some field/props during serialization
	 *  @JsonProperty(access=WRITE_ONLY)
	 *   skip some field/props during de-serialization
	 *   @JsonProperty(access=READ_ONLY)
	 *  
	 */
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate creationDate;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime updatedOn;
}
