<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	
	<c:choose>
		<c:when test="${ msg.getClass().getSimpleName().equals(\"String\") }">
		<h2>${ msg }</h2>
		</c:when>
		<c:when test="${ msg.getClass().getSimpleName().equals(\"EmployeeDto\") }">
			<table border="1" align="center">
				<tr>
					<th>Employee Number</th>
					<th>Name</th>
					<th>Email Id</th>
					<th>DateOfBirth</th>
					<th>Age</th>
					<th>Salary</th>
					<th>Status</th>
				</tr>
				<tr>
					<td>${ msg.employeeId }</td>
					<td>${ msg.employeeName }</td>
					<td>${ msg.emailId }</td>
					<td>${ msg.dateOfBirth }</td>
					<td>${ msg.age }</td>
					<td>${ msg.salary }</td>
					<td>${ msg.employeeStatus }</td>
				</tr>
			</table>
		</c:when>
	</c:choose>

</body>
</html>