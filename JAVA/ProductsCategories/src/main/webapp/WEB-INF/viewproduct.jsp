<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Product</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	
	<div class="viewproduct">
		<h2>Categories:</h2>
		<ul>
			<c:forEach var="category" varStatus="loop" items="${productcategories}">
				<li><c:out value="${category.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	
	<div class= "addcategory">
		<form action="/products/${id}" method="POST">
			Add To Category:
			<select name="category">
				<c:forEach var="category" varStatus="loop" items="${allcategories}">
					<option value= "${category.id}">${category.name}</option>
				</c:forEach>		
			</select>
			<input class="float" type="submit" value="Add"/>
		</form>
	</div>
	
</body>
</html>