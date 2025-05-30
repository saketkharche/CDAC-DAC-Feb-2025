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
		<caption>All Restaurants</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>City</th>
			<th>Description</th>

		</tr>
		<c:forEach var="restaurant" items="${requestScope.restaurant_list}">
			<tr>
				<td>${restaurant.id}</td>
				<td>${restaurant.name}</td>
				<td>${restaurant.city}</td>
				<td>${restaurant.description}</td>
				<c:url var="url" value="/restaurants/update_form" />
				<td><a href="${url}?id=${restaurant.id}">Update</a></td>
				<c:url var="url" value="/restaurants/delete_form" />
				<td><a href="${url}?id=${restaurant.id}">Delete</a></td>
			</tr>

		</c:forEach>

	</table>
	<h5 align="center">
		<c:url var="url" value="/restaurants/add_form" />
		<a href="${url}">Add New restaurant</a>
	</h5>
</body>
</html>