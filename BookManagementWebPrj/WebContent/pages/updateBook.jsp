<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="page" class="center">
		<div id="main">
			<div id="content">
				<div id="form">
					<h2>Update Book</h2>
					<form name="update-book"
						action="<%=request.getContextPath()%>/BookServlet" method="post">
						<input type="hidden" id="page" name="page" value="updateBookPage">
						<label for="bookid">ID</label><br> <input type="text"
							name="bookid"><br>
						<br> <label for="name">Book Name</label><br> <input
							type="text" name="name"><br>
						<br> <label for="category">Book Category</label><br> <input
							type="text" name="category"><br>
						<br> <input type="submit" value="Update Book">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>