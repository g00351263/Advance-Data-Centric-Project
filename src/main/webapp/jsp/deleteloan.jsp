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
    <title>Delete Loan</title>
    
<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    
    <!-- Images displayed each pages-->
    <style>
body {
  background-image: url("/resources/delete.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
    <script type="text/javascript">
        function submitForm()
        {
            if ( document.getElementById('lid').value == ""
                || isNaN(document.getElementById('lid').value) ){
                alert("Loan ID should be a number and can not be empty")
                return false;
            }
            document.getElementById('loanForm').submit();
        }
    </script>
</head>

<body>
<p style="text-align: center;" class="blinking">Delete a Loan</p>
<div class="container">
    <form id="loanForm" method="POST" action="${contextPath}/deleteLoanCommit" modelAttribute="loan" class="form-signin" onsubmit="return submitForm();">
        <h2 class="form-heading">Delete Loan</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${error}</span>
            <br/>
            Loan ID: <input id="lid" name="lid" type="text" class="form-control" placeholder="Loan ID"
                   autofocus="true"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
        </div>
        <br>
        <span>
            <a href="/success">Home</a>
            |
            <a href="/showBooks">List Book</a>
            |
            <a href="/showCustomers">List Customer</a>
            |
            <a href="/showLoans">List Loans</a>
            |
            <a href="/newLoan">New Loan</a>
        </span>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
