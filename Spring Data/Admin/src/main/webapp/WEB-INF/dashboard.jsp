<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <c:out value="${currentUser.firstName}"/> !</h1>
	<h3>First Name: <c:out value="${currentUser.firstName}"/></h3>
	<h3>Last Name: <c:out value="${currentUser.lastName}"/></h3>
	<h3>Email: <c:out value="${currentUser.username}"/></h3>
	<h3>Sign Up Date: <c:out value="${currentUser.createdAt}"/></h3>
	<h3>Last Sign In: <c:out value="${currentUser.updatedAt}"/></h3>
	
	
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>