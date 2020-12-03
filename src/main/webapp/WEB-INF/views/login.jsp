<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
	span {
		margin: auto;
	}
	#login{
		margin: auto;
		width: 22%;
		margin-top: 5%;
		border: 3px solid green;
		padding: 10px;
	}
	table{
		text-align: center;
	}
</style>
<title>Login Page</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >User Login Page</span>
			</span>
		</nav>
	</div>
	<br/>
	<div id=login>
		<form action="Login" method="post">
			<table>
				<tr>
					<td><label>Username</label></td>
					<td colspan=2><input type="text" name="username" required/></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td colspan=2><input type="password" name="password" required/></td>
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