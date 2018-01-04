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
	<h1><c:out value="${event.name}"/></h1>
	
	<h3>Edit Event</h3>
	<p><form:errors path="event.*"/></p>
	    <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" value="${event.name}"/>
        </p>
         <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date" value="${event.date}"/>
        </p>             
        
         <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location" value="${event.location}"/>
            
         <form:select path="state" value="${event.state}">
			<c:forEach items="${states}" var="state">
				<form:option value="${state}" label="${state}" />
			</c:forEach>
         </form:select>           
        </p>              
        <form:hidden path="id" value="${id}"></form:hidden>
        <form:hidden path="user" value="${currentUser.id}"></form:hidden>
        <input type="submit" value="Update!"/>
    </form:form>
</body>
</html>