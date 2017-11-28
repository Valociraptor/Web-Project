<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Process" method="GET">
		<input type="submit" value="Click Me!">
	</form>
	
	<% Integer ticky = (Integer) session.getAttribute("count"); %>

	<h2>You have clicked this button <%= ticky %> times!</h2>
</body>
</html>