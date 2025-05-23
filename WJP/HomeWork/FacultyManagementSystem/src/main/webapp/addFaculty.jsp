<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addFaculty" method="post">
    ID: <input type="number" name="id" required><br/>
    Name: <input type="text" name="name" required><br/>
    Department: <input type="text" name="department" required><br/>
    Email: <input type="email" name="email" required><br/>
    Qualification: <input type="text" name="qualification" required><br/>
    <input type="submit" value="Add Faculty">
</form>

</body>
</html>