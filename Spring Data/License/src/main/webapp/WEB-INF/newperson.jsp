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
	<h1>New Person</h1>
	<p><form:errors path="person.*"/></p>
		<form:form method="POST" action="/persons" modelAttribute="person">
	    <form:label path="first_name">First Name : 
	    <form:errors path="first_name"/>
	    <form:input path="first_name"/></form:label>
	    
	    <form:label path="last_name">Last Name : 
	    <form:errors path="last_name"/>
	    <form:input path="last_name"/></form:label>
	    
	    <input type="submit" value="Create"/>
	    
	</form:form>
</body>
</html>