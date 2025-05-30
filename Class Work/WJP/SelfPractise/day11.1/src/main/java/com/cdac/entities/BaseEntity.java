package com.cdac.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * To declare a common base class - w/o any associated table
 * All other entities will extend n inherit fields
 */
@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
	// add common fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreationTimestamp
	@Column(name="creation_date")
	private LocalDate creationDate;
	@UpdateTimestamp
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
}
