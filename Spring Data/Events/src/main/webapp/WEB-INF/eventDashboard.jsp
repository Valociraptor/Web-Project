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
    	
   		<c:forEach items="${stateEvents}" var="event">
   		   	<tr>
	   			<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
	   			<td><fmt:formatDate value="${event.date}" type="both" pattern="MMMMM d', 'YYYY"></fmt:formatDate></td>
	   			<td><c:out value="${event.location}"/></td>
	   			<td><c:out value="${event.user.firstName}"/></td>	
	   			<td>
	    			<c:if test="${event.user == currentUser}">
	    				<a href="/events/${event.id}/edit">Edit</a>   <a href="events/${event.id}/delete">Delete</a>
	    			</c:if>
	    			
	    			<c:if test="${event.user != currentUser}">
	    			
		    			 <c:forEach items="${event.attendees}" var="attendee">			 
		    			 	<c:if test="${attendee == currentUser}">
		    			 		Attending! <a href="/events/${event.id}/cancel">Cancel</a>
								<c:set var="attending" value="True"/>
		    			 	</c:if>
		    			 </c:forEach>		
		    			 
	    			 	<c:if test="${attending != 'True'}">
							<a href="/events/${event.id}/join">Join</a>
	    			 	</c:if>		    			 
		
	    			</c:if>
	   			</td>  		
   			</tr>	
   		</c:forEach>	
    </table>
   
    <h3>Here are some out of state events: </h3>
    <table>
    	<tr>
    		<th>Name</th>
    		<th>Date</th>
    		<th>Location</th>
    		<th>Host</th>
    		<th>Action/Status</th>
    	</tr>
    	
    	<c:forEach items="${nonStateEvents}" var="event">
    		<tr>
    			<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
    			<td><fmt:formatDate value="${event.date}" type="both" pattern="MMMMM d', 'YYYY"></fmt:formatDate></td>
    			<td><c:out value="${event.location}"/></td>
    			<td><c:out value="${event.user.firstName}"/></td>	
    			<td>
	    			<c:if test="${event.user == currentUser}">
	    				<a href="/events/${event.id}/edit">Edit</a>   <a href="events/${event.id}/delete">Delete</a>
	    			</c:if>
	    			
	    				 <c:if test="${event.user != currentUser}">
	    					<c:set var="attending" value="False"/>
			    			 <c:forEach items="${event.attendees}" var="attendee">			 
			    			 	<c:if test="${attendee == currentUser}">
			    			 		Attending! <a href="/events/${event.id}/cancel">Cancel</a>
									<c:set var="attending" value="True"/>
			    			 	</c:if>
			    			 </c:forEach>		
		    			 
		    			 	<c:if test="${attending != 'True'}">
								<a href="/events/${event.id}/join">Join</a>
		    			 	</c:if>		    			 
 							<c:set var="attending" value="False"/>
	    			</c:if>
    			</td>  		
    		</tr>	
    	</c:forEach>
    	
    </table>    
   
    <h2>Create a new event</h2>
        <p><form:errors path="event.*"/></p>
    
    <form:form method="POST" action="/events/new" modelAttribute="event">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
        </p>
         <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
        </p>             
        
         <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
            
         <form:select path="state">
			<c:forEach items="${states}" var="state">
				<form:option value="${state}" label="${state}" />
			</c:forEach>
         </form:select>           
        </p>              
        
        <form:hidden path="user" value="${currentUser.id}"></form:hidden>
        <input type="submit" value="Create!"/>
    </form:form> 
    
</body>
</html>