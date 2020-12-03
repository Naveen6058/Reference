<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	table, th, td {
	  border: 1px solid black;
	  border-collapse: collapse;
	  margin-left: 10px;
	  height: 50px;
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	
	#footer {
		width:80%;
		position: absolute;
		right:15%;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	#content{
		text-align: center;	
		margin-top: 50px;
	}
	span{
		margin: auto;
	}
</style>
<title>Company</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/user/home" id="primaryNavigators">Home</a></div>
			<span>
				<span class="text-light font-weight-bold" >Company Historical Prices Page</span>
			</span>
			<div><a href="#" id="primaryNavigators">Logout</a></div>
		</nav>
	</div>
	
	<div id=content>
		<table id=footer>
			<thead>
				<tr>
					<td colspan="4" style="color: white;font-size:20px;text-align:center"><b>Historical Prices</b></td>
				<tr>
					<th scope="col" colspan="1">Company ID</th>
					<th scope="col" colspan="1">Company Name</th>
					<th scope="col" colspan="1">Price</th>
					<th scope="col" colspan="2">Date</th>
				</tr>
			</thead>
			<tbody>
				<core:forEach var="companyHistory" items="${companyHistoricalDataOutputDto}">
					<tr>
						<td>${companyHistory.companyCode}</td>
						<td>${searchCompany.companyTitle}</td>
						<!--<td></td> -->
						<td>${companyHistory.stockPrice}</td>
						<td>${companyHistory.dateTime}</td>
					</tr>
				</core:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>