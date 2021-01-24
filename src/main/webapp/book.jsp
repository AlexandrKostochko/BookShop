<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 22.01.2021
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; margin-right: auto; margin-left: auto; display: flex">
    <div style="width: 72%">
        <h3>${requestScope.book.getName()}</h3>
        <h4>
            <a href="/authors/author?id=${requestScope.book.getAuthor().getId()}"> ${requestScope.book.getAuthor().getName()}</a>
        </h4>
    </div>
</div>

</body>
</html>
