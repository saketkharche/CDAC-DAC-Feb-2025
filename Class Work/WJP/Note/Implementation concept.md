
# Java Web Application with Spring Boot, JSP, Servlet, JDBC & JSTL in **Spring Tool Suite (STS)**

> 🎯 **Objective**: Build a complete Java web application using:
- **Spring Boot** (for quick setup and auto-configuration)
- **JDBC** (to interact with MySQL database)
- **Servlets** (manual control over request/response)
- **JSP** (for dynamic views)
- **JSTL** (for cleaner JSP logic)
- **Maven** (build system)

---

## 🧰 Tools Required

1. **Spring Tool Suite (STS)** – Eclipse-based IDE for Spring apps
2. **Java 11+**
3. **Apache Maven**
4. **MySQL Server 8. X**
5. **Tomcat Embedded Server** (via Spring Boot)

---

## 📁 Project Structure

```
UserManagementApp/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.userapp/
│   │   │       ├── UserAppApplication.java
│   │   │       ├── controller/
│   │   │       │   └── UserController.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       ├── dao/
│   │   │       │   └── UserDao.java
│   │   │       └── config/
│   │   │           └── WebConfig.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   │
│   └── webapp/
│       └── WEB-INF/
│           └── jsp/
│               ├── index.jsp
│               ├── register.jsp
│               ├── users.jsp
│               └── success.jsp
│
└── pom.xml
```

---

## ✅ Step-by-Step Implementation

---

### 🗃️ Step 1: Create New Spring Boot Project in STS

1. Open **Spring Tool Suite (STS)**
2. Go to `File > New > Spring Starter Project`
3. Fill project details:

| Field | Value |
|-------|-------|
| Name | `UserManagementApp` |
| Type | Maven |
| Packaging | Jar or War |
| Java Version | 11 |
| Language | Java |

4. Select dependencies:
   - Spring Web
   - Spring Data JPA (optional for JDBC)
   - Thymeleaf (for view rendering)
   - DevTools (for live reload)

Click **Finish**

---

### 📄 Step 2: Configure `pom.xml`

```xml
<!-- pom.xml -->
<project ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>UserManagementApp</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>UserManagementApp</name>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.5</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <dependencies>
        <!-- Spring Web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- JSP Support -->
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>

        <!-- JSTL Tag Library -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>

        <!-- MySQL JDBC Driver -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Spring Boot Dev Tools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <properties>
        <java.version>11</java.version>
    </properties>
</project>
```

---

### 🛠️ Step 3: Configure `application.properties`

```properties
# application.properties
server.port=8080

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JSP Configuration
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp

# Logging
logging.level.org.springframework.web=WARN
```

---

### 🧬 Step 4: Create Model Class (`User.java`)

```java
// src/main/java/com/example/userapp/model/User.java
package com.example.userapp.model;

public class User {
    private int id;
    private String name;
    private String email;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

---

### 💾 Step 5: Create DAO Layer (`UserDao.java`)

```java
// src/main/java/com/example/userapp/dao/UserDao.java
package com.example.userapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.userapp.model.User;

@Repository
public class UserDao {

    @Autowired
    private DataSource dataSource;

    // Add new user
    public boolean addUser(User user) {
        String sql = "INSERT INTO users(name, email) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetch all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
```

---

### 🔄 Step 6: Create Controller (`UserController.java`)

```java
// src/main/java/com/example/userapp/controller/UserController.java
package com.example.userapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.userapp.dao.UserDao;
import com.example.userapp.model.User;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String showIndexPage() {
        return "index"; // maps to /WEB-INF/jsp/index.jsp
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(User user) {
        if (userDao.addUser(user)) {
            return "redirect:/success"; // Redirect after POST
        } else {
            return "register"; // Try again
        }
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users); // For JSTL usage
        return "users";
    }

    @GetMapping("/success")
    public String registrationSuccess() {
        return "success";
    }
}
```

---

### 🌐 Step 7: Create JSP Views

#### `index.jsp`

```jsp
<%-- /src/main/webapp/WEB-INF/jsp/index.jsp --%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management App</title>
</head>
<body>
    <h2>Welcome to the User Management System</h2>
    <ul>
        <li><a href="/register">Register New User</a></li>
        <li><a href="/users">View All Users</a></li>
    </ul>
</body>
</html>
```

#### `register.jsp`

```jsp
<%-- /src/main/webapp/WEB-INF/jsp/register.jsp --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register User</title>
</head>
<body>
    <h2>User Registration Form</h2>

    <form:form action="/register" method="post" modelAttribute="user">
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" required="true"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" type="email" required="true"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Register"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
```

#### `users.jsp`

```jsp
<%-- /src/main/webapp/WEB-INF/jsp/users.jsp --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
</head>
<body>
    <h2>List of Registered Users</h2>

    <c:if test="${empty users}">
        <p>No users found.</p>
    </c:if>

    <c:if test="${not empty users}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <br/>
    <a href="/">Back to Home</a>
</body>
</html>
```

#### `success.jsp`

```jsp
<%-- /src/main/webapp/WEB-INF/jsp/success.jsp --%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <h2>User registered successfully!</h2>
    <a href="/users">View All Users</a> | <a href="/">Home</a>
</body>
</html>
```

---

### 🚀 Step 8: Run the Application

1. Right-click on your project → **Run As > Spring Boot App**
2. Open browser at: [http://localhost:8080](http://localhost:8080)

---

## 🧪 Step 9: Test Application

| URL | Description |
|-----|-------------|
| `http://localhost:8080` | Home Page |
| `http://localhost:8080/register` | Register New User |
| `http://localhost:8080/users` | View All Users |

---

## 📝 Notes & Tips

- Always use **PreparedStatement** to avoid SQL injection.
- Use **JSTL tags** instead of scriptlets (`<% %>`).
- Use **Thymeleaf** or **JSP + JSTL** for clean separation between HTML and Java code.
- Keep business logic in **DAO**, not in controllers.

---

