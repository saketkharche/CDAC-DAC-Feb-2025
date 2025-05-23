
# IMPLEMENTATION of JSP, Servlet, JDBC and JSTL with Comments

This guide provides a **complete implementation** of a Java web application using:
- **JSP (JavaServer Pages)** for the view layer
- **Servlets** for the controller logic
- **JDBC (Java Database Connectivity)** for database interaction
- **JSTL (JSP Standard Tag Library)** for cleaner JSP code

We'll build a simple **User Registration and Display System**.

---

## 🧱 1. Project Structure

```
UserApp/
│
├── src/
│   └── com.example.servlet.UserServlet.java
│
├── WebContent/
│   ├── index.jsp
│   ├── register.jsp
│   ├── success.jsp
│   └── users.jsp
│
├── WEB-INF/
│   ├── lib/
│   │   └── mysql-connector-java.jar
│   │
│   └── web.xml
│
└── db.sql (Database script)
```

---

## 🗄️ 2. Database Setup (MySQL)

```sql
-- db.sql
CREATE DATABASE userdb;

USE userdb;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE
);
```

---

## 🛠️ 3. JDBC Utility Class

### `DBConnection.java`

```java
package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

// Utility class to establish connection with MySQL database
public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/userdb", "root", "password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
```

---

## 📝 4. User DAO Class

### `UserDAO.java`

```java
package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.util.DBConnection;

// Data Access Object to interact with Users table
public class UserDAO {

    // Method to add a new user
    public boolean addUser(String name, String email) {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to fetch all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
```

---

## 📦 5. User Model Class

### `User.java`

```java
package com.example.model;

// Model class representing a User entity
public class User {
    private int id;
    private String name;
    private String email;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

---

## 🔁 6. Servlet Controller

### `UserServlet.java`

```java
package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.UserDAO;
import com.example.model.User;

// Servlet to handle user registration and display
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO(); // Initialize DAO on servlet start
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            if (userDAO.addUser(name, email)) {
                response.sendRedirect("success.jsp"); // Redirect after successful registration
            } else {
                request.setAttribute("error", "Registration failed!");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            List<User> userList = userDAO.getAllUsers();
            request.setAttribute("users", userList); // Set attribute for JSTL use

            // Forward to users.jsp
            request.getRequestDispatcher("users.jsp").forward(request, response);
        }
    }
}
```

---

## 🌐 7. JSP Views

### `index.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>User App</title>
</head>
<body>
    <h2>Welcome to User Management</h2>
    <ul>
        <li><a href="register.jsp">Register New User</a></li>
        <li><a href="user?action=list">View All Users</a></li>
    </ul>
</body>
</html>
```

---

### `register.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register User</title>
</head>
<body>
    <h2>User Registration Form</h2>

    <!-- Show error message if any -->
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <form method="post" action="user">
        <input type="hidden" name="action" value="register">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
```

---

### `success.jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h2>User Registered Successfully!</h2>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
```

---

### `users.jsp` (Using JSTL)

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>All Users</h2>

    <!-- Check if there are users -->
    <c:if test="${empty users}">
        <p>No users found.</p>
    </c:if>

    <!-- Display user list using JSTL -->
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
```

---

## 🧩 8. Deployment Descriptor (`web.xml`)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                             http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <display-name>UserApp</display-name>

    <!-- Welcome file -->
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file-list>
    </welcome-file-list>
</web-app>
```

---

## ✅ 9. Required Libraries

Add the following in `WEB-INF/lib` folder:

- `mysql-connector-java-8.0.xx.jar` – MySQL JDBC driver
- `jstl-1.2.jar` – JSTL library for JSP tags

---

## 🚀 10. Running the Application

1. Start Apache Tomcat server.
2. Deploy the project in Eclipse or manually.
3. Access the app at:  
   [http://localhost:8080/UserApp](http://localhost:8080/UserApp)

---

## 📌 Summary

| Component | Purpose |
|----------|---------|
| **JSP** | View layer (HTML + dynamic content) |
| **Servlet** | Controller (handle requests and responses) |
| **JDBC** | Model layer (database communication) |
| **JSTL** | Cleaner JSP code using standard tags |

---

## 📎 Tips

- Use **PreparedStatement** to avoid SQL injection.
- Always close database resources properly.
- Use **MVC Pattern**: Servlet → Controller, JSP → View, DAO → Model.
- Prefer **JSTL over scriptlets** for better readability and maintainability.

---

Would you like me to provide a downloadable WAR file or ZIP of this complete project?