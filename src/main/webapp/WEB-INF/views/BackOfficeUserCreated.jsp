<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Back Office User Creation</title>
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
	.error{
		color:red;
	}

</style>
</head>
<body>
<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >User Created Successfully</span>
			</span>
		
		<div><spring:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" />
				</spring:form></div>
		</nav>
	</div>
<hr/>
<h2>Saved Details...</h2>

<h3>FIRST NAME : ${backofficeuser.firstName}</h3>
<h3>LAST NAME : ${backofficeuser.lastName}</h3>
<h3>EMAIL: ${backofficeuser.emailId}</h3>
<h3>PASSWORD: ${backofficeuser.password}</h3>
<h3>Login ID: ${backofficeuser.loginId}</h3>
</body>
</html>