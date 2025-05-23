<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!String message1 = "some message!";//private instance var.%>
<body>
	<%
	String message2 = "some message 2";//local var - _jspService
	pageContext.setAttribute("message3", "some message 3");//page scoped attr
	%>
	<%@ include file="test6.jsp"%>
</body>
</html>