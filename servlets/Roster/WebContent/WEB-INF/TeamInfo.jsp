<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Team Details</title>
</head>
<body>
	<h1>${team.getName()}</h1>
	<a href="Players?id=${teamId}">New Player</a>
	<table>
		<thead>
		
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${team.getPlayers()}" varStatus="loop">
				<tr>
					<td><c:out value="${player.getFirstName()}"/></td>
					<td><c:out value="${player.getLastName()}"/></td>
					<td><c:out value="${player.getAge()}"/></td>
					<td><a href="DeletePlayer?teamId=${teamId}&playerId=${loop.index}">Delete</a></td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</body>
</html>