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
	<h1><c:out value="${product.name}"/></h1>
	
	<h2>Description: </h2>
	<p><c:out value="${product.description}"/>
	
	<h2>Price: $<c:out value="${product.price}"/></h2>
	
	
	<h2>Categories: </h2>
	<ul><c:forEach items="${product.categories}" var="cat">
	<li><c:out value="${cat.name}"/> </li>
	</c:forEach>
	</ul>
	
	<h3>Add a Category</h3>
	
	<form:form method="POST" action="/addcat" modelAttribute="categoriesProducts">
		<form:hidden path="product" value="${product.id}"></form:hidden>
		
		<form:label path="category">Add Category</form:label>
         <form:select path="category">
			<c:forEach items="${categories}" var="category">
				<form:option value="${category}" label="${category.name}" />
			</c:forEach>
         </form:select>
		
	    
	    	<input type="submit" value="Create"/>
	  </form:form>
</body>
</html>