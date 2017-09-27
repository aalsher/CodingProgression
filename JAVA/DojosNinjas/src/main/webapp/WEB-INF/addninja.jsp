<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Ninja</title>
</head>
<body>
	<p class='error'><form:errors path="ninja.*"/></p>

	<div class="form-container">
		<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
			<p>
				<form:hidden path="id"/>
		
				<form:label path="dojo" for="dojo">Dojo</form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" varStatus="loop" items="${dojoList}">
						<form:option value= "${dojo.id}">${dojo.name}</form:option>
					</c:forEach>
						
				</form:select>
				<form:label path="firstname" for="firstname">First Name:</form:label>
				<form:input path="firstname" class="input-size float" type="text" name="firstname"/>
				
				<form:label path="lastname" for="lastname">Last Name:</form:label>
				<form:input path="lastname" class="input-size float" type="text" name="lastname"/>
				
				<form:label path="age" for="age">Age:</form:label>
				<form:input path="age" class="input-size float" type="text" name="age"/>
			</p>
			<input class="float" type="submit" value="Create"/>
		</form:form>
	</div>
	
</body>
</html>