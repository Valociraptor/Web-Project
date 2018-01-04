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
	<a href="/bright_ideas">Bright Ideas</a><br><br>
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    <h3><a href="/users/${idea.user.id}"><c:out value="${idea.user.username}"/></a> says:  
    <c:out value="${idea.text}"/></h3>
    
    <h4>People who liked this post</h4>
	<table>
	    <tr>
	    	<th>Alias</th>
	    	<th>Name</th>
	    </tr>


    	<c:forEach items="${idea.likers}" var="liker">
    		<tr>
    			<td><c:out value="${liker.username}"/>
    			<td><a href="/users/${liker.id}"><c:out value="${liker.name}"/></a>
    		</tr>
    	
    	</c:forEach>
    </table>

</body>
</html>