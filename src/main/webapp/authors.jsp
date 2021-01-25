<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<h2>Authors</h2>
<ul>
    <c:forEach items="${requestScope.authors}" var="author">
        <li><a href="/authors/author?id=${author.id}">${author.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
