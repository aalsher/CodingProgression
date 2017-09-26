<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Top Ten Songs</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a><br>
	<h2>Top Ten Songs:</h2>
	
	<div>
		<c:forEach var="song" varStatus="loop" items="${topten}">
			<ul>
				<li><c:out value="${song.rating}"/>- <a href="/songs/${song.id}"><c:out value="${song.title}"/></a>- <c:out value="${song.artist}"/></li>
			</ul>
		</c:forEach>
	</div>
	
</body>
</html>
