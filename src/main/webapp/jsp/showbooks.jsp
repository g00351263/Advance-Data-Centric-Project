<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!-- Adavance Data Centric Project By Raja Naseer Ahmed Khan (G00351263) -->


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Books</title>

<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<!-- javascript for delete book--> 
    <script type="text/javascript">
        function submitDelete(id)
        {
            document.getElementById('bid').value = id;
            document.getElementById('delete-book').submit();
        }
    </script>
    
    
<!-- Images displayed each pages-->     
<style>
body {
  background-image: url("/resources/booklist.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
</head>
<body>
<p style="text-align: center;" class="blinking">List of All Books</p>
<div class="container">
    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${error}</span>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>Book ID<form id="delete-book" action="<c:url value="/deleteBook"/>" method="post">
                <input id="bid" name="bid" type="hidden" value=""/>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form></th>
            <th>Title</th>
            <th>Author</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bid}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td><a href="#" onclick="javascript:submitDelete(${book.bid});">Delete</a></td>
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