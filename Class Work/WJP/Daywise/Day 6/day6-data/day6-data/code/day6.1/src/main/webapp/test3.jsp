<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	int visits;//instance var
	//instance method

	int incrementVisits() {
		System.out.println("in incr visits");
		return ++visits;
	}

	public void jspInit() {
		System.out.println(" in init  ");
	}%>
<body>
	<%
	System.out.println("from scriptlet - " + Thread.currentThread());
	%>
	<h5>Visits - <%= incrementVisits() %></h5>
</body>
<%!public void jspDestroy() {
		System.out.println(" in destroy  ");
	}%>
</html>