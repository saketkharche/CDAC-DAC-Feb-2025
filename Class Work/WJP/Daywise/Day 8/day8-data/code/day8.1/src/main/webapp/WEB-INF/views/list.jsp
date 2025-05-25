<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto">
		<caption>All Users</caption>
		<tr>
			<th>User ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>DoB</th>
			<th>Voting Status</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach var="user" items="${requestScope.user_list}">
			<tr>
				<td>${user.userId}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.dob}</td>
				<td>${user.status}</td>
				<td><a href="update_form?id=${user.userId}">Update</a></td>
				<td><a href="delete?id=${user.userId}">Delete</a></td>
			</tr>

		</c:forEach>

	</table>
	<h5 align="center">
		<a href="add_user_form">Add New User</a>
	</h5>
</body>
</html>