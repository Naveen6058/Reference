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
	table, th, td {
	  
	  margin-left: 10px;
	  height: 50px;
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	
	#footer {
		height:1000px;
		width:80%;
		position: absolute;
		right:15%;
	}
	.commodity{
		width:65%;
		margin:auto;
		text-align: center;
		border: 1px solid black;
	  	border-collapse: collapse;
	}
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	.container{
		position:absolute;
	}
	#currentPrice{
		margin-left:300px;
		position: relative;
		top:10px;
		border: 4px solid red;
		width:250px;
		text-align: center;
		height: 90px;
		background: DodgerBlue;
		color: white;
	}
	#content{
		text-align: center;	
	}
	span{
		margin: auto;
	}
	#buttons{
		margin:auto;
		width: 30%;
		padding: 10px;
	}
	#button{
		background-color:DodgerBlue;
		margin-left :10px;
		color:white;
	}
</style>
<title>Commodity</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/user/home" id="primaryNavigators">Home</a></div>
			<span>
				<span class="text-light font-weight-bold">Commodity Page</span>
			</span>
			<div><a href="#" id="primaryNavigators">Logout</a></div>
		</nav>
	</div>
	
	<div id=currentPrice>
		<h5>Commodity Name: ${commodityDto.commodityName}</h5>
		<hr>
		<h6>Current Price: ${commodityDto.price}</h6>
	</div>
	<div>
		<br/>
		<table class="commodity">
			<thead>
				<tr>
					<th scope="col" colspan="1">Commodity Id</th>
					<th scope="col" colspan="1">Commodity Name</th>
					<th scope="col" colspan="1">Price</th>
					<th scope="col" colspan="1">Currency</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${commodityDto.commodityId}</td>
					<td>${commodityDto.commodityName}</td>
					<td>${commodityDto.price}</td>
					<td>${commodityDto.currency}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<hr/>
	<div id=buttons>
		<table>
			<tr>
				<td><spring:form action="${pageContext.request.contextPath}/user/buy/${commodityDto.commodityName}" method="POST" modelAttribute="searchCompany">
					<button type=Submit name=Submit id=button>Buy</button>
				</spring:form></td>
			
				<td><spring:form action="${pageContext.request.contextPath}/user/sell" method="POST" modelAttribute="searchCompany">
					<button type=Submit name=Submit id=button>Sell</button>
				</spring:form></td>
				
				<td><spring:form action="${pageContext.request.contextPath}/user/${commodityDto.commodityName}/historicalPrices/${commodityDto.commodityName}" method="POST">
					<button type=Submit name=Submit id=button>Historical Prices</button>
				</spring:form></td>

			</tr>
		</table>
	</div>

</body>
</html>