<%@ page import="com.taylor.model.Employee" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style>
body {
	text-align: center;
}
</style>
</head>
<body>
	<!-- request is an implicit jsp object
     out is an implicit object in jsp 
 -->
	<%
	Employee u = (Employee) request.getAttribute("abc");
	out.println("<h1 style=color:green>Welcome " + u.getEmpUsername() + "</h1>");
	%>
	<div class="main">
		<div class="crud">
			<form action="add" method="post">
				<h3 style='text-align: left;'>CRUD Tools:</h3>
				<fieldset>
					<legend>Add a user:</legend>
					<br> Employee Name: <input type="text" name="name"><br>
					<br> Employee User Name: <input type="text" name="username"><br>
					<br> Employee Password: <input type="text" name="password"><br>
					<br> <input type="submit" value="add"><br>
				</fieldset>
			</form>
			<form action="update" method="post">
				<fieldset>
					<legend>Update a user:</legend>
					<br> Employee ID: <input type="text" name="updateId"><br>
					<br> New Employee Name: <input type="text" name="newName"><br>
					<br> <input type="submit" value="update"><br>
				</fieldset>
			</form>
			<form action="delete" method="post">
				<fieldset>
					<legend>Delete a user:</legend>
					<br> Employee ID: <input type="text" name="deleteId"><br> <br>
					<br> <input type="submit" value="delete"><br>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>