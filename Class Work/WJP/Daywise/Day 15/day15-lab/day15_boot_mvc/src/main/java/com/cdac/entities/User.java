package com.cdac.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
//import annotations from JPA
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "new_users") // to specify table name
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
	@Column(length = 20, name = "first_name") // col name , varchar size
	private String firstName;
	@Column(length = 30, name = "last_name") // col name , varchar size
	private String lastName;
	@Column(length = 30, unique = true) // varchar(30), unique constraint
	private String email;
	@Column(length = 20, nullable = false) // not null
	private String password;
//	@Transient //skips from persistence - no col generation
//	private String confirmPassword;
	private LocalDate dob;
	@Enumerated(EnumType.STRING) // col type - varchar : name of constant
	@Column(length = 30, name = "user_role")
	private UserRole userRole;
	@Lob // col type for mysql - longblob
	private byte[] image;
	@Column(name = "subscription_amount")
	private double subscriptionAmount;	
	//uni dir User 1----->1 Address
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address myAddress;

	// parameterized ctor for sign up
	public User(String firstName, String lastName, String email, String password, LocalDate dob, UserRole userRole,
			double subscriptionAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.userRole = userRole;
		this.subscriptionAmount = subscriptionAmount;
	}

	// adding overloaded parameterized ctor - for JPQL constr expression
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

}
