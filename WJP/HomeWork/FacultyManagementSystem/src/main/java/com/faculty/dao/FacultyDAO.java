package com.faculty.dao;

import java.sql.*;
import java.util.*;
import com.faculty.model.Faculty;

public class FacultyDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/faculty_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Faculty> getAllFaculty() {
        List<Faculty> list = new ArrayList<>();
        String sql = "SELECT * FROM faculty ORDER BY name ASC";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Faculty f = new Faculty();
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setDepartment(rs.getString("department"));
                f.setEmail(rs.getString("email"));
                f.setQualification(rs.getString("qualification"));
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertFaculty(Faculty f) {
        String sql = "INSERT INTO faculty VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, f.getId());
            ps.setString(2, f.getName());
            ps.setString(3, f.getDepartment());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getQualification());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFaculty(int id) {
        String sql = "DELETE FROM faculty WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Faculty getFacultyById(int id) {
        Faculty f = new Faculty();
        String sql = "SELECT * FROM faculty WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setName(rs.getString("name"));
                f.setDepartment(rs.getString("department"));
                f.setEmail(rs.getString("email"));
                f.setQualification(rs.getString("qualification"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public boolean updateFaculty(Faculty f) {
        String sql = "UPDATE faculty SET name=?, department=?, email=?, qualification=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getName());
            ps.setString(2, f.getDepartment());
            ps.setString(3, f.getEmail());
            ps.setString(4, f.getQualification());
            ps.setInt(5, f.getId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
