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
	<h1>Hi <c:out value="${currentUser.username}"/> !</h1>

	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    
    	<p><form:errors path="idea.*"/></p>
	    <form:form method="POST" action="/bright_ideas/new/" modelAttribute="idea">
        <p>
            <form:label path="text"></form:label>
            <form:textarea path="text" placeholder="Post something witty here..."/>
        

        <form:hidden path="user" value="${currentUser.id}"></form:hidden>
        <input type="submit" value="Idea!"/></p>
    </form:form>
    
    <c:forEach items="${ideas}" var="idea">
    <a href="/users/${idea.user.id}"><c:out value="${idea.user.username}"/></a> says: <br><br>
    <c:out value="${idea.text}"/><br><br>
    <a href="/bright_ideas/like/${idea.id}/">Like This</a>....	    <a href="/bright_ideas/${idea.id}"><c:out value="${idea.likers.size()}"/> people </a> like this <c:out value="${idea.likeCount}"/> times.
    <c:if test="${currentUser == idea.user}">
    	<a href="/bright_ideas/delete/${idea.id}">Delete Your Idea!</a>
    </c:if>
    
    <hr>
    <br>
    </c:forEach>
    
    
</body>
</html>