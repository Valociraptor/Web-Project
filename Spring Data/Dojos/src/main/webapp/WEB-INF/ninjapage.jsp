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
	<h1>All Ninjas</h1>

	<c:forEach  begin="1" end="${totalPages}" var="index">
	<a href="/allninjas/${index}">${index}</a>
	</c:forEach>


 <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
      

            <c:forEach var="ninja" items="${ninjas.content}">                 
            <tr>
                <td><c:out value="${ninja.name}"></c:out></td>
                <td><c:out value="${ninja.age}"></c:out></td>
            </tr>
            </c:forEach>

    </table>

</body>
</html>