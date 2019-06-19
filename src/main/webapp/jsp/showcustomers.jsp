<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!-- Adavance Data Centric Project By Raja Naseer Ahmed Khan (G00351263) -->


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Customers</title>

<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    
<!-- Javascript for deleting customer-->     
    <script type="text/javascript">
        function submitDelete(id)
        {
            document.getElementById('cId').value = id;
            document.getElementById('delete-customer').submit();
        }
    </script>
    
<!-- Images displayed each pages-->     
<style>
body {
  background-image: url("/resources/customer.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>
<body>
<p style="text-align: center;" class="blinking">List of All Customers</p>
<div class="container">
    <p><h1>List of Customers<form id="delete-customer" action="<c:url value="/deleteCustomer"/>" method="post">
    <input id="cId" name="cId" type="hidden" value=""/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form></h1></p>
    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${error}</span>
    </div>
    <div>
        <c:forEach items="${customers}" var="cust">
            <p>&nbsp;</p>
            <p><h2>${cust.custId}  ${cust.custName} [<a href="#" onclick="javascript:submitDelete(${cust.custId});">Delete</a>]</h2></p>
            <p>Loan Period = ${cust.loanPeriod}</p>
            <table class="table" width="50%">
                <thead>
                <tr>
                    <th>Loan ID</th>
                    <th>Book ID</th>
                    <th>Title</th>
                    <th>Author</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="loan" items="${cust.loansView}">
                    <tr>
                        <td>${loan.lid}</td>
                        <td>${loan.bid}</td>
                        <td>${loan.title}</td>
                        <td>${loan.author}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </div>
    <br>
    <span>
        <a href="/success">Home</a>
        |
        <a href="/showBooks">List Book</a>
        |
        <a href="/showLoans">List Loans</a>
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