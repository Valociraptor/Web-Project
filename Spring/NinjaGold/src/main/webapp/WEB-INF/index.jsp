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
	<body>
    <h1>get dat gold</h1>
    <h2>Your gold so far: <c:out value="${ totalgold}"/></h2>

    <h3>Farm</h3>
    <p>Earns 1-5 Gold</p>
    <form action="/process" method="POST">
        <input type="hidden" name="building" value="farm">
        <input type="submit" value="Find Gold">
    </form>


    <h3>Cave</h3>
    <p>Earns 10-20 Gold</p>
    <form action="/process" method="POST">
        <input type="hidden" name="building" value="cave">
        <input type="submit" value="Find Gold">
    </form>


    <h3>House</h3>
    <p>Earns 2-5 Gold</p>
    <form action="/process" method="POST">
        <input type="hidden" name="building" value="house">
        <input type="submit" value="Find Gold">
    </form>


    <h3>Casino</h3>
    <p>Earns 50 Gold... maybe...</p>
    <form action="/process" method="POST">
        <input type="hidden" name="building" value="casino">
        <input type="submit" value="Find Gold">
    </form>
    <br>
    <form action ="/clear" method="POST">
        <input type="submit" value="CLEAR ALL GAME DATA">
    </form>


<hr>
    <h2>So much room for activities!</h2>
	<c:forEach items="${logs }" var="log">
	${log }<br>
	
	</c:forEach>
    
    
</body>
</html>