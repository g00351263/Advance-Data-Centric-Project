<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<!-- Adavance Data Centric Project By Raja Naseer Ahmed Khan (G00351263) -->


<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>

<!-- links to css and bootstrap files -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    
<!-- Images displayed each pages-->    
    <style>
body {
  background-image: url("/resources/login.gif");
  background-repeat: no-repeat;
  background-position: right top;
  margin-right: 200px;
}
</style>
<script type="text/javascript">
function validate() {
    if (document.f.username.value == "" && document.f.password.value == "") {
        alert("Username and password are required");
        document.f.username.focus();
        return false;
    }
    if (document.f.username.value == "") {
        alert("Username is required");
        document.f.username.focus();
        return false;
    }
    if (document.f.password.value == "") {
    alert("Password is required");
    document.f.password.focus();
        return false;
    }
    if (document.f.username.value != "user" || document.f.password.value != "user") {
        alert("Password or Username are Incorrect");
        document.f.username.focus();
        return false;
    }
}
</script>
</head>

<body>
<p style="text-align: center;" class="blinking" >Log In</p>
<div class="container">
    <form name="f" method="POST" action="${contextPath}/perform_login" class="form-signin" onsubmit="validate()">
        <h2 class="form-heading">Log in</h2>
        <%
            String isError = "";
            if ( request.getParameter("error") != null ) {
                isError = "has-error";
            }
        %>
        <div class="form-group '${isError}'">
            <% if ( request.getParameter("error") != null ) { %>
                <span>Invlaid User ID/Password.</span>
            <% } %>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit" >Log In</button>
        </div>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
