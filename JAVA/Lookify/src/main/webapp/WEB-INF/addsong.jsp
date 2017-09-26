<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Song</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a><br>
	
	<p class='error'><form:errors path="song.*"/></p>

	<div class="form-container">
		<form:form action="/songs/new" method="POST" modelAttribute="song">
			<p>
				<form:hidden path="id"/>

				<form:label path="title" for="title">Title</form:label>
				<form:input path="title" class="input-size float" type="text" name="title"/>
			</p>
			<p>
				<form:label path="artist" for="artist">Artist</form:label>
				<form:input path="artist" class="input-size float" type="text" name="artist"/>
			</p>
			<p>
				<form:label path="rating" for="rating">Rating</form:label>
					<form:select path="rating">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
					</form:select>
			</p>
			<input class="float" type="submit" value="Add Song"/>
		</form:form>
	</div>
	
</body>
</html>