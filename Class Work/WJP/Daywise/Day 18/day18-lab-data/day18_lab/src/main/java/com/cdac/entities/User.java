package com.cdac.entities;

import java.time.LocalDate;

/*
 * User - class
id : Long
first name , last name, email ,password - String
dob - LocalDate
role : Enum 
image : byte[]
 */
/*
 * Mandatory annotation for hibernate to manage entity 
 * @Entity - class level 
 * @Id - for PK (unique id property - typically - ref type for easy null 
 * checking) - field level | getter level
 */
//JPA package
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
import lombok.ToString;

@Entity // mandatory
@Table(name = "users") // name of the table
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "password", "image", "myAddress" }, callSuper = true)
public class User extends BaseEntity {

	// col name first_name , varchar(20)
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 30)
	private String lastName;
	// col name - email , len=30 , unique constraint
	@Column(length = 30, unique = true)
	private String email;
	// col name - password , len=20 ,not null constraint
	@Column(length = 20, nullable = false)
	private String password;
	// col name dob , type : date
	private LocalDate dob;
	// col - enum , name=user_role
	// to store enum constants
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private UserRole role;
	@Lob // to customize col type - longblob
	private byte[] image;
	// User 1--->1 Address 
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address myAddress;
	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = role;
	}

	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
}
