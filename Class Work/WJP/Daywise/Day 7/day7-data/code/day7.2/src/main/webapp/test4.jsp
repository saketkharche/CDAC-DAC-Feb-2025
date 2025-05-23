<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int a = 1234;
	int b = 0;
	int result = a / b;//will be declared within _jspService => local var.
	%>
	<h5>
		Result -
		<%=result%></h5>
</body>
</html>