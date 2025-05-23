<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5 align="center">Session ID -<%= session.getId() %> </h5>
	<h4>
		Welcome to JSP ,
		<%=LocalDateTime.now()%>
	</h4>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Test Scripting elements</a>
	</h5>
	<h5>
		<a href="test1.jsp?pid=123&nm=pen&price=50">EL syntax examples</a>
	</h5>
	<h5>
		<a href="test3.jsp">Test JSP Declaration</a>
	</h5>
	<h5>
		<a href="test4.jsp">Test Error Handling in JSP</a>
	</h5>
	
</body>
</html>