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
	<form:form method="POST" action="/songs/new" modelAttribute="song">
    <form:label path="Title">Title: 
    <form:errors path="Title"/>
    <form:input path="Title"/></form:label>
    
    <form:label path="Artist">Artist: 
    <form:errors path="Artist"/>
    <form:textarea path="Artist"/></form:label>
    
    <form:label path="Rating">Rating (1-10): 
    <form:errors path="Rating"/>
    <form:input type ="number" path="Rating"/></form:label>
    
    <input type="submit" value="Submit"/>
    
	</form:form>
</body>
</html>