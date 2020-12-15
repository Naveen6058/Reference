<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %> 
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
	.error{
		color:red;
	}
	#error{
		color:red;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
</style>
<title>Back Office User Login Page</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/index" id="primaryNavigators">Index</a></div>
			<span class="text-light font-weight-bold" >Back Office User Login Page</span>
		</nav>
	</div>
	<br/>
	<div id=login>
	<h4 id =error>${Message}</h4>
	<spring:form action="${pageContext.request.contextPath}/bovalidate" method="POST" modelAttribute="backofficeuser"> 
		<div>
			<div><label >Login ID</label></div>
			<div><spring:input path="loginId" type="text" />
			<spring:errors path="loginId" cssClass="error"/></div>
		</div>
			<br/>
		<div>
			<div><label>Password</label></div>
			<div><spring:input path="password" type="password" />
			<spring:errors path="password" cssClass="error"/></div>
		</div>
			<br/>
		<div>
			<input type="submit" value="Login"> 
		</div>
	</spring:form>
	</div>
</body>
</html>