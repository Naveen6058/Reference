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
		margin-top: 30px;
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
				<span>
					<span class="text-light font-weight-bold" >My Wallet</span>
				</span>
				<div><a href="index.html" id="primaryNavigators">Logout</a></div>
			</nav>
		</div>
		
		 <div class="row d-flex" >
	    <div class="col-sm-8 ">
	      <table class="walletDetails">
			<thead>
				<tr>
				<td colspan="5" style="color: white;font-size:20px;text-align:center"><b>My Wallet details</b></td>
				</tr>
				<tr>
					<th scope="col" colspan="1">Investor ID</th>
					<th scope="col" colspan="1">Name</th>
					<th scope="col" colspan="1">Amount invested</th>
					<th scope="col" colspan="1">Amount Earned</th>
					<th scope="col" colspan="1">Balance</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Suhas</td>
					<td>100</td>
					<td>10</td>
					<td>110</td>
				</tr>
			</tbody>
		</table>
	    </div>
	    <div class="col-sm-4 mt-5" >
	      <div>
			<form action="addMoney" method="post">
				<input type="text" id="cash" name="cash" placeholder="Amount">
				<input type="submit" value="Add Money">
			</form>
			
			<form action="withdrawMoney" method="post">
				<input type="text" id="cash" name="cash" placeholder="Amount">
				<input type="submit" value="Withdraw Money">
			</form>
		</div>
	    </div>
	  </div>
		
	</div>
	<hr/>
	<div>
		<br/>
		<br/>
		<table class="transactionTable">
			<thead>
				<tr>
					<td colspan="5" style="color: white;font-size:20px;text-align:center"><b>Transaction details</b></td>
				</tr>
				<tr>
					<th scope="col" colspan="1">Transaction Id</th>
					<th scope="col" colspan="1">Amount</th>
					<th scope="col" colspan="1">Transaction type</th>
					<th scope="col" colspan="1">Date time</th>
					<th scope="col" colspan="1">Balance</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1234</td>
					<td>100</td>
					<td>Credit</td>
					<td>10/4/2020 1:17 PM</td>
					<td>110</td>
				</tr>
				<tr>
					<td>1235</td>
					<td>10</td>
					<td>Credit</td>
					<td>10/4/2020 1:00 PM</td>
					<td>10</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>