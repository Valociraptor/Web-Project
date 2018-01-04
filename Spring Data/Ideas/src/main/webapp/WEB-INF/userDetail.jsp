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
	<a href="/bright_ideas">Bright Ideas</a><br><br>
	
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h2>Name: <c:out value="${user.name}"/></h2>
    <h2>Alias: <c:out value="${user.username}"/></h2>
    <h2>Email: <c:out value="${user.email}"/></h2>
    <hr>
    <h2>Total Number of Posts: <c:out value="${user.ideas.size()}"/></h2>
    <h2>Total Number of Likes: <c:out value="${user.likeCount}"/></h2>
</body>
</html>