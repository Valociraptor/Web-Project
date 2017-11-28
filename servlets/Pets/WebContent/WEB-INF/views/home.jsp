
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Pet</title>
</head>
<body>
    <form action="kitty" method="GET">
    	<h3>Make a Cat</h3>
    	<p>Name:<input type="text" name="name"></p>
    	<p>Breed:<input type="text" name="breed"></p>
    	<p>Weight:<input type="text" name="weight"></p>
    	<input type="submit" value="Submit">
    </form>

    
    <form action="doggy" method="GET">
    	 <h3>Make a Dog</h3>
    	<p>Name:<input type="text" name="name"></p>
    	<p>Breed:<input type="text" name="breed"></p>
    	<p>Weight:<input type="text" name="weight"></p>
    	<input type="submit" value="Submit">
    </form>
</body>
</html>