<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
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
	#errors{
		color:red;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	#centreError{
		margin: auto;
		width: 20%;
		margin-top: 5%;
		color:red;
		padding-left: 50px;
		
	}
</style>
<title>Login Page</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/index" id="primaryNavigators">Index</a></div>
			<span class="text-light font-weight-bold" >User Login Page</span>
		</nav>
	</div>
	<br/>
	
	<h4 id = centreError>${Message}</h4>
	
	<div id=login>
		<spring:form action="${pageContext.request.contextPath}/invValidate" method="post" modelAttribute="investorLoginDto">
			<table>
				<tr>
					<td><spring:label path="loginKey">Username</spring:label> </td>
					<td colspan=2><spring:input type="text" path="loginKey"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td colspan=2><spring:errors path="loginKey" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="password">Password</spring:label> </td>
					<td colspan=2><spring:input type="password" path="password"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td colspan=2><spring:errors path="password" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type=Submit name=Submit Value=Submit></td>
					<td><input type=reset name=reset Value=reset></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>