<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From 1st page ....</h5>
	<%
	pageContext.setAttribute("nm", 123456);
	 request.setAttribute("product_details",
			 request.getParameter("pid")+" "+request.getParameter("price"));
	 out.flush();
	%>
	<jsp:include page="test8.jsp">
		<jsp:param value="Head First Java" name="product_name" />
	</jsp:include>
</body>
</html>