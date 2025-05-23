package com.voting.utils;

import java.sql.*;

public class DBUtils {
    public static Connection openConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/vote", "root", "root");
    }
}
