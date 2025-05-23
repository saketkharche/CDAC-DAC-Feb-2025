package com.cdac.dao;

import java.sql.SQLException;

import com.cdac.pojos.User;

public interface UserDao {
//sign in using layer
	// ....... signIn(em,pass) throws SE
	User signIn(String email,String pwd) throws SQLException;
	//sign up 
	// String signUp(User newUser) throws SE
	String signUp(User newUser) throws SQLException;
}
