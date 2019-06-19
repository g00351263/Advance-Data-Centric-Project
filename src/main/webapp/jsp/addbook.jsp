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
  background-image: url("/resources/addbook.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>
<body >


<body>
<p style="text-align: center;" class="blinking">Add a Book</p>
<div class="container">
    <form:form method="POST" action="${contextPath}/saveBook" modelAttribute="book" class="form-signin">

        <h2 class="form-heading">Add new Book</h2>

        <table>

        <div class="form-group ${error != null ? 'has-error' : ''}">

            <input type="hidden" name="bid" value="-1"/>
            	<tr>
            	
            	<td>Title:</td><td><form:input path="title" name="title" type="text" class="form-control" placeholder="Title"
                   autofocus="true"/></td>
                   <td><form:errors path="title"></form:errors></td>
               </tr>
               <tr>
            	<td>Author:</td> <td><form:input path="author" name="author" type="text" class="form-control" placeholder="Author"/></td>
				<td><form:errors path="author"></form:errors></td>
				</tr>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				

            <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
        </div>
        <br>
        <span>
            <a href="/success">Home</a>
            |
            <a href="/addCustomer">Add Customer</a>
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
