<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dojo Ninjas</title>
</head>
<body>
	<h2><c:out value="${dojo.name}"/> Location Ninjas</h2>
	
	<div class="viewninjas">
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="ninja" varStatus="loop" items="${dojo.ninjas}">
					<tr>
						<td><c:out value="${ninja.firstname}"/></td>
						<td><c:out value="${ninja.lastname}"/></td>
						<td><c:out value="${ninja.age}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>