<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee Details</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	<div class="container">
	<form action="/employee-app/edit" method="get">
		<label>Search Employee ID</label>
		<br><br>
		<input type="number" name="employeeId">
		<br><br>
		<input type="submit" value="search">
	</form>
	</div>
</body>
</html>