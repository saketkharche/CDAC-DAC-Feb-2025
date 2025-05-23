package com.voting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.voting.pojos.User;
import com.voting.utils.DBUtils;

public class UserDaoImpl implements UserDao {
    private Connection conn;
    private PreparedStatement pst1, pst2;

    public UserDaoImpl() throws Exception {
        conn = DBUtils.openConnection();
        pst1 = conn.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
        pst2 = conn.prepareStatement("UPDATE users SET status=1 WHERE id=?");
    }

    public User authenticateUser(String email, String password) throws Exception {
        pst1.setString(1, email);
        pst1.setString(2, password);
        ResultSet rst = pst1.executeQuery();
        if (rst.next()) {
            return new User(rst.getInt(1), email, password, rst.getString(4), rst.getBoolean(5));
        }
        return null;
    }

    public void updateVotingStatus(int userId) throws Exception {
        pst2.setInt(1, userId);
        pst2.executeUpdate();
    }

    public void cleanUp() throws Exception {
        if (pst1 != null) pst1.close();
        if (pst2 != null) pst2.close();
        if (conn != null) conn.close();
    }
}