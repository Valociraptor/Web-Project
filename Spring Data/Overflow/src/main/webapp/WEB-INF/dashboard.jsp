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
	<h1>Questions Dashboard</h1>
	
	<table>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
		
		<c:forEach items="${questions}" var="question">
		<tr>
			<td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
			<td><c:forEach items="${question.tags}" var="tag"><c:out value="${tag.subject}"/>,  </c:forEach></td>
		</tr>
		</c:forEach>
	
	</table>
	
	<h3><a href="/questions/new">Ask a new question!</a></h3>
</body>
</html>