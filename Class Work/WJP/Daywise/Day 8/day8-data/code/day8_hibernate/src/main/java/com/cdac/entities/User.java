package com.cdac.entities;

import java.time.LocalDate;
//import annotations from JPA
import jakarta.persistence.*;

@Entity
@Table(name="new_users") //to specify table name
public class User {
	//Reco - use ref type for easier null checking for hibernate
	@Id //mandatory => PK constraint
	//for automatic generation of ids -using auto_increment (MySQL)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;//Integer
	@Column(length = 20,name="first_name") //col name , varchar size
	private String firstName;
	@Column(length = 30,name="last_name") //col name , varchar size
	private String lastName;
	@Column(length = 30,unique = true)//varchar(30), unique constraint
	private String email;
	@Column(length = 20,nullable = false)//not null
	private String password;
//	@Transient //skips from persistence - no col generation
//	private String confirmPassword;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)//col type - varchar : name of constant
	@Column(length = 30,name="user_role")
	private UserRole userRole;
	@Lob //col type for mysql - longblob
	private byte[] image;
	public User() {
		// mandatory
	}
	//parameterized ctor for sign up
	public User(String firstName, String lastName, String email, String password, LocalDate dob, UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.userRole = userRole;
	}
	//all getters n setters
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", userRole=" + userRole + "]";
	}
	
	
	
	

}
