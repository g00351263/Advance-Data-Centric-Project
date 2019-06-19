<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<!-- Adavance Data Centric Project By Raja Naseer Ahmed Khan (G00351263) -->


<html lang="en">
<head>
    <meta charset="utf-8">
    <title>New Loan</title>

<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<!-- Images displayed each pages--> 
    <style>
body {
  background-image: url("/resources/borrowbook.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>

<body>
<p style="text-align: center;" class="blinking">New Loan</p>
<div class="container">
    <form method="POST" action="${contextPath}/saveLoan" modelAttribute="loan" class="form-signin">
        <h2 class="form-heading">New Loan</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${error}</span>
            <br/>
            Customer ID: <input name="custId" type="text" class="form-control" placeholder="Customer ID"
                   autofocus="true"/>
            Book ID: <input name="bookId" type="text" class="form-control" placeholder="Book ID"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
        </div>
        <br>
        <span>
            <a href="/success">Home</a>
            |
            <a href="/showBooks">List Books</a>
            |
            <a href="/showCustomers">List Customers</a>
            |
            <a href="/showLoans">List Loans</a>
        </span>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
