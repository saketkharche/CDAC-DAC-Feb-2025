package com.cdac.pojos;

import java.sql.Date;

/*
 * id | first_name | last_name | emai| password | dob        | status | role
 */
public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dob;
	private boolean status;
	private String userRole;
	
	//POJO - add default constructor (ctor)
	public User() {
		// TODO Auto-generated constructor stub
	}
	//all args ctor
	public User(int userId, String firstName, String lastName, String email, String password, Date dob, boolean status,
			String userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.userRole = userRole;
	}
	//add overloaded ctor for voter registration
	public User(String firstName, String lastName, String email, String password, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
	
	
	//getters n setters

	public int getUserId() {
		return userId;
	}

	

	
	
	public void setUserId(int userId) {
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	//to string 

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", status=" + status + ", userRole=" + userRole + "]";
	}
	

}
