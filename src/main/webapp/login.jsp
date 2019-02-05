<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--checking the username and password for 'admin' 'password' to redirect to profile page:--%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if(request.getMethod().equalsIgnoreCase("post")) {
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>

<p>Path: <%= request.getRequestURL() %></p>
<p>Query String: <%= request.getQueryString() %></p>
<p>"name" parameter: <%= request.getParameter("username") %></p>
<p>"password" parameter: <%= request.getParameter("password") %></p>



<form method="POST" action="/login.jsp">
    <h3>Username:</h3>
    <input type="text" name="username" placeholder="enter username">
    <h3>Password:</h3>
    <input type="password" name="password" placeholder="enter password">
    <button type="submit">Login</button>
</form>
</body>
</html>

