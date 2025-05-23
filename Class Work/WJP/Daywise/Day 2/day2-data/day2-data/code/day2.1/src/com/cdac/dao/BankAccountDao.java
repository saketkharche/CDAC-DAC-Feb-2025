package com.cdac.dao;

import java.sql.SQLException;

public interface BankAccountDao {
//add a method for the funds transfer
	 String transferFunds(int srcAcNo,int destAcNo,
			 double amount) throws SQLException;
}
