package com.cdac.dao;

import java.sql.SQLException;
import java.util.List;

import com.cdac.pojos.User;

public interface UserDao {
//sign in using layer
	// ....... signIn(em,pass) throws SE
	User signIn(String email,String pwd) throws SQLException;
	//sign up 
	// String signUp(User newUser) throws SE
	String signUp(User newUser) throws SQLException;
	//add a method to change the voting status
	String updateVotingStatus(int voterId) throws SQLException;
	//update user details - password
	String updateUserDetails(int userId,String newPassword) throws SQLException;
	//delete user
	String deleteUser(int userId) throws SQLException;
	//list users 
	List<User> listUsers() throws SQLException;
	//get user details
	User getUserDetails(int userId) throws SQLException;
	
}
