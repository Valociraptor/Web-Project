<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	
	<h2>Hosted By: <c:out value="${event.user.firstName}"/></h2>
	<h2>Date: <fmt:formatDate value="${event.date}" type="both" pattern="MMMMM d', 'YYYY"></fmt:formatDate></h2>
	<h2>Location: <c:out value="${event.location}"/>, <c:out value="${event.state}"/></h2>
	<h2>Attendees:</h2>
	<ul>
		<c:forEach items="${event.attendees}" var="attendee">
			<li><c:out value="${attendee.firstName}"/> <c:out value="${attendee.lastName}"/> from <c:out value="${attendee.location}"/>, <c:out value="${attendee.state}"/></li>
		</c:forEach>
	
	</ul>
	
	<h3>Message Wall</h3>
	<c:forEach items="${event.messages}" var="message">
		<p><c:out value="${message.user.firstName}"/> says:  <c:out value="${message.comment}"/></p>
		<p>------------------------</p>	
	</c:forEach>
	
	<p><form:errors path="message.*"/></p>
	    <form:form method="POST" action="/events/${event.id}/newmessage" modelAttribute="message">
	        <p>
	            <form:label path="comment">Comment:</form:label>
	            <form:input path="comment" />
	        </p>

             
	        <form:hidden path="event" value="${event.id}"></form:hidden>
	        <form:hidden path="user" value="${currentUser.id}"></form:hidden>
	        <input type="submit" value="Update!"/>
    	</form:form>
	
</body>
</html>