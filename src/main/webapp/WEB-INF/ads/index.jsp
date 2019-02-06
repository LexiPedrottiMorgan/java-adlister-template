<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="List of Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1>Here are all of the Ads:</h1>
    <c:forEach var="ads" items="${ads}">
        <div class="col-md-6">
            <h2>${ads.getTitle()}</h2>
            <p>Description: ${ads.getDescription()}</p>
        </div>
    </c:forEach>
</div>
</body>
</html>

