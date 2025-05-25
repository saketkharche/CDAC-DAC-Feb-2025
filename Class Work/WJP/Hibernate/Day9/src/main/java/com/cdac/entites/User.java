package com.cdac.entites;

import java.time.LocalDate;

import jakarta.persistence.Column;
//import annotation from jpa
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "new_users")
public class User {
	@Id // mandory pk constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto genrate ids
	@Column(name = "userId") // colum name for id specifcation
	private Long userId;
	@Column(length = 30, name = "first_name") // col name and size
	private String firstName;
	@Column(length = 30, name = "last_name")
	private String lastName;
	@Column(length = 30, unique = true) // to add unique constraint
	private String email;
	@Column(length = 20, nullable = false) // not null
	private String password;
	@Transient // skips from persistence . no col genration
	private String confirmPassword;
	@Lob // col type for mysql
	private LocalDate dob;
	@Enumerated(EnumType.STRING) // col type -varchar:name of constant
	@Column(length = 30)
	private UserRole userRole;
	private byte[] image;

	public User() {
		// mandatory
	}
	// parameterzed contror

	public User(Long userId, String firstName, String lastName, String email, String password, LocalDate dob,
			UserRole userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.userRole = userRole;
	}

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
