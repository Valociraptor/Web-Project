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
	<h1>What is your question?</h1>
	
	<form:form method="POST" action="/questions/add" modelAttribute="questionModel">
	    <form:label path="question">Question : 
	    <form:errors path="question"/>
	    <form:input path="question"/></form:label>
	    
	    <form:label path="tags">Tags (Up to 3) : 
	    <form:errors path="tags"/>
	    <form:input path="tags"/></form:label>
	    
	    
	    <input type="submit" value="Submit"/>
	    
	</form:form>
</body>
</html>