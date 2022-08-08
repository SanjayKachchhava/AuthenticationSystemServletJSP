<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="./css/home.css" rel="stylesheet" type="text/css">
</head>
<body>
	<% 
	
		if(session.getAttribute("email")==null){
			response.sendRedirect("login");
		}
	
	%>

	<h1 class="title">Home Page!!</h1> <br>
	<% 
	
		//out.println(session.getAttribute("email"));
	
	%>
	<br>
	<form class="form" action="logout" method="post">
		<input class="submit" type="submit" value="logout">
	</form>
	
	
</body>
</html>