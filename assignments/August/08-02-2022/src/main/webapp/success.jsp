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
	border: none;
}

legend {
	font-weight: bold;
}

.crud {
	display: flex;
	flex-direction: row;
	justify-content: center;
}

.table {
	display: flex;
	flex-direction: row;
	justify-content: center;
	padding: 1rem;
}

table {
	width: 50%;
}

td {
	padding: 1rem;
}

.crudTools {
	display: flex;
	box-shadow: 0px 0px 5px gray;
	padding: 1rem;
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
		<fieldset class="crudTools">
		<legend class="crudLegend">CRUD Tools</legend>
		
			<form action="add" method="post">
				<fieldset>
					<legend>Add a user:</legend>
					<br> First Name: <input type="text" name="firstName"><br>
					<br> Last Name: <input type="text" name="lastName"><br>
					<br> User Name: <input type="text" name="username"><br>
					<br> Password: <input type="text" name="password"><br>
					<br> Address: <input type="text" name="address"><br>
					<br> Contact: <input type="text" name="contact"><br>
					<br> Admin Status: <select name="isAdmin">
						<option value="false">False</option>
						<option value="true">True</option>

					</select><br> <br> <input type="submit" value="Add"><br>
				</fieldset>
			</form>
			<form action="update" method="post">
				<fieldset>
					<legend>Update a user:</legend>
					<br> ID: <input type="text" name="id"><br> <br>
					First Name: <input type="text" name="firstName"><br> <br>
					Last Name: <input type="text" name="lastName"><br> <br>
					User Name: <input type="text" name="username"><br> <br>
					Password: <input type="text" name="password"><br> <br>
					Address: <input type="text" name="address"><br> <br>
					Contact: <input type="text" name="contact"><br> <br>
					Admin Status: <select name="isAdmin">
						<option value="false">False</option>
						<option value="true">True</option>
					</select><br> <br> <input type="submit" value="Update"><br>
				</fieldset>
			</form>
			<form action="delete" method="post">
				<fieldset>
					<legend>Delete a user:</legend>
					<br> Employee ID: <input type="text" name="id"><br>
					<br> <br> <input type="submit" value="Delete"><br>
				</fieldset>
			</form>
			</fieldset>
		</div>
		
		<div class="table">
 		
			<table style='box-shadow: 0px 0px 10px gray;'>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
					<th>Password</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Admin Status</th>
				</tr>
				<%
				Employee emp = new Employee();
				ResultSet result = emp.listEmployee();
				while (result.next()) {
					int id = result.getInt("id");
					String empFirstName = result.getString("firstName");
					String empLastName = result.getString("lastName");
					String empUsername = result.getString("username");
					String empPassword = result.getString("password");
					String empAddress = result.getString("address");
					String empContact = result.getString("contact");
					boolean isAdmin = result.getBoolean("isAdmin");
					out.println("<tr><td>" + id + "</td><td>" + empFirstName + "</td><td>" + empLastName + "</td><td>" + empUsername
					+ "</td><td>" + empPassword + "</td><td>" + empAddress + "</td><td>" + empContact + "</td><td>" + isAdmin + "</td><tr>");
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>