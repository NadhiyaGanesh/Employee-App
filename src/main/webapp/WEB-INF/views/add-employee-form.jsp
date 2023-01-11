<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee Details</title>
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
		<jsp:include page="index.jsp"/>
		<div class="container">
		  <form action="employee" method="post">
		  	  <label>Employee Name</label>
		  	  <input type="text" name="employeeName">
		  	  <br><br>
		  	  
		  	  <label>Email Id</label>
		  	  <input type="email" name="emailId">
		  	  <br><br>
		  	  
		  	  <label>DateOfBirth</label>
		  	  <input type="date" name="dateOfBirth" id="txtdob">
		  	  <br><br>
		  	  
		  	  <label>Age</label>
		  	  <input type="number" name="age" id="age" onmouseover="fncalage()" readonly="readonly">
		  	  <br><br>
		  	  
		  	  <label>Salary</label>
		  	  <input type="text" name="salary">
		  	  <br><br>
		  	  
		  	  <label>Employee Status</label>
		  	  <br>
		  	  <label for="active">Active</label>
		  	  <input type="radio" name="employeeStatus" value="Active" id="active">
		  	  <label for="inactive">InActive</label>
		  	  <input type="radio" name="employeeStatus" value="InActive" id="inactive">
		  	  <br><br>
		  	  <input type="submit" value="Add Employee Details">
		  	  
		  </form>
		</div>
</body>
</html>