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

<h3><a href="/songs/new">Add New</a></h3>
<h3><a href="/search/topTen">Top Songs</a></h3>

	<form method="POST" action="/look"> 
    <input type="text" name="search">
    <input type="submit" value="Submit">
	</form>
	
	
	<table>
		<tr>
		<th>Title</th>
		<th>Artist</th>
		<th>Rating</th>
		<th>Actions</th>
		</tr>
		<c:forEach items="${songs}" var="song">
			<tr>
			<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
			<td><c:out value="${song.artist}"/></td>
			<td><c:out value="${song.rating}"/></td>
			<td><a href="/songs/delete/${song.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>