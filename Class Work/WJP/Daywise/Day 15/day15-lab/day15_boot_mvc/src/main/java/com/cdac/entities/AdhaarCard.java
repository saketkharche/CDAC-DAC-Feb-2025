package com.cdac.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class AdhaarCard {
	@Column(name = "card_no", length = 14, unique = true)
	private String cardNumber;
	@Column(name = "card_created_on")
	private LocalDate createdOn;
	@Column(length = 30)
	private String location;

}
