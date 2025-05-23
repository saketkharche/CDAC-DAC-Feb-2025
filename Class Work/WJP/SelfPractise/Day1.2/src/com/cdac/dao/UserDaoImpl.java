package com.cdac.dao;

import java.sql.*;
import com.cdac.pojos.User;
import static com.cdac.utils.DBUtils.*;
import java.time.LocalDate;
import java.time.Period;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    private PreparedStatement pst1, pst2, pst3, pst4;

    public UserDaoImpl() throws SQLException {
        openConnection();
        connection = getConnection();

        // 1. Sign in
        pst1 = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");

        // 2. Register voter
        pst2 = connection.prepareStatement(
            "INSERT INTO users (first_name, last_name, email, password, dob, status, role) VALUES (?, ?, ?, ?, ?, ?, ?)");

        // 3. Change password
        pst3 = connection.prepareStatement(
            "UPDATE users SET password=? WHERE email=? AND password=?");

        // 4. Delete user
        pst4 = connection.prepareStatement(
            "DELETE FROM users WHERE id=?");

        System.out.println("User DAO created!");
    }

    @Override
    public User signIn(String email, String pwd) throws SQLException {
        pst1.setString(1, email);
        pst1.setString(2, pwd);
        try (ResultSet rst = pst1.executeQuery()) {
            if (rst.next()) {
                return new User(
                    rst.getInt("id"),
                    rst.getString("first_name"),
                    rst.getString("last_name"),
                    rst.getString("email"),
                    rst.getString("password"),
                    rst.getDate("dob"),
                    rst.getBoolean("status"),
                    rst.getString("role")
                );
            }
        }
        return null;
    }

    @Override
    public String registerVoter(User user) throws SQLException {
        // Age validation
        LocalDate birthDate = user.getDob().toLocalDate();
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        if (age < 21) {
            return "Registration failed: Age must be at least 21.";
        }

        pst2.setString(1, user.getFirstName());
        pst2.setString(2, user.getLastName());
        pst2.setString(3, user.getEmail());
        pst2.setString(4, user.getPassword());
        pst2.setDate(5, user.getDob());
        pst2.setBoolean(6, false); // status=false by default
        pst2.setString(7, "voter");

        int rowCount = pst2.executeUpdate();
        return rowCount == 1 ? "Registration successful!" : "Registration failed.";
    }

    @Override
    public String changePassword(String email, String oldPwd, String newPwd) throws SQLException {
        pst3.setString(1, newPwd);
        pst3.setString(2, email);
        pst3.setString(3, oldPwd);

        int updated = pst3.executeUpdate();
        return updated == 1 ? "Password updated successfully." : "Failed to update password.";
    }

    @Override
    public String deleteUser(int voterId) throws SQLException {
        pst4.setInt(1, voterId);
        int deleted = pst4.executeUpdate();
        return deleted == 1 ? "User deleted successfully." : "User not found.";
    }

    public void cleanUp() throws SQLException {
        if (pst1 != null) pst1.close();
        if (pst2 != null) pst2.close();
        if (pst3 != null) pst3.close();
        if (pst4 != null) pst4.close();
        closeConnection();
    }
}
