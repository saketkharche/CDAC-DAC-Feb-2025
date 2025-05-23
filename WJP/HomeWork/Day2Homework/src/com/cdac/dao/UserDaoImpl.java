package com.cdac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;

import com.cdac.pojos.User;
import com.cdac.utils.DBUtils;

public class UserDaoImpl {

    private Connection conn;
    private PreparedStatement pst;

    public UserDaoImpl() throws SQLException {
        conn = DBUtils.getConnection();
    }

    // 3.1 Voter registration
    public String registerUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getFirstName());
            pst.setString(2, user.getLastName());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            
            if(user.getDob() != null)
                pst.setDate(5, user.getDob());
            else
                pst.setNull(5, Types.DATE);

            pst.setBoolean(6, user.isStatus()); // true/false status
            pst.setString(7, user.getRole());   // e.g. "Voter"

            int rows = pst.executeUpdate();
            if (rows == 1)
                return "Registration successful";
            else
                return "Registration failed";

        } catch (SQLIntegrityConstraintViolationException e) {
            return "User with this email already exists!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error during registration: " + e.getMessage();
        }
    }

    // 3.2 Change password
    public String changePassword(String email, String oldPassword, String newPassword) {
        String checkSql = "SELECT password FROM users WHERE email = ?";
        String updateSql = "UPDATE users SET password = ? WHERE email = ?";

        try {
            pst = conn.prepareStatement(checkSql);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String currentPwd = rs.getString("password");
                if (currentPwd.equals(oldPassword)) {
                    pst = conn.prepareStatement(updateSql);
                    pst.setString(1, newPassword);
                    pst.setString(2, email);
                    int updated = pst.executeUpdate();
                    if (updated == 1)
                        return "Password changed successfully";
                    else
                        return "Password change failed";
                } else {
                    return "Old password is incorrect";
                }
            } else {
                return "Email not found";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error changing password: " + e.getMessage();
        }
    }

    // 3.3 Delete user by voter id
    public String deleteUser(int voterId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, voterId);
            int rows = pst.executeUpdate();
            if (rows == 1)
                return "User deleted successfully";
            else
                return "User with given ID not found";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting user: " + e.getMessage();
        }
    }

    // 3.4 Sign in user (email,password) => User or null
    public User signIn(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getDate("dob"),
                        rs.getBoolean("status"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Close connection and statement resources
    public void cleanUp() {
        try {
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
