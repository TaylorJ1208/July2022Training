<%@ page import="com.taylor.model.Employee" import="java.sql.ResultSet"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style>
body {
	text-align: center;
}

form {
	box-shadow: 0px 0px 10px gray;
	margin: 1rem;
}

fieldset {
border:none;
}

legend {
font-weight: bold
}
</style>
</head>
<body>
	<!-- request is an implicit jsp object
     out is an implicit object in jsp 
 -->
	<h1 style='color: green'>Welcome Admin User</h1>
	<div class="main">
		<div class="crud">
		<h3 style='text-align: left;'>CRUD Tools:</h3>
			<form action="add" method="post">
				<fieldset>
					<legend>Add a user:</legend>
					<br> Employee Name: <input type="text" name="name"><br>
					<br> Employee User Name: <input type="text" name="username"><br>
					<br> Employee Password: <input type="text" name="password"><br>
					<br> <input type="submit" value="Add"><br>
				</fieldset>
			</form>
			<form action="update" method="post">
				<fieldset>
					<legend>Update a user:</legend>
					<br> Employee ID: <input type="text" name="updateId"><br>
					<br> New Employee Name: <input type="text" name="newName"><br>
					<br> <input type="submit" value="Update"><br>
				</fieldset>
			</form>
			<form action="delete" method="post">
				<fieldset>
					<legend>Delete a user:</legend>
					<br> Employee ID: <input type="text" name="deleteId"><br>
					<br> <br> <input type="submit" value="Delete"><br>
				</fieldset>
			</form>
		</div>
		<div class="table"
			style='display: flex; justify-content: center; margin-top: 1rem;'>
			<table style='width: 50%; box-shadow: 0px 0px 10px gray;'>
				<tr>
					<th>ID</th>
					<th>Employee Name</th>
					<th>Employee User Name</th>
					<th>Employee Password</th>
				</tr>
				<%
				Employee emp = new Employee();
				ResultSet result = emp.listEmployee();
				while (result.next()) {
					int id = result.getInt("id");
					String empName = result.getString("empName");
					String empUsername = result.getString("empUsername");
					String empPassword = result.getString("empPassword");
					out.println("<tr><td>" + id + "</td><td>" + empName + "</td><td>" + empUsername + "</td><td>" + empPassword
					+ "</td></tr>");
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>