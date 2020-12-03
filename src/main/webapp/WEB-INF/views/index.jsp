<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
	span{
		margin: auto;
	}
	#login{
		margin: auto;
		width: 22%;
		margin-top: 5%;
		border: 3px solid green;
		padding: 10px;
	}
	#leftline{
		border-left:2px solid #B4CDCD;
	}
	table{
		text-align: center;
	}
</style>
<title>Portfolio Management System</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >Portfolio Management System</span>
			</span>
		</nav>
	</div>
	<br/>
	<div id=login>
		<table>
			<tr>
				<td>New user? </td> 
				<td id = leftline><a href="${pageContext.request.contextPath}/UserRegistration">Signup</a></td>
			</tr>
			<tr><td><hr></td><td><hr></td></tr>
			<tr>
				<td>User Login </td> 
				<td id = leftline><a href="${pageContext.request.contextPath}/Userlogin">Login</a></td>
			</tr>
			<tr><td><hr></td><td><hr></td></tr>
			<tr>
				<td>BackOffice Login </td> 
				<td id = leftline><a href="${pageContext.request.contextPath}/BOUserLogin">Login</a></td>
			</tr>
			<tr><td><hr></td><td><hr></td></tr>
			<tr>
				<td>SuperUser Login</td> 
				<td id = leftline><a href="${pageContext.request.contextPath}/SuperUserLogin">Login</a></td>
			</tr>
		</table>
	</div>
</body>
</html>