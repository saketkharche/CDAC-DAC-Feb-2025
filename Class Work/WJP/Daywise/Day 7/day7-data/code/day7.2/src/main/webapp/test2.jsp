<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From next page - Guess the o/p</h4>
	<h5>page scoped attribute - ${pageScope.product_price}</h5>
	<h5>request scoped attribute - ${requestScope.product_id}</h5>
	<h5>session scoped attribute - ${sessionScope.product_name}</h5>
	<h5>application scoped attribute - ${applicationScope.global_attr}</h5>
	<h5> param - ${param}</h5>
	<%-- pageContext.getSession().getId() --%>
	<h5> Session ID - ${pageContext.session.id}</h5>
	<%-- cookie based session id --%>
	<%-- cookie.get("JSESSIONID").getValue() --%>
	<h5>Cookie based  Session ID - ${cookie.JSESSIONID.value}</h5>
	<%--pageContext.getSession().getMaxInactiveInterval()--%>
	<h5>Session time out - ${pageContext.session.maxInactiveInterval}</h5>
</body>
</html>