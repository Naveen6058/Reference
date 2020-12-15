<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
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
		width: 25%;
		margin-top: 5%;
		border: 3px solid green;
		padding: 10px;
	}
	
	#primaryNavigators{
		margin-left:50px;
		color:white;
		position:relative;
	}
	#errors{
		color:red;
	}

</style>
</head>
<body>
	<div>
		<nav class="navbar navbar-dark bg-primary">
			<div><a href="${pageContext.request.contextPath}/index" id="primaryNavigators">Index</a></div>
			<span class="text-light font-weight-bold" >User Registration</span>
		</nav>
	</div>
	<div id=center>
		<h4 id="errors">${Message}</h4>
		<hr>
		<spring:form action="${pageContext.request.contextPath}/createInvestor" method="POST" modelAttribute="newInvestor">
			<table>
				<tr>
					<td><spring:label path="firstName">First name: </spring:label> </td>
				<td colspan=2><spring:input type="text" path="firstName"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="firstName" cssClass="error" id="errors"/></td>
				</tr>
			    <tr>
					<td><spring:label path="lastName">Last Name:</spring:label>  </td>
					<td colspan=2> <spring:input type="text" path="lastName"></spring:input> </td>
			 	</tr>
			 	<tr>
					<td></td>
					<td><spring:errors path="lastName" cssClass="error" id="errors"/></td>
				</tr>
			 	<tr>
					 <td><spring:label path="gender"> Gender: </spring:label></td>
					 <td colspan=2>
					 <spring:radiobutton path="gender" value="Male"/>Male 
					 <spring:radiobutton path="gender" value="Female"/>Female 
					 </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="gender" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="mobileNumber"> Mobile Number: </spring:label></td>
					<td colspan=2><spring:input type="text" path="mobileNumber"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="mobileNumber" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="panId"> Pan ID: </spring:label></td>
					<td colspan=2><spring:input type="text" path="panId"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="panId" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="emailId"> Email Id: </spring:label></td>
					<td colspan=2><spring:input type="email" path="emailId"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="emailId" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="loginKey"> Login key: </spring:label></td>
					<td colspan=2><spring:input type="text" path="loginKey"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="loginKey" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td><spring:label path="password"> Password: </spring:label></td>
					<td colspan=2><spring:input type="password" path="password"></spring:input> </td>
				</tr>
				<tr>
					<td></td>
					<td><spring:errors path="password" cssClass="error" id="errors"/></td>
				</tr>
				<tr>
					<td></td>
					<td colspan=2><input type=Submit name=Submit Value=Submit></td>
					<td></td>
				</tr>
			</table>
		</spring:form>
	</div>
</body>
</html>