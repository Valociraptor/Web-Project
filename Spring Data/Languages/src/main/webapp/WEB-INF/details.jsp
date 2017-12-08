<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<a href="/languages">Dashboard</a>
	
	<h3>Name: <c:out value="${language.name}"/></h3>
	<h3>Creator: <c:out value="${language.creator}"/></h3>
	<h3>Version: <c:out value="${language.version}"/></h3>
	<h3>Created At: <c:out value="${language.createdAt}"/></h3>
	<h3>Updated At: <c:out value="${language.updatedAt}"/></h3>
	
	<a href="/languages/delete/${id}">Delete</a> | <a href="/languages/edit/${id}">Edit</a>
</body>
</html>