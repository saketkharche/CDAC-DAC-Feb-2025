<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Details Form</title>
</head>
<body>
<%--pageContext.setAttribute("user",request.getAttribute("user_details")) --%>
	<c:set var="user" value="${requestScope.user_details}" />
	<form action="update" method="post">
		<input type="hidden" name="id" value="${user.userId}" />
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Change Password</td>
				<td><input type="password" name="pass" value="${user.password}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Change Password" /></td>
			</tr>
		</table>
	</form>
</body>
</html>