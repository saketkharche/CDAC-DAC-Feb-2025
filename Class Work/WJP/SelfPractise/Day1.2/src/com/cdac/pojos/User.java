package com.cdac.pojos;

import java.sql.Date;

/*
 * DB Table Structure:
 * id | first_name | last_name | email | password | dob | status | role
 * This POJO class is used to store and transfer user data.
 */
public class User {
	private int userId;           // corresponds to `id`
	private String firstName;     // corresponds to `first_name`
	private String lastName;      // corresponds to `last_name`
	private String email;         // corresponds to `email`
	private String password;      // corresponds to `password`
	private Date dob;             // corresponds to `dob` (java.sql.Date is used for SQL DATE)
	private boolean status;       // corresponds to `status` (voting status or active status)
	private String userRole;      // corresponds to `role` (e.g. voter, admin)

	// 🔹 Default constructor (required for frameworks or tools)
	public User() {
		// No initialization needed here
	}

	// 🔹 All-fields constructor (for setting all fields at once)
	public User(int userId, String firstName, String lastName, String email,
	            String password, Date dob, boolean status, String userRole) {
		super(); // optional in this case
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.userRole = userRole;
	}

	// 🔹 Getters & Setters (used to access private fields from other classes)

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

	// 🔹 toString() for debugging/logging
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName +
		       ", email=" + email + ", dob=" + dob + ", status=" + status + ", userRole=" + userRole + "]";
	}
}
