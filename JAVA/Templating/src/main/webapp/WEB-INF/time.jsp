<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
   <head>
      <title>Display Current Time</title>
   </head>
   
   <body>
      <center>
         <h1>Display Current Time</h1>
         	<c:set var = "now" value = "<%= new java.util.Date()%>" />
			<fmt:formatDate pattern = "HH:mm:ss" value = "${now}" />
      </center>
   </body>
</html>