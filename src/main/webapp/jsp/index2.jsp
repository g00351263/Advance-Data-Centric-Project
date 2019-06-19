<!DOCTYPE html>

<!-- Adavance Data Centric Project By Raja Naseer Ahmed Khan (G00351263) -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ADCWA Final Project</title>

<!-- links to css and bootstrap files -->
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<!-- Images displayed each pages-->
<style>
body {
  background-image: url("/resources/background.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>
<body >
<p class="blinking">Welcome To Library Management System</p>
<div class="container">
	<% if (session.getAttribute("USERNAME") == "" ) { %>
		<p align="right"><a href="/login">Login</a></p>
	<% } %>
	<p>${session.getAttribute("USERNAME")}</p>
	<table class="table">
		<thead>
		<tr>
			<th>Books</th>
			<th>Customers</th>
			<th>Loans</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td><a href="/showBooks">List Books</a></td>
			<td><a href="/showCustomers">List Customers</a></td>
			<td><a href="/showLoans">List Loans</a></td>
		</tr>
		<tr>
			<td><a href="/addBook">Add Book</a></td>
			<td><a href="/addCustomer">Add Customers</a></td>
			<td><a href="/newLoan">New Loan</a></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td><a href="/deleteLoan">Delete Loan</a></td>
		</tr>
		</tbody>
	</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>