<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>param - ${param}</h5>
	<h5>Price - ${param.price}</h5>
	<%
	pageContext.setAttribute
	("product_price", request.getParameter("price"));
	session.setAttribute("product_name",request.getParameter("nm"));
	request.setAttribute("product_id",request.getParameter("pid"));
	application.setAttribute("global_attr", 23456);
	//redirect
	response.sendRedirect("test2.jsp?category=stationary");//clnt pull
	%>
</body>
</html>