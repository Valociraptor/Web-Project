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
	<h1>Submitted Info</h1>
	
	<p>Name: <c:out value="${name }"/></p> 
	<p>Location: <c:out value="${location }"/></p>
	<p>Language: <c:out value="${language }"/></p>
	<p>Comment: <c:out value="${comment }"/></p>
</body>
</html>