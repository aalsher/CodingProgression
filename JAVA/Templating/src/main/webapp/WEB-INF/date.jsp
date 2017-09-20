<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
   <head>
      <title>Display Current Date</title>
   </head>
   
   <body>
      <center>
         <h1>Display Current Date</h1>
         	<c:set var = "now" value = "<%= new java.util.Date()%>" />
			<fmt:formatDate pattern = "yyyy-MM-dd" value = "${now}" />
      </center>
   </body>
</html>