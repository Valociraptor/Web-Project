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
	<h1><c:out value="${person.first_name}"/> <c:out value="${person.last_name}"/></h1>
	<h3>License Number: <c:out value="${person.license.number}"/></h3>
	<h3>State: <c:out value="${person.license.state}"/></h3>
	<h3>Expiration Date: <c:out value="${person.license.expiration_date}"/></h3>
</body>
</html>