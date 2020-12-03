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
	  margin-left: 10px;
	  text-align: center;
	}
	thead {
	  background: DodgerBlue;
	  color: #fff;
	}
	span{
		margin:auto;
	}
	
	#footer {
		width:80%;
		position: absolute;
		right:10%;
	}
	.commodity{
		width:60%;
		height:70px;
		margin-left:50px;
		margin-top: 10px;
		margin-bottom: 40px;
	}
	#logout{
		background-color:red;
		color:white;
		position:relative;
	}
	.container{
		position:absolute;
		left:1000px;
		top:60px;
	}
	#content{
		margin-top: 50px;
	}
</style>
<title>Commodity</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<span>
				<span class="text-light font-weight-bold" >Commodity Page</span>
			</span>
			<div><a href="#" id="logout">Logout</a></div>
		</nav>
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
					<td>123456</td>
					<td>Gold</td>
					<td>10</td>
					<td>$</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class=container>
		<form action="addMoney" method="post">
			<input type="text" id="cash" name="cash" placeholder="Amount">
			<input type="submit" value="Buy">
		</form>
		
		<form action="withdrawMoney" method="post">
			<input type="text" id="cash" name="cash" placeholder="Amount">
			<input type="submit" value="Sell">
		</form>
	</div>
	<hr/>
	
	<div id=content>
		<table id=footer>
			<thead>
				<tr>
					<td colspan="4" style="color: white;font-size:20px;text-align:center"><b>Historical Prices</b></td>
				<tr>
					<th scope="col" colspan="1">Commodity Name</th>
					<th scope="col" colspan="1">Price</th>
					<th scope="col" colspan="2">Date</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Gold</td>
					<td>10</td>
					<td>05/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Gold</td>
					<td>11</td>
					<td>04/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Gold</td>
					<td>12</td>
					<td>03/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Gold</td>
					<td>10</td>
					<td>02/11/2020 12 :00 PM</td>
				</tr>
				<tr>
					<td>Gold</td>
					<td>10</td>
					<td>01/11/2020 12 :00 PM</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>