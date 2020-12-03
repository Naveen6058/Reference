<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="1">
	<thead>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>CONTACT</th>
			<th>NET SALARY</th>
	</thead>
	<tbody>
		<core:forEach var="employee" items="${employees}">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.email}</td>
			<td>${employee.contact}</td>
			<td>${employee.netSalary}</td>
		</tr>
	</core:forEach>
	</tbody>
</table>
</body>
</html>