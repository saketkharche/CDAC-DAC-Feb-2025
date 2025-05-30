<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Restaurant Details</title>
</head>

<body>
	<h5 align="center" style="color: red;">${requestScope.mesg}</h5>

	<form:form method="post" modelAttribute="restaurant">

		<table style="background-color: lightgrey; margin: auto">

			<tr>
				<td> Restaurant Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td> Description</td>
				<td><form:textarea path="description" /></td>
			</tr>
			<tr>
				<td> City</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td> Address</td>
				<td><form:textarea path="address" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Resaturant Details" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>