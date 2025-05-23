<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- pageContext.getException().getMessage() --%>
<h5 style="color: red;">Error Message - ${pageContext.exception.message} </h5>
<h5 style="color: red;">Error Class n message  -${pageContext.exception} </h5>
<h5 style="color: red;">URI of Error causing page - ${pageContext.errorData.requestURI}</h5>
<h5 style="color: red;">Error Code - ${pageContext.errorData.statusCode}</h5>



</body>
</html>