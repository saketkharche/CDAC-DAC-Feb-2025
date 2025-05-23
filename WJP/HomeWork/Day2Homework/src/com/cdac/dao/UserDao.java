package com.cdac.dao;

import java.sql.Date;

import com.cdac.pojos.User;

public interface UserDao {
	String registerVoter(String fn, String ln, String email, String pwd, Date dob);
	String changePassword(String email, String oldPwd, String newPwd);
	String deleteVoterDetails(int voterId);
	User signIn(String email, String pwd);
	void cleanUp() throws Exception;
}
