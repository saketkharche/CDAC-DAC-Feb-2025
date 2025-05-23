<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Successful Login!</h4>
	<h5>Your Details - ${sessionScope.user_details}</h5>
	<%
	 String encUrl=response.encodeURL("logout.jsp");
	%>
	<h5>
		<a href="<%= encUrl%>">Log Me Out</a>
	</h5>
</body>
</html>