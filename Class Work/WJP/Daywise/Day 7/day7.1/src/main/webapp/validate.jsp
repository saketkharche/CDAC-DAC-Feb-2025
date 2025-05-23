<%@page import="com.cdac.pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block - scope - private (only curnt page can access it)
	HashMap<String, User> users;

	public void jspInit() {
		System.out.println("in init");
		users = new HashMap<>();
		users.put("rama@gmail.com", new User("rama@gmail.com", "12345", "Rama Patil", 30));
		users.put("mihir@gmail.com", new User("mihir@gmail.com", "2345", "Mihir Sen", 25));
	}%>
<body>
	<%
	//JSP scriptlet for user authentication
	//1. get email n pwd
	String email = request.getParameter("em");
	String pwd = request.getParameter("pass");
	//2. validate - get
	User user = users.get(email);
	//3. null chking
	if (user != null) {
		//=> email valid -> chk password
		if (user.getPassword().equals(pwd)) {
			//=> login valid , store user details - session scope
			session.setAttribute("user_details", user);
			//apply URL rewriting - encodeRedirectURL
			response
			.sendRedirect(
					response.encodeRedirectURL("details.jsp"));//CP

		} else {
			//=> invalid pwd
			out.write("<h5> Invalid Password , Please <a href='login.jsp'>Retry</a></h5>");
		}
	} else {
		// invalid email
		out.write("<h5> Invalid Email , Please <a href='login.jsp'>Retry</a></h5>");

	}
	%>
</body>
</html>