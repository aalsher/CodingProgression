<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
</head>
<body>
	<div class="header">
		<a href="/songs/new">Add New Song</a>
		<a href="/topten">Top Songs</a>
		<form> Search by Artist:<input action="/search" type="search" name="searchQuery" value="Search Artists"></form>
	</div>
	
	<div class="allsongs">
		<table>
		
			<thead>
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="song" varStatus="loop" items="${songs}">
					<tr>
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>

						<td><form:form action="/songs/delete/${song.id}" method="POST"><input class="float" type="submit" value="Delete" /></form:form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
