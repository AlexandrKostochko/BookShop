<%--<%@ page import="java.util.List" %>--%>
<%--<%@ page import="by.tms.model.User" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Find All</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; margin-left: auto; margin-right: auto">
    <c:if test="${requestScope.users == null}">
        <h3>No registered users</h3>
    </c:if>
    <c:if test="${requestScope.users != null}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Login</th>
                <th scope="col">Name</th>
                <th scope="col">Password</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.users}" var="user">
                <tr>
                    <th scope="row">${user.getIdUser()}</th>
                    <td>${user.getLogin()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getPassword()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
