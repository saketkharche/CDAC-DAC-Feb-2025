<%@ page import="com.crud.model.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html><body>
<h2>Edit User</h2>
<form action="update" method="post">
    <input type="hidden" name="id" value="<%= user.getId() %>"/>
    Name: <input type="text" name="name" value="<%= user.getName() %>"/><br/>
    Email: <input type="text" name="email" value="<%= user.getEmail() %>"/><br/>
    <input type="submit" value="Update"/>
</form>
</body></html>
