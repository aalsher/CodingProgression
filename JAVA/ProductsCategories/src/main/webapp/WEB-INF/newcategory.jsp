<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>New Category</title>
</head>
<body>
	
	<p class='error'><form:errors path="category.*"/></p>
	
	<h1>New Category</h1>

	<div class="form-container">
		<form:form action="/categories/new" method="POST" modelAttribute="category">
			<p>
				<form:hidden path="id"/>

				<form:label path="name" for="name">Name</form:label>
				<form:input path="name" class="input-size float" type="text" name="name"/>
			</p>
			<input class="float" type="submit" value="Create"/>
		</form:form>
	</div>
	
</body>
</html>