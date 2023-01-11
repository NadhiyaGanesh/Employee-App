<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Details</title>
</head>
<body>
	<script type="text/javascript">
	  function fncalage(){
		var userDateInput = document.getElementById("txtdob").value;
		console.log(userDateInput);
		
		var birthDate = new Date(userDateInput);
		
		var today=new Date();
		
		var age=today.getTime()-birthDate.getTime();
		var Age=Math.floor(age/(1000*60*60*24*365.25));
		document.getElementById("age").value=Age;
		console.log(Age);
	  }
	</script>
	<div class="container">
	<form action="/employee-app/update-employee" method="post">
		<label>Employee Id</label><br>
		<input type="number" name="employeeId" value="${ employee.employeeId }" readonly="readonly">
		<br><br>
		
		<label>Employee Name</label><br>
		<input type="text" name="employeeName" value="${ employee.employeeName }">
		<br><br>
		
		<label>Email ID</label><br>
		<input type="email" name="emailId" value="${ employee.emailId }">
		<br><br>
		
		<label>DateOfBirth</label><br>
		<input type="date" name="dateOfBirth" value="${ employee.dateOfBirth }">
		<br><br>
		
		<label>Age</label><br>
		<input type="number" name="age" value="${ employee.age }">
		<br><br>
		
		<label>Salary</label><br>
		<input type="text" name="salary" value="${ employee.salary }">
		<br><br>
		
		<label>Employee Status</label><br>
		<c:choose>
			<c:when test="${ employee.employeeStatus.equals(\"Active\") }">
				<label for="active">Active</label>
				<input type="radio" name="employeeStatus" value="Active" id="active" checked="checked">
				<label for="inactive">InActive</label>
				<input type="radio" name="employeeStatus" value="InActive" id="inactive">
				<br><br>
			</c:when>
			<c:when test="${ employee.employeeStatus.equals(\"InActive\") }">
				<label for="active">Active</label>
				<input type="radio" name="employeeStatus" value="Active" id="active">
				<label for="inactive">InActive</label>
				<input type="radio" name="employeeStatus" value="InActive" id="inactive" checked="checked">
				<br><br>
			</c:when>
			<c:otherwise>
				<label for="active">Active</label>
				<input type="radio" name="employeeStatus" value="Active" id="Active">
				<label for="active">InActive</label>
				<input type="radio" name="employeeStatus" value="InActive" id="InActive">
			</c:otherwise>
		</c:choose>
		<br><br>
		<input type="submit" value="Update Employee">
	</form>
	</div>
</body>
</html>