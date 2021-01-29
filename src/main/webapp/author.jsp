<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/_header.jsp"/>
<br>
<div class="container">
    <div class="row">
        <div class="col">
                <div class="card-body">
                    <h5 class="card-title">Name: ${requestScope.author.name}</h5>
                </div>
        </div>
        <div class="col">
            <div class="card-body">
                <h5 class="card-title">Description: ${requestScope.author.description}</h5>
            </div>
        </div>
        <div class="col">
            <br>
            <p><strong>List of books:</strong></p>
            <ol>
                <c:forEach items="${requestScope.author.bookList}" var="book">
                    <li><a href="/book/view?id=${book.id}">${book.name}
                    </a></li>
                </c:forEach>
            </ol>
        </div>
    </div>
</div>

</body>
</html>