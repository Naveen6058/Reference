<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	  padding: 10px;
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	
	.walletDetails{
		position:relative;
		margin:10px;
		left:50px;
		width:800px;
	}
	
	.container{
		position:absolute;
		left:1000px;
		top:100px;
	}
	.transactionTable{
		position:absolute;
		width:90%;
		right:5%;
	}
	
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	.walletDetails{
		margin:auto;
		margin-top: 5%;
		width: 70%;
	}
	span{
		margin: auto;
	}
</style>
<title>Investor Wallet</title>
</head>
<body>
	<div>
		<div>
			<nav class="navbar navbar-dark bg-primary">
				<div><a href="${pageContext.request.contextPath}/user/home" id="primaryNavigators">Home</a></div>
				<span class="text-light font-weight-bold" >My Wallet</span>
				<div><a href="index.html" id="primaryNavigators">Logout</a></div>
			</nav>
		</div>
		
	    <div>
	      <table class="walletDetails">
			<thead>
				<tr>
				<td colspan="4" style="color: white;font-size:20px;text-align:center"><b>My Wallet details</b></td>
				</tr>
				<tr>
					<th scope="col" colspan="1">Investor ID</th>
					<th scope="col" colspan="1">Investor Name</th>
					<th scope="col" colspan="1">Amount invested</th>
					<th scope="col" colspan="1">Balance</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Suhas</td>
					<td>100</td>
					<td>110</td>
				</tr>
			</tbody>
		</table>
	    </div>
	    
	  </div>
		
</body>
</html>