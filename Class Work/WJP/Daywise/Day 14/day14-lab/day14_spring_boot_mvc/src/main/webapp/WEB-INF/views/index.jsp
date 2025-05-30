<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Welcome to Spring MVC .....</h4>
	<h5>
		<%--http://host:port/ctx_path/test/test1;jsessionid=SDFAD4545654FGS --%>
		<c:url var="abc" value="/test/test1" />
		<a href="${abc}">Test ModelAndView</a>
	</h5>
	<h5>
		<%--http://host:port/ctx_path/test/test2;jsessionid=......--%>
		<c:url var="abc" value="/test/test2" />
		<a href="${abc}">Test Model Map</a>
	</h5>
	
	<h5>
		
		<c:url var="abc" value="/restaurants/list" />
		<a href="${abc}">List All Restaurants</a>
	</h5>
</body>
</html>