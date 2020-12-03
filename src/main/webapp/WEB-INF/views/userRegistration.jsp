<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
	span{
		margin: auto;
	}
	#center{
		margin: auto;
		width: 22%;
		margin-top: 5%;
		border: 3px solid green;
		padding: 10px;
	}

</style>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >User Registration</span>
			</span>
		</nav>
	</div>
	<div id=center>
		<form action="UserServlet" method="post">
			<table>
				<tr>
					<td><label>First name: </label> </td>
					<td colspan=2><input type="text" name="firstname" required></input> </td>
			   </tr>
			    <tr>
					<td><label>Last Name:</label>  </td>
					<td colspan=2> <input type="text" name="lastname" required></input> </td>
			 	</tr>
			 	<tr>
					 <td><label> Gender: </label></td>
					 <td colspan=2><input type="radio" name="gender" value="male" required>Male 
					 <input type="radio" name="gender" value="female" required>Female </td>
			 	</tr>
			 	<tr>
					<td><label> Pan ID: </label></td>
					<td colspan=2><input type="text" name="panid" required></input> </td>
				</tr>
				<tr>
					<td><label> Email ID: </label></td>
					<td colspan=2><input type="text" name="emailid" required></input> </td>
				</tr>
				<tr>
					<td><label> Mobile Number: </label></td>
					<td colspan=2><input type="text" name="mobilenumber" required></input> </td>
				</tr>
				<tr>
					<td><label> Login key: </label></td>
					<td colspan=2><input type="text" name="loginkey" required></input> </td>
				</tr>
				<tr>
					<td><label> Password: </label></td>
					<td colspan=2><input type="password" name="password" required></input> </td>
				</tr>
				<tr>
					<td></td>
					<td><input type=Submit name=Submit Value=Submit></td>
					<td><input type=reset name=reset Value=reset></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>