<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>Submitted Info</h1><br>
	<p>Name:<c:out value="${name}"/></p><br>
	<p>Dojo Location:<c:out value="${dojolocation}"/></p><br>
	<p>Favorite Language:<c:out value="${favoritelanguage}"/></p><br>
	<p>Comment:<c:out value="${comment}"/></p><br>
	<p><a href="/goback">Go Back</a></p>
</body>
</html>