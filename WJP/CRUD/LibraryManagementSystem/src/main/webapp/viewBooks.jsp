<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*,com.library.model.Book" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h2>Library Book List</h2>
    <a href="addBook.jsp">Add New Book</a>
    <br><br>
    <table border="1" cellpadding="10">
        <tr>
            <th>Book ID</th><th>Title</th><th>Author</th><th>Genre</th><th>Year</th><th>Actions</th>
        </tr>
        <%
            List<Book> books = (List<Book>) request.getAttribute("bookList");
            if (books != null && !books.isEmpty()) {
                for (Book b : books) {
        %>
        <tr>
            <td><%= b.getBookId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getGenre() %></td>
            <td><%= b.getPublicationYear() %></td>
            <td>
                <a href="BookController?action=edit&id=<%= b.getBookId() %>">Edit</a> |
                <a href="BookController?action=delete&id=<%= b.getBookId() %>" onclick="return confirm('Delete this book?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="6">No books found!</td></tr>
        <% } %>
    </table>
</body>
</html>
