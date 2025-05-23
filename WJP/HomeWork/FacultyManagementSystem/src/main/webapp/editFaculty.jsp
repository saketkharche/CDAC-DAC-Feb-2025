<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.faculty.model.Faculty" %>
<%
    Faculty f = (Faculty) request.getAttribute("faculty");
%>
<form action="updateFaculty" method="post">
    <input type="hidden" name="id" value="<%= f.getId() %>">
    Name: <input type="text" name="name" value="<%= f.getName() %>" required><br/>
    Department: <input type="text" name="department" value="<%= f.getDepartment() %>" required><br/>
    Email: <input type="email" name="email" value="<%= f.getEmail() %>" required><br/>
    Qualification: <input type="text" name="qualification" value="<%= f.getQualification() %>" required><br/>
    <input type="submit" value="Update">
</form>

</body>
</html>