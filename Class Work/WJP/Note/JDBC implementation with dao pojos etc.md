Here’s a complete guide to implementing **JDBC with DAO and POJO layers** in a clean **MVC structure**, using a simple **Student Management System** as an example.

---

# 📘 JDBC Implementation with DAO, POJO, MVC (Student Management System)

---

## ✅ Project Structure

```
StudentApp/
├── model/              ← POJO (Student.java)
├── dao/                ← Data Access (StudentDAO.java, Impl)
├── util/               ← DB Utility (DBConnection.java)
├── main/               ← Main or Controller class
└── db/                 ← SQL file for table creation
```

---

## 1️⃣ Create the MySQL Database & Table

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50)
);
```

---

## 2️⃣ POJO: `Student.java` (in `model` package)

```java
package model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String course;

    // Constructors
    public Student() {}
    public Student(String name, String email, String course) {
        this.name = name;
        this.email = email;
        this.course = course;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}
```

---

## 3️⃣ DB Connection Utility: `DBConnection.java` (in `util` package)

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

## 4️⃣ DAO Interface: `StudentDAO.java` (in `dao` package)

```java
package dao;

import model.Student;
import java.util.List;

public interface StudentDAO {
    void insertStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
```

---

## 5️⃣ DAO Implementation: `StudentDAOImpl.java` (in `dao` package)

```java
package dao;

import model.Student;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Connection conn = DBConnection.getConnection();

    @Override
    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, email=?, course=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 6️⃣ Controller/Main App: `MainApp.java` (for testing)

```java
import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Student;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAOImpl();

        // INSERT
        Student s1 = new Student("Saket", "saket@gmail.com", "Java");
        dao.insertStudent(s1);

        // GET ALL
        List<Student> students = dao.getAllStudents();
        for (Student s : students) {
            System.out.println(s.getId() + " " + s.getName());
        }

        // UPDATE
        Student existing = dao.getStudentById(1);
        existing.setCourse("Advanced Java");
        dao.updateStudent(existing);

        // DELETE
        dao.deleteStudent(2);
    }
}
```

---

## ✅ Summary

|Layer|File|Purpose|
|---|---|---|
|DB|`students` table|Store student records|
|POJO|`Student.java`|Data model|
|DAO|`StudentDAO`, `StudentDAOImpl`|Encapsulate SQL logic|
|Utility|`DBConnection.java`|Database connection|
|Controller|`MainApp.java`|Handles logic flow|

---

### 📦 Next Steps

Would you like me to:

- Share a **ZIP folder of the full project**?
    
- Add a **Servlet + JSP frontend** to this project?
    
- Convert this into a **web app with MVC architecture**?
    

Let me know and I’ll help you set that up!