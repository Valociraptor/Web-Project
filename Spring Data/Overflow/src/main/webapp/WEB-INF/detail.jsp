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
	<h2><c:out value="${question.question}"/></h2>
	<h3>Tags: <c:forEach items="${question.tags}" var="tag"><c:out value="${tag.subject}"/>  </c:forEach></h3>
	
	<table>
		<tr>
			<th>Answers</th>
	
		</tr>
		
		<c:forEach items="${question.answers}" var="ans">
		<tr>
			<td><c:out value="${ans.answer}"/></td>
		</tr>
		</c:forEach>
	</table>
	
	
	<h3>Add your answer:</h3>
	
		<form:form method="POST" action="/answers" modelAttribute="answerModel">
	    <form:label path="answer">Answer : 
	    <form:errors path="answer"/>
	    <form:input path="answer"/></form:label>
	    
	    <form:input type="hidden" path="question" value="${question.id}"/>   
	    <input type="submit" value="Submit"/>
	    
	</form:form>
</body>
</html>