
We'll use the **Student Management System** you already know from JDBC, now enhanced with:

- **Servlet as Controller**
    
- **JSP as View**
    
- **POJO and DAO for Model**
    
- **JDBC for DB Access**
    

---

## 📁 Project Folder Structure (STS Web App)

```
StudentWebApp/
├── src/
│   ├── controller/           ← Servlet classes
│   ├── dao/                  ← DAO Interface & Implementation
│   ├── model/                ← POJO
│   └── util/                 ← DBConnection
├── WebContent/
│   ├── WEB-INF/
│   │   ├── web.xml
│   │   └── views/            ← JSP Pages
│   ├── index.jsp             ← Home Page
```

---

## ✅ 1. `Student.java` – POJO (`model/`)

```java
package model;

public class Student {
    private int id;
    private String name;
    private String email;

    public Student() {}

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
}
```

---

## ✅ 2. `DBConnection.java` – Utility (`util/`)

```java
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

---

## ✅ 3. `StudentDAO.java` – DAO Interface (`dao/`)

```java
package dao;

import java.util.List;
import model.Student;

public interface StudentDAO {
    void insert(Student student);
    List<Student> getAll();
}
```

---

## ✅ 4. `StudentDAOImpl.java` – DAO Implementation (`dao/`)

```java
package dao;

import model.Student;
import util.DBConnection;

import java.sql.*;
import java.util.*;

public class StudentDAOImpl implements StudentDAO {
    private Connection conn = DBConnection.getConnection();

    public void insert(Student s) {
        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
```

---

## ✅ 5. `StudentServlet.java` – Servlet Controller (`controller/`)

```java
package controller;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Retrieve student list from DB
        List<Student> students = dao.getAll();
        
        // Store list in request scope
        req.setAttribute("studentList", students);

        // Forward to JSP (View)
        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/students.jsp");
        rd.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Get form parameters
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        // Create student object
        Student s = new Student(name, email);

        // Save to DB
        dao.insert(s);

        // Redirect to doGet
        res.sendRedirect("students");
    }
}
```

---

## ✅ 6. `students.jsp` – JSP View (`WEB-INF/views/`)

```jsp
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Student List</title></head>
<body>
<h2>Add Student</h2>
<form action="students" method="post">
    Name: <input type="text" name="name" required><br>
    Email: <input type="text" name="email" required><br>
    <input type="submit" value="Add Student">
</form>

<h2>Student List</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th></tr>
    <c:forEach var="s" items="${studentList}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
```

✅ Add JSTL support in web.xml or at top:

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

---

## ✅ 7. `web.xml` – Deployment Descriptor

```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" version="3.1">
    <display-name>Student Web App</display-name>
    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>
```

---

## ✅ 8. `index.jsp` – Landing Page

```jsp
<html>
<head><title>Welcome</title></head>
<body>
<h2>Welcome to Student Management System</h2>
<a href="students">View Students</a>
</body>
</html>
```

---

## 💡 Notes for STS Setup

1. Create **Dynamic Web Project**.
    
2. Add **Apache Tomcat** via STS Server tab.
    
3. Place JSPs under `WebContent/WEB-INF/views`.
    
4. Place Servlets in `src/controller`.
    
5. Add **MySQL Connector JAR** to `lib`.
    

---

