<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 21.01.2021
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <ul>
        <c:forEach items="${requestScope.books}" var="book">
            <li><a href="/book/view?id=${book.id}">${book.name}</a></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
