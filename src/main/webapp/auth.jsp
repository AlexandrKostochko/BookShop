<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>

<jsp:include page="_header.jsp"/>
<div class="container">
    <form action="/auth" method="post">
        <div class="mb-3">
            <label for="exampleInputEmail2" class="form-label">Login</label>
            <input type="text" name="login" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary">Authorization</button>
        <br>
        <br>
        <span style="font-size: medium" class="badge rounded-pill bg-danger">${requestScope.message}</span>
    </form>
</div>
</body>
</html>

