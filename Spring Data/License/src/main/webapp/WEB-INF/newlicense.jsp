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
	<h1>New License</h1>
	<p><form:errors path="license.*"/></p>
		<form:form method="POST" action="/licenses" modelAttribute="license">
		
         <form:select path="person">
			<c:forEach items="${persons}" var="person">
				<form:option value="${person}" label="${person.first_name}  ${person.last_name}" />
			</c:forEach>
         </form:select>
		
	    <form:label path="state">State : 
	    <form:errors path="state"/>
	    <form:input path="state"/></form:label>
	    
	    <form:label path="expiration_date">Expiration Date : 
	    <form:errors path="expiration_date"/>
	    <form:input type="date" path="expiration_date"/></form:label>
	    
	    <input type="submit" value="Create"/>
    
	</form:form>

</body>
</html>