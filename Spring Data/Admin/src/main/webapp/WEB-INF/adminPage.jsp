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
    <h1>Welcome to the Admin Page <c:out value="${currentUser.firstName}"></c:out></h1>
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <table>
    	<tr>
    		
    	<th>Name</th>
    	<th>Email</th>
    	<th>Action</th>
	    	
    	</tr>
    	
    	<c:forEach items="${ users}" var="user">
    	<tr>
    	<td><c:out value="${user.firstName }"/> <c:out value="${user.lastName }"/></td>
    	<td><c:out value="${user.username}"/></td>
    	
    	<c:if test="${user.isAdmin}">
    	<td>ADMIN</td>
    	</c:if>
    	<c:if test="${!user.isAdmin}">
    	<td><a href="/admin/delete/${user.id}">Delete</a>  <a href="/admin/makeAdmin/${user.id}">Make Admin</a></td>
    	</c:if>
    	
    	</tr>
    	</c:forEach>
    
    </table>
</body>
</html>