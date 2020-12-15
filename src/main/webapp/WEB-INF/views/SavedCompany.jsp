<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Creation</title>
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
	
	
#primaryNavigators{
	margin-left:50px;
	color:white;
	position:relative;
}
#output{
	margin: auto;
	width: 22%;
	margin-top: 5%;
	border: 3px solid green;
	padding: 10px;
	text-align: center;
}	

</style>
</head>
<body>
<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/bouser/home" id="primaryNavigators">Home</a></div>
			<span>
				<span class="text-light font-weight-bold" >Company Created Successfully</span>
			</span>
			<div>
				<spring:form action="${pageContext.request.contextPath}/logout" method="POST">
					<input type="submit" value="Logout" />
				</spring:form>
			</div>
		</nav>
	</div>
<hr/>
<div id = output>
	<h2>Saved Details...</h2>
	<hr/>
	<h5>Company Code : ${CompanyOutput.companyCode}</h5>
	<h5>Company Title : ${CompanyOutput.companyTitle}</h5>
	<h5>Operation: ${CompanyOutput.operation}</h5>
	<h5>Share Count: ${CompanyOutput.shareCount}</h5>
	<h5>Share Price: ${CompanyOutput.sharePrice}</h5>
	<h5>Sector: ${CompanyOutput.sector}</h5>
	<h5>Currency: ${CompanyOutput.currency}</h5>
	<h5>Turnover: ${CompanyOutput.turnover}</h5>
	<h5>Date Time IPO: ${CompanyOutput.dateTimeIPO}</h5>
	<h5>Stock Exchange: ${CompanyOutput.stockExchange}</h5>
	<h5>IPO Price: ${CompanyOutput.ipoPrice}</h5>
</div>
</body>
</html>