<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>TheCode</title>
  </head>
  <body>
  	<center><p><font style= "red"><c:out value="${errors}"/></font></p><br>
  	<p>What is the code?</p>
  	<div id="input">
  		<form action="/code" method="POST">
  			<input type= text name= "code"><br>
  			<input type= submit name= "submitcode">Try Code
  		</form>
  	</div></center>
  	
  </body>
</html>