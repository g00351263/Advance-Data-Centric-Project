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
    <title>Add Book</title>
    
<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  
  <!-- Images displayed each pages-->
    <style>
body {
  background-image: url("/resources/addstudent.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>


<body>
<p style="text-align: center;" class="blinking">Add a Customer</p>
<div class="container">

    <form:form method="POST" action="${contextPath}/saveCustomer" modelAttribute="customer" class="form-signin">
        <h2 class="form-heading">Add new Customer</h2>
 <div class="form-group ${error != null ? 'has-error' : ''}">
<table>
       
     
            <input type="hidden" name="cId" value="-1"/>
       <tr>
            <td>Name:</td> <td><form:input path="cName" name="cName" type="text" class="form-control" placeholder="CustomerName"
                   autofocus="true"/></td>
            <td><form:errors path="cName"></form:errors></td>
                   
                   </tr>
                   <tr>
            <td>Load Period: </td><td><form:input path="loanPeriod" name="loanPeriod" type="text" class="form-control" placeholder="LoanPeriod"/></td>
            <td><form:errors path="loanPeriod"></form:errors></td>
            </tr>
            
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
        </div>
        <br>
        <span>
            <a href="/success">Home</a>
            |
            <a href="/addBook">Add Book</a>
            |
	        <a href="/showBooks">List Book</a>
    	    |
        	<a href="/showLoans">List Loans</a>
        	|
        </span>
    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
