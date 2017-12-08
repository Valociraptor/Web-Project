<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Prototype Roster</h1>
	<a href="Teams">New Team</a>
	
	<table>
		<thead>
			<tr>
				<td>Team</td>
				<td>Players</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${allTeams}" varStatus="loop">
				<tr>
					<td><c:out value="${team.getName()}" /></td>
					<td><c:out value="${team.getPlayers().size()}" /></td>
					<td><a href="Teams?id=${loop.index}">Details</a> | <a href="DeleteTeam?id=${loop.index}">Delete</a></td>
				</tr>
			</c:forEach>						
		</tbody>
	</table>
</body>
</html>