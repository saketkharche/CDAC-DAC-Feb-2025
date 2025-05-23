package com.cdac.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import static com.cdac.utils.DBUtils.*;

public class BankAccountDaoImpl implements BankAccountDao {
      //state 
	private Connection cn;
	private CallableStatement cst1;
	
	//def ctor
	public BankAccountDaoImpl() throws SQLException{
		// open n get cn
		openConnection();
		cn=getConnection();
		//1. create CallableStatement to exec a stored proc
		/*
		 * Connection i/f method
		 * public CallableStatement prepareCall(String sqlSyntax) throws SE
		 * 
		 */
		String sqlSyntax="{call transfer_funds_proc(?,?,?,?,?)}";
		cst1=cn.prepareCall(sqlSyntax);
		//2. register out params
		/*
		 * Method of CallableStatement
		 * public void registerOutParameter(int paramIndex,int sqlType) throws SE
		 * Use java.sql.Types class constants to specify - JDBC type
		 */
		cst1.registerOutParameter(4,Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		//Should I call Set IN param from here ? NO
		System.out.println("acct dao created !");
		
	}
	
	@Override
	public String transferFunds(int srcAcNo, int destAcNo, double amount) throws SQLException {
		// 3. set IN params
		cst1.setInt(1,srcAcNo);
		cst1.setInt(2, destAcNo);
		cst1.setDouble(3, amount);
		//4. execute the stored proc
		/*
		 * Method of CallableStatement
		 * public boolean execute() throws SQLException
		 * During the exec of procedure or function , ignore ret type
		 * 
		 */
		cst1.execute();
		/*
		 * 5. To get the results from OUT params
		 * Method of CallableStatement -
		 * public Type getType(int paramIndex) throws SE
		 * 
		 */
		
		return "Updated src balance "
		+cst1.getDouble(4)+" dest balance "+cst1.getDouble(5);
	}
	
	//clean up 
	public void cleanUp() throws SQLException
	{
		if(cst1 != null)
		{
			cst1.close();
			cst1=null;
		}
		closeConnection();
	}

}
