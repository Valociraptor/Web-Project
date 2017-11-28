<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Integer ticky = (Integer) session.getAttribute("count"); %>
	<% String wordy = (String) session.getAttribute("word"); %>
	<% String timey =  (String) session.getAttribute("time"); %>
	
	<h2>You have clicked this button <%= ticky %> times!</h2>
	
	<h1><%= wordy %></h1>
	
	<form action="Process" method="GET">
		<input type="submit" value="Click Me!">
	</form>
	
	<h2>The last time you generated a word was:</h2>
	<h3><%= timey %></h3>

	<h2>You have clicked this button <%= ticky %> times!</h2>
</body>
</html>