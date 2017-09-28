<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Category</title>
</head>
<body>
	<h1><c:out value="${category.name}"/></h1>
	
	<div class="viewcategory">
		<h2>Products:</h2>
		<ul>
			<c:forEach var="product" varStatus="loop" items="${categoryproducts}">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
	</div>
	
	<div class= "addproduct">
		<form action="/categories/${id}" method="POST">
			Add Product:
			<select name="product">
				<c:forEach var="product" varStatus="loop" items="${allproducts}">
					<option value= "${product.id}">${product.name}</option>
				</c:forEach>		
			</select>
			<input class="float" type="submit" value="Add"/>
		</form>
	</div>
	
</body>
</html>