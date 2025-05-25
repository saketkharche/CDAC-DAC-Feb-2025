package com.cdac.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;

public class UserDaoImpl implements UserDao {
	// dependency - DB connection - DBUtils
	private Connection connection;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5, pst6, pst7;

	public UserDaoImpl() throws SQLException {
		// establish db cn
		// openConnection(); will be called in the init method
		connection = getConnection();
		// creates PreparedStament
		String sql = "select * from users where email=? and password=?";
		pst1 = connection.prepareStatement(sql);
		// create PST - to insert a record
		pst2 = connection.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		// create pst - to update status
		pst3 = connection.prepareStatement("update users set status=? where id=?");
		// pst4 - change password
		pst4 = connection.prepareStatement("update users set password=? where id=?");
		// pst5 - delete user
		pst5 = connection.prepareStatement("delete from users where id=?");
		// pst6 - list all users (no admin)
		pst6 = connection.prepareStatement("select * from users where role != 'admin'");
		// pst7 - get user by id
		pst7 = connection.prepareStatement("select * from users where id=?");
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

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		// Set In params - status , id
		pst3.setBoolean(1, true);
		pst3.setInt(2, voterId);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "Voter voted successfully!";
		return "voting failed !!!!!!";

	}

	@Override
	public String updateUserDetails(int userId, String newPassword) throws SQLException {
		// Set In params - new password , id
		pst4.setString(1, newPassword);
		pst4.setInt(2, userId);
		int updateCount = pst4.executeUpdate();
		if (updateCount == 1)
			return "Password updated!";
		return "password updation failed!!!!!!";
	}

	@Override
	public String deleteUser(int userId) throws SQLException {
		// Set In param - id
		pst5.setInt(1, userId);
		int updateCount = pst5.executeUpdate();
		if (updateCount == 1)
			return "User deleted!";
		return "deletion  failed!!!!!!";
	}

	@Override
	public List<User> listUsers() throws SQLException {
		List<User> users = new ArrayList<>();

		// execute query n process RST
		try (ResultSet rst = pst6.executeQuery()) {
			while (rst.next()) {
				users.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getDate(6), rst.getBoolean(7), rst.getString(8)));
			}
		}
		return users;
	}

	@Override
	public User getUserDetails(int userId) throws SQLException {
		// 1. set IN param
		pst7.setInt(1, userId);
		// 2. execute query n process RST
		try (ResultSet rst = pst7.executeQuery()) {
			if (rst.next()) {
				// success
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
			}
		}
		return null;

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
		if (pst3 != null) {
			pst3.close();
			pst3 = null;
		}
		if (pst4 != null) {
			pst4.close();
			pst3 = null;
		}
		if (pst5 != null) {
			pst5.close();
			pst5 = null;
		}
		if (pst6 != null) {
			pst6.close();
			pst6 = null;
		}
		if (pst7 != null) {
			pst7.close();
			pst7 = null;
		}
		System.out.println("user dao cleaned up !");

	}

}
