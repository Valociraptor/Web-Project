<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <c:out value="${currentUser.firstName}"/> !</h1>	
	
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h3>Here are some of the events in your state: </h3>
    <table>
    	<tr>
    		<th>Name</th>
    		<th>Date</th>
    		<th>Location</th>
    		<th>Host</th>
    		<th>Action/Status</th>
    	</tr>
    	
    	<tr>
    		<c:forEach items="${stateEvents}" var="event">
    			<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
    			<td><fmt:formatDate value="${event.date} type="both pattern="MMMMM d', 'YYYY"></fmt:formatDate></td>
    			<td><c:out value="${event.location}"/></td>
    			<td><c:out value="${event.host.name}"/></td>	
    			<td>
	    			<c:if test="${event.host == to currentUser}">
	    				<a href="events/${event.id}/edit">Edit</a>   <a href="events/${event.id}/delete">Delete</a>
	    			</c:if>
	    			
	    			<c:if test="${event.host != to currentUser}">
		    			 <c:forEach items="${event.attendees} var="attendee">
		    			 	<c:if test="${attendee != to currentUser}">
		    			 		<c:set var="attending" value=false/>
		    			 	</c:if>
		    			 </c:forEach>
	    			 
		    			 <c:choose>
		    			 	<c:when test="${attending = false}">
		    					<a href="events/${event.id}/join">Join</a> 
		    				</c:when>
		    				
		    				<c:otherwise>
		    					Attending! <a href="events/${event.id}/cancel">Cancel</a> 
		    				</c:otherwise>
	    				</c:choose>
	    			</c:if>
    			</td>  			
    		</c:forEach>
    	</tr>
    </table>
    
    
</body>
</html>