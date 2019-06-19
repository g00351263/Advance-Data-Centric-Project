<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!-- Adavance Data Centric Project By Raja Naseer Ahmed Khan (G00351263) -->


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Loans</title>

<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<!-- javascript for deleting each loan in list--> 
    <script type="text/javascript">
        function submitDelete(id)
        {
            document.getElementById('lid').value = id;
            document.getElementById('delete-loan').submit();
        }
    </script>

<!-- Images displayed each pages--> 
<style>
body {
  background-image: url("/resources/loan.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>
<body>
<p style="text-align: center;" class="blinking">List of All Loans</p>
<div class="container">
    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${error}</span>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>Loan ID<form id="delete-loan" action="<c:url value="/deleteLoanCommit"/>" method="post">
                <input id="lid" name="lid" type="hidden" value=""/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form></th>
            <th>Customer ID</th>
            <th>Customer Name</th>
            <th>Book Title</th>
            <th>Author</th>
            <th>Due Date</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="loan" items="${loans}">
                <tr>
                    <td>${loan.lid}</td>
                    <td>${loan.CId}</td>
                    <td>${loan.cname}</td>
                    <td>${loan.title}</td>
                    <td>${loan.author}</td>
                    <td>${loan.duedate}</td>
                    <td><a href="#" onclick="javascript:submitDelete(${loan.lid});">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <span>
        <a href="/success">Home</a>
        |
        <a href="/addBook">Add Book</a>
        |
        <a href="/showCustomers">List Customers</a>
        |
        <a href="/deleteLoan">Delete Loan</a>
        |
        <a href="#" onclick="document.getElementById('logout-form').submit();">Logout</a>

<form id="logout-form" action="<c:url value="/logout"/>" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
    </span>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>