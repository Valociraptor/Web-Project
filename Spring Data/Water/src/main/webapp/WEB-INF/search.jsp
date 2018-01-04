<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/registration">Login/Signup</a>
	<h2>Find a nice place to drown!</h2>
	

    <form method="POST" action="/search">
        <p>
            <label for="search">Location</label>
            <input path="search" placeholder="City"/>
        </p>

        <input type="submit" value="Look!"/>
    </form>
	
</body>
</html>