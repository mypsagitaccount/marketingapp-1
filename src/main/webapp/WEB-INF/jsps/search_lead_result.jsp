<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Lead Result</title>
</head>
<body>
		<h1>Search Lead Result</h1>
		<hr>
			<table border="1">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>mobile</th>
					<th>delete</th>
					<th>update</th>
				</tr>
				
				<c:forEach var="lead" items="${leads }">  
   					<tr>
   						<td>${lead.firstName }</td>
   						<td>${lead.lastName }</td>
   						<td>${lead.email }</td>
   						<td>${lead.mobile }</td>
   						<td><a href="delete?id=${lead.id }">delete</a></td>
   						<td><a href="update?id=${lead.id }">update</a></td>
   					</tr>  
				</c:forEach> 
				
			</table>
</body>
</html>