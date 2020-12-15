<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Stock Price</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<style>
body {
	font-family: "Lato", sans-serif;
}

.sidebar {
	height: 100%;
	width: 25%;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidebar a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 14px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.generateCommision {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 14px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidebar ol {
	color: #818181;
}

.sidebar ul {
	list-style: square;
	color: #818181;
}

.sidebar a:hover {
	color: #f1f1f1;
}

.sidebar .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

.openbtn {
	font-size: 20px;
	cursor: pointer;
	background-color: #111;
	color: white;
	padding: 10px 15px;
	border: none;
}

.openbtn:hover {
	background-color: #444;
}

#main {
	transition: margin-left .5s;
}

#primaryNavigators{
	margin-left:50px;
	color:white;
	position:relative;
}

#centre{
	margin:auto;
	margin-top: 100px;
	width:15%;
	border: 1px solid green;
}

#sample{
	
	margin: auto;
	text-align: center;
	border: 2px solid green;
	width: 30%;
	margin-top:5%;
	
}

span{
	margin:auto;
}

#errors{
	color:red;
}

#centreError{
		margin: auto;
		width: 20%;
		margin-top: 5%;
		color:red;
		padding-left: 50px;
		
	}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}
</style>
<body>
	<div id="mySidebar" class="sidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
		<a href="${pageContext.request.contextPath}/bouser/returnAddCompany">Add Company</a>
		<a href="${pageContext.request.contextPath}/bouser/selectModifyCompany">Modify Company</a>
		<a href="${pageContext.request.contextPath}/bouser/addCompanyStockPrice">Add Company Stock Price</a>
		<a href="${pageContext.request.contextPath}/bouser/returnCreateCommodity">Create Commodity</a>
		<a href="${pageContext.request.contextPath}/bouser/selectModifyCommodity">Modify Commodity</a>
		<a href="${pageContext.request.contextPath}/bouser/addCommodityPrice">Add Commodity Price</a>
		
		<label class="generateCommision">Generate Commission</label>
		<ul>
			<li><a href="#">Annual Report</a></li>
			<li><a href="#">Monthly Report</a></li>
			<li><a href="#">Periodic Report</a></li>
		</ul>
	</div>
	<div id="main">
		<nav class="navbar navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" onclick="openNav()"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a href="${pageContext.request.contextPath}/bouser/home" id="primaryNavigators">Home</a>
			<span>
				<span class="text-light font-weight-bold">Add Stock Price</span>
			</span>
			<div><spring:form action="${pageContext.request.contextPath}/logout" id="primaryNavigators" method="POST">
				<input type="submit" value="Logout" />
				</spring:form></div>
		</nav>
	</div>
	
	<h6 id = centreError>${Message}</h6>
	
	<div id=sample>
		<h2>Add Stock Price</h2>
		<hr/>
		<spring:form action="${pageContext.request.contextPath}/bouser/newStockPrice" method="POST" modelAttribute="addstockprice">
		<table>
				<tr>
					<td><spring:label path="companyName">Company Name</spring:label></td>
					<td>	<spring:select path="companyName">
							<spring:options items="${companyNames}"/>	
						</spring:select> </td>
					<td><spring:errors path="companyName" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="sharePrice">Share price</spring:label></td>
					<td><spring:input path="sharePrice"/></td>
					<td><spring:errors path="sharePrice" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td colspan=2><hr/><button>Submit</button></td>
				</tr>
		</table>
		</spring:form>
	</div>
	<script>
		function openNav() {
			document.getElementById("mySidebar").style.width = "250px";
			document.getElementById("main").style.marginLeft = "250px";
		}

		function closeNav() {
			document.getElementById("mySidebar").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
		}
	</script>

</body>
</html>