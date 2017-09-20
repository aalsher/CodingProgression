
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<p> You have visited <a href="/">http://localhost:8080</a> <c:out value="${hitNumber}"/> times</p><br>
	<p><a href="/reset">Test another visit?</a></p>
</body>
</html>