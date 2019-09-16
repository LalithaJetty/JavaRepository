<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.beans.Book"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Search Books</title>
</head>
<body>
	
	<div id="page" class="center">
		<div id="main">
			<div id="content">
				<div id="form">
					<h2>Search Books</h2>
					<form name="search-book"
						action="<%=request.getContextPath()%>/BookServlet" method="post">
						<input type="hidden" id="page" name="page" value="searchBook">
						<input type="text" name="category"> 
						<input type="submit" value="Search Book"> <br>
						<br><br>
						<table name="search-results" border="1">
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Category</th>
							</tr>
							<%
							List<Book> bookList = (List<Book>) request.getAttribute("bList");
							if(bookList != null) {
								
								for(Book book: bookList) {
						%>
							<tr>
								<td><%= book.getBookId() %></td>
								<td><%= book.getBookName() %></td>
								<td><%= book.getCategory() %></td>
							</tr>


							<%
								}
							}
						%>
						</table>

					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
