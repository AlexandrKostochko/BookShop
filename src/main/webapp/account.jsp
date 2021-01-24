<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Account</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <p>Account</p>
    <br>
    <p>Name ${sessionScope.user.name}</p>
    <br>
    <p>Basket</p>
    <br>
    <ul>
        <c:forEach items="${sessionScope.basket.getAll()}" var="book">
            <li>${book.name}</li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
