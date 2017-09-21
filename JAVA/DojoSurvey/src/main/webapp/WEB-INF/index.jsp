<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<form action="/result" method="POST">
		<label>Name: <input type= text name= "name"></label><br>
		<label>Dojo Location:</label>
			<select name="dojolocation">
				<option value="San Jose"> San Jose </option>
				<option value="Washington DC"> Washington DC </option>
				<option value="Seattle"> Seattle </option>
			</select><br>
		<label></label>
		<select name="favoritelanguage">
			<option value="Python"> Python </option>
			<option value="Javascript"> Javascript </option>
			<option value="Ruby"> Ruby </option>
		</select><br>	
		<input type= text name= "comment">Comment (optional):<br>
		<input type= submit name= "submit">Submit
	</form>
</body>
</html>