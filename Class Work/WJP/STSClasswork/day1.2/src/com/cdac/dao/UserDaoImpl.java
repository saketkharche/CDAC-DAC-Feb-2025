package com.cdac.dao;

import java.sql.*;

import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	// dependency - DB connection - DBUtils
	private Connection connection;
	private PreparedStatement pst1;

	// def ctor - will be invoked by layer above - Tester (dyn web comp)
	public UserDaoImpl() throws SQLException {
		// establish db cn
		openConnection();
		connection = getConnection();
		// creates PreparedStament
		String sql = "select * from users where email=? and password=?";
		pst1 = connection.prepareStatement(sql);
		System.out.println("user dao created !");
	}

	@Override
	public User signIn(String email, String pwd) throws SQLException {
		// 1. set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		// 2. execute query n process RST
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next()) {
				//success
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
			return null;

		}

	}

	// clean up - close db resources (PST , DB cn)
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		closeConnection();
	}

}
