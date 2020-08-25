<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>
<h1>
Customers List 
</h1>

<input type="button" value="Add Customer"
	onclick="window.location.href='showFormForAdd';return false;"
	class="add-button">
<table>
	<tr>
		<th>First Name </th>
		<th>Last Name </th>
		<th>Email </th>
		<th>Action</th>
	</tr>
	
	<c:forEach var="tempCustomer" items="${customers}">
	<c:url var="updateLink" value="/customer/showFormForUpdate">
		<c:param name="customerId" value="${tempCustomer.custId}" />
	</c:url>
	
	<c:url var="deleteLink" value="/customer/deleteCustomer">
		<c:param name="customerId" value="${tempCustomer.custId}" />
	</c:url>
		<tr>
		<td>${tempCustomer.firstName}</td>
		<td>${tempCustomer.lastName}</td>
		<td>${tempCustomer.email}</td>
		<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a></td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>