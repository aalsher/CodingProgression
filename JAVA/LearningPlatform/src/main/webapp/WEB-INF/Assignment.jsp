<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>Assignment</title>
  </head>
  <body>
  	<h1>Fortran!</h1>
  	
  	<ul>
  		<li><a href="/m/38/0553/0733">Setup</a></li>
  		<li><a href="/m/38/0483/0345">Forms</a></li>
  		<li><a href="/m/38/0553/0342">Cards</a></li>
  		<li><a href="/m/26/0553/0348">Advanced</a></li>
  		<li><a href="/m/26/0483/2342">Binary</a></li>
  	</ul>
  	
  	<div id="body" style="border:2px solid black">
  		<p><c:out value="${type}"/></p>
  	</div>
  	
  </body>
</html>