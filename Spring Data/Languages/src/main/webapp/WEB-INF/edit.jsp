<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<a href="/languages">Dashboard</a> | <a href="/languages/delete/${id}">Delete</a>
	<form:form method="POST" action="/languages/update/${id}" modelAttribute="language">
    <form:label path="name">Name
    <form:errors path="name"/>
    <form:input path="name" placeholder="${language.name}"/></form:label>
    
    <form:label path="creator">Creator
    <form:errors path="creator"/>
    <form:textarea path="creator" placeholder="${language.creator}"/></form:label>
    
    <form:label path="version">Version
    <form:errors path="version"/>
    <form:input path="version" placeholder="${language.version}"/></form:label>
    
    <form:hidden path="id"/>
     
    <input type="submit" value="Submit"/>
    
	</form:form>
</body>
</html>