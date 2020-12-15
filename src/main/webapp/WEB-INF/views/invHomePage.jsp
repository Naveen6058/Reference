<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home Page</title>
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
	width: 0;
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
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
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

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidebar {
		padding-top: 15px;
	}
	.sidebar a {
		font-size: 18px;
	}
}

span{
	margin: auto;
}

	#logout{
		color:white;
		position:relative;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	#logout{
		background-color: Dodgerblue;
	}
</style>
<body>
	<div id="mySidebar" class="sidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
		<a href="#">Dashboard</a> 
		<a href="${pageContext.request.contextPath}/user/searchCompany">Search Company</a>
		<a href="${pageContext.request.contextPath}/user/searchCommodity">Search Commodity</a> 
		<a href="#">Sector</a>
		<a href="#">Portfolio Report</a> 
		<a href="${pageContext.request.contextPath}/user/wallet">Wallet</a>
	</div>
	<div id="main">

		<nav class="navbar navbar-dark bg-primary">
			<button class="navbar-toggler" type="button" onclick="openNav()"
				aria-controls="navbarToggleExternalContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div><a href="${pageContext.request.contextPath}/user/home" id="primaryNavigators">Home</a></div>
			<div id="primaryNavigators">Welcome ${Investor.loginKey}</div>
			 <!-- <security : authentication property= "principal . username"/></div> -->
			<span>
				<span class="text-light font-weight-bold">Investor Dashboard</span>
			</span>
			<div><spring:form action="${pageContext.request.contextPath}/logout" method="POST">
				<button type=Submit name=Logout id=logout>Logout</button>
			</spring:form></div>
		</nav>
		<div class="container">
			<!-- 	<h1>Employee Register Form:</h1> -->
			<div class="row mt-3">
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">Current Portfolio value</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-body"><a href="${pageContext.request.contextPath}/user/recentViewCompanies">Recently Viewed Companies</a></div>
					</div>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">Amount Invested</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">Amount Earned</div>
					</div>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">Earning Trend Week for past 10 weeks</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="card">
						<div class="card-body">Wallet Amount</div>
					</div>
				</div>
			</div>
		</div>
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