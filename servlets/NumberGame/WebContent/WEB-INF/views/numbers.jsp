<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Integer guess = (Integer)session.getAttribute("guess"); %>
	<% Integer answer = (Integer)session.getAttribute("answer"); %>
	<% String highlow = (String)session.getAttribute("highlow"); %>

	<h1>Welcome to the Great Number Game!</h1>
	<h3>I am thinking of a number between 1 and 100...</h3>
	
	<p>Take a Guess:</p>
	<form action="" method="POST">
	<input type="text" name="guess">
	<input type="hidden" name="reset" value=0>
	<input type="submit" value="Submit">
	</form>
	
	
	
	<h2> <%= highlow %> </h2>
	
	
	
	
	<% if (guess == answer) {%>
	
		<h2>You got it! The correct number is <%= answer %>.  Would you like to start a new game?</h2>
		<form action="" method="POST">
		<input type="hidden" name="reset" value=1>
		<input type="hidden" name="guess" value=0>
		<input type="submit" value="Yeah!">
		</form>
	
	<% } %>
	

	
</body>
</html>