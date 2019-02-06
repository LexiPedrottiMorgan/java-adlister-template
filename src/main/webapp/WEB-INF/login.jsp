<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Login</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<%@include file="partials/navbar.jsp"%>
<p>Path: <%= request.getRequestURL() %></p>
<p>Query String: <%= request.getQueryString() %></p>
<p>"name" parameter: <%= request.getParameter("username") %></p>
<p>"password" parameter: <%= request.getParameter("password") %></p>



<form method="POST" action="/login">
    <h3>Username:</h3>
    <input type="text" name="username" placeholder="enter username">
    <h3>Password:</h3>
    <input type="password" name="password" placeholder="enter password">
    <br>
    <button type="submit" class="btn btn-info mt-2">Login</button>
</form>




</body>
</html>

