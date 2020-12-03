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
</style>
<title>Super User Login Page</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >Super User Login Page</span>
			</span>
		</nav>
	</div>
	<br/>
	<div id=login>
	<spring:form action="${pageContext.request.contextPath}/validate" method="POST" modelAttribute="superuser"> 
		<div>
			<div><label >Username</label></div>
			<div><spring:input path="superUserId" type="text" />
			<spring:errors path="superUserId" cssClass="error"/></div>
		</div>
			<br/>
		<div>
			<div><spring:label path="password">Password</spring:label></div>
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