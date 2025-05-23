package com.cdac.dao;

import java.sql.*;

import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	// dependency - DB connection - DBUtils
	private Connection connection;
	private PreparedStatement pst1, pst2;

	// def ctor - will be invoked by layer above - Tester (dyn web comp)
	public UserDaoImpl() throws SQLException {
		// establish db cn
	//	openConnection(); will be called in the init method
		connection = getConnection();
		// creates PreparedStament
		String sql = "select * from users where email=? and password=?";
		pst1 = connection.prepareStatement(sql);
		// create PST - to insert a record
		pst2 = connection.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created !");
	}

	@Override
	public User signIn(String email, String pwd) throws SQLException {
		// 1. set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// 2. execute query n process RST
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * id | first_name | last_name | email | password | dob | status | role
			 */
			if (rst.next()) {
				// success
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
			return null;

		}

	}

	@Override
	public String signUp(User newUser) throws SQLException {
		/*
		 * first_name | last_name | email | password | dob | status | role
		 */
		// set In params
		pst2.setString(1, newUser.getFirstName());// 1 - in param index
		pst2.setString(2, newUser.getLastName());
		pst2.setString(3, newUser.getEmail());
		pst2.setString(4, newUser.getPassword());
		pst2.setDate(5, newUser.getDob());
		pst2.setBoolean(6, false);
		pst2.setString(7, "voter");
		// execute query - public int executeUpdate() throws SQLException
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Voter registered....";
		return "reg failed !!!!!!";
	}

	// clean up - close db resources (PST , DB cn)
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		if (pst2 != null) {
			pst2.close();
			pst2 = null;
		}
		System.out.println("user dao cleaned up !");
		
	}

}
