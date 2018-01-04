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
	<h2>Current Listings</h2>
	<a href="/logout">Logout</a>
	
	<table>
		<tr>
			<th>Address     </th>
			<th>Pool Size     </th>
			<th>Cost Per Night     </th>
			<th>Details     </th>
		</tr>
		<c:forEach items="${listings}" var="listing">
			<tr>
				<td><c:out value="${listing.address}"/>, <c:out value="${listing.location}"/>, <c:out value="${listing.state}"/> <c:out value="${listing.zipcode}"/></td>
				<td><c:out value="${listing.poolSize}"/></td>
				<td><c:out value="${listing.cost}"/></td>
				<td><a href="/listingDetails">Details</a>
					<c:if test="${currentUser.isHost}">
						<a href="/host/listing/${currentUser.id}">Edit</a>
					</c:if>								
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:if test="${currentUser.isHost}">
		    <p><form:errors path="event.*"/></p>
    
    <form:form method="POST" action="/newListing" modelAttribute="listing">
        <p>
            <form:label path="address">Street Address:</form:label>
            <form:input type="address" path="address"/>
        </p>
         <p>
            <form:label path="location">City:</form:label>
            <form:input path="location"/>
            
            <form:select path="state">
			<c:forEach items="${states}" var="state">
				<form:option value="${state}" label="${state}" />
			</c:forEach>
         	</form:select>  
        </p>             
        
        <p>
            <form:label path="zipcode">ZipCode:</form:label>
            <form:password path="zipcode"/>
        </p>
        <p>
            <form:label path="desc">Description:</form:label>
            <form:password path="desc"/>
        </p>
        <p>
        
        <p>
            <form:label path="cost">Cost Per Night:</form:label>
            <form:password path="cost"/>
        </p>
        <p>
            <form:label path="cost">Cost Per Night:</form:label>
            <form:password path="cost"/>
            
            <form:select path="poolSize">
			
				<form:option value="Small" label="poolSize" />
				<form:option value="Medium" label="poolSize" />
				<form:option value="Large" label="poolSize" />
			
         	</form:select>  
        </p>
        <form:hidden path="user" value="${currentUser.id}"></form:hidden>
        <input type="submit" value="Add Listing!"/>
    </form:form>
	</c:if>			
</body>
</html>