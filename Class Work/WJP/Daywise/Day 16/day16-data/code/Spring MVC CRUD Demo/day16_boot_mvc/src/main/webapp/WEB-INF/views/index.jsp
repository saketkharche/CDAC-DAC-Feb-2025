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
	
	<h5>		
		<c:url var="abc" value="/restaurants/list" />
		<a href="${abc}">List All Restaurants</a>
	</h5>
</body>
</html>