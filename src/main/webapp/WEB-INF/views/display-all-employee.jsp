<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Details</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	<h2>All Employee Details</h2>
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
		<c:forEach var="allEmployee" items="${ emp }">
		<tr>
			 <td>${ allEmployee.employeeId }</td>
			 <td>${ allEmployee.employeeName }</td>
			 <td>${ allEmployee.emailId }</td>
			 <td>${ allEmployee.dateOfBirth }</td>
			 <td>${ allEmployee.age }</td>
			 <td>${ allEmployee.salary }</td>
			 <td>${ allEmployee.employeeStatus }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>