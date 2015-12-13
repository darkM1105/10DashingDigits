<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Username</title>
</head>
<body>
    <form method="post" action="/game">
        Username:<input type="text" name="username" value="${info}">
        <input type="submit" value="Submit">
    </form>
</body>
</html>