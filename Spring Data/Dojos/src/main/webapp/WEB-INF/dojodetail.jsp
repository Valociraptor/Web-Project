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
	<h1><c:out value="${dojo.name}"/> Ninjas</h1>
	<ul>
	<c:forEach items="${ninjas}" var="ninja">
	<li><c:out value="${ninja.name}"/>, Age <c:out value="${ninja.age}"/>, Joined At: <c:out value="${ninja.createdAt}"/></li>
	</c:forEach>
	</ul>
</body>
</html>