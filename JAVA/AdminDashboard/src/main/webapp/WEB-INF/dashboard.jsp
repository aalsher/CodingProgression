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
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!"/>
    </form>
	
	<div class="viewuserdetails">
		<ul>
			<li><c:out value="${currentUser.firstname}"/></li>
			<li><c:out value="${currentUser.lastname}"/></li>
			<li><c:out value="${currentUser.username}"/></li>
			<li><c:out value="${currentUser.createdAt}"/></li>
			<li><c:out value="${currentUser.updatedAt}"/></li>
			
		</ul>
	</div>
	
</body>
</html>