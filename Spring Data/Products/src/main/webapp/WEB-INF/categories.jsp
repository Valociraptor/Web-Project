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
	<h1><c:out value="${category.name}"/></h1>

	
	<h2>Products: </h2>
	<ul><c:forEach items="${category.products}" var="prod">
	<li><c:out value="${prod.name}"/> </li>
	</c:forEach>
	</ul>
	
	<h3>Add a Product</h3>
	
	<form:form method="POST" action="/addcat" modelAttribute="categoriesProducts">
		<form:hidden path="category" value="${category.id}"></form:hidden>
		
		<form:label path="product">Add Product</form:label>
         <form:select path="product">
			<c:forEach items="${products}" var="product">
				<form:option value="${product}" label="${product.name}" />
			</c:forEach>
         </form:select>
		
	    
	    	<input type="submit" value="Create"/>
	  </form:form>
</body>
</html>