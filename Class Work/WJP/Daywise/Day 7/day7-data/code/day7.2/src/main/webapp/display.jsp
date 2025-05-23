<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 align="center">
		Session ID -<%=session.getId()%>
	</h5>
	<h3>User Details via Scriptlet</h3>
	<%
	//plain old java code - doXXX - scriptlet
	String email = request.getParameter("em");
	String password = request.getParameter("pass");
	out.print("<h4> Email " + email + "</h4>");
	out.print("<h4> Password " + password + "</h4>");
	//adding an attribute under current page
	pageContext.setAttribute("nm", 12345);
	%>
	<hr />
	<h3>User Details via Expression</h3>
	<h4>
		Email -
		<%=request.getParameter("em")%></h4>
	<h4>
		Password -
		<%=request.getParameter("pass")%></h4>
	<hr />
	<h4>EL syntax examples</h4>
	<h5>param - ${param}</h5>
	<%--pageScope map of page scoped attributes --%>
	<h5>Page scoped attribute ${pageScope.nm}</h5>
</body>
</html>