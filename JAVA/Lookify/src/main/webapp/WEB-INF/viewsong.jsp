<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Song</title>
</head>
<body>
	<div>
		<p><a href="/">Dashboard</a></p><br />
		<p><c:out value="${song.title}"/></p>
		<p><c:out value="${song.artist}"/></p>
		<p><c:out value="${song.rating}"/></p>
		<form:form action="/languages/delete/${song.id}" method="POST"><input class="float" type="submit" value="Delete" /></form:form>
	</div>
</body>
</html>
