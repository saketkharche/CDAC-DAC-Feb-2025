package com.cdac.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.cdac.entities.User;
import com.cdac.entities.UserRole;

public interface UserDao {
//add a method to sign up new user
	String signUp(User user);

	User getUserDetails(Long userId);

	List<User> getAllUsers();

	List<User> getSelectedUsers(LocalDate start,
			LocalDate end,UserRole role);

	User userSignIn(String next, String next2);

	List<String> getSelectedUsersFirstNames(UserRole valueOf);

	List<User> getSelectedUsersDetails(UserRole valueOf);

	String updateUserDetails(LocalDate date, double discount);

	String deleteUserDetails(Long userId);

	String saveImage(Long userId, String path) throws IOException;

	String restoreImage(String email, String path) throws IOException;
}
