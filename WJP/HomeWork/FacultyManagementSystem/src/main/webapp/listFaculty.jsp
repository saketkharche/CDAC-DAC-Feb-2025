<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*, com.faculty.dao.FacultyDAO, com.faculty.model.Faculty" %>
<a href="addFaculty.jsp">Add Faculty</a>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Dept</th><th>Email</th><th>Qual</th><th>Action</th></tr>
    <%
        List<Faculty> list = new FacultyDAO().getAllFaculty();
        for (Faculty f : list) {
    %>
    <tr>
        <td><%= f.getId() %></td>
        <td><%= f.getName() %></td>
        <td><%= f.getDepartment() %></td>
        <td><%= f.getEmail() %></td>
        <td><%= f.getQualification() %></td>
        <td>
            <a href="editFaculty?id=<%= f.getId() %>">Edit</a> |
            <a href="deleteFaculty?id=<%= f.getId() %>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>