package com.cdac.dao;

import java.sql.SQLException;
import com.cdac.pojos.User;

public interface UserDao {
    User signIn(String email, String pwd) throws SQLException;
    String registerVoter(User user) throws SQLException;
    String changePassword(String email, String oldPwd, String newPwd) throws SQLException;
    String deleteUser(int voterId) throws SQLException;
}
