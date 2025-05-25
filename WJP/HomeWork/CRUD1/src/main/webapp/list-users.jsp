<%@ page import="java.util.*, com.crud.model.User" %>
<html><body>
<h2>User List</h2>
<a href="new">Add New User</a><br><br>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
<%
    List<User> users = (List<User>) request.getAttribute("listUsers");
    for (User user : users) {
%>
<tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td>
        <a href="edit?id=<%= user.getId() %>">Edit</a>
        <a href="delete?id=<%= user.getId() %>">Delete</a>
    </td>
</tr>
<% } %>
</table>
</body></html>
