<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <p>Name ${requestScope.book.name}</p>
    <p>Description ${requestScope.book.description}</p>
    <p>Price ${requestScope.book.price}</p>
    <p>
        Author: <a href="/author?id=${requestScope.book.author.id}">${requestScope.book.author.name}</a>
    </p>
    <form action="/basket" method="post">
        <c:if test="${sessionScope.user != null}">
        <input type="hidden" name="id" value="${requestScope.book.id}">
        <button>Add</button>
        </c:if>
    </form>
</div>
</body>
</html>