<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
    <h2>Add New Book</h2>
    <form action="BookController?action=insert" method="post">
        <label>Book ID:</label><input type="number" name="bookId" required><br><br>
        <label>Title:</label><input type="text" name="title" required><br><br>
        <label>Author:</label><input type="text" name="author" required><br><br>
        <label>Genre:</label><input type="text" name="genre" required><br><br>
        <label>Publication Year:</label><input type="number" name="year" required><br><br>
        <input type="submit" value="Add Book">
    </form>
    <br>
    <a href="BookController">View All Books</a>
</body>
</html>
