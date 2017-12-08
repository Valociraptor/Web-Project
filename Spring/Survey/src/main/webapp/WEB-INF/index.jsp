<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/" method="POST">
	<p>Your Name: <input type="text" name="name"></p>
	
	<p>Location: <select name="location">
	  <option value="Here">Here</option>
	  <option value="There">There</option>
	  <option value="Everywhere">Everywhere</option>
	</select></p>
	
	<p>Language: <select name="language">
	  <option value="Love">Love</option>
	  <option value="Java">Java</option>
	  <option value="Esperanto">Esperanto</option>
	</select></p>
	
	<p>Comment: <textarea name="comment"></textarea></p>
	
	<input type="submit" value="Submit">
	
	</form>
</body>
</html>