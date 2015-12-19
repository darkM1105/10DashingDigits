<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Username</title>
    <link rel="stylesheet" type="text/css" href="resources/site.css">
</head>
<body>
<h1>"10 Dashing Digits"</h1>
<form method="post" action="/game">
    Username: <input id="usernameInput" type="text" name="username" value="${info}">
    <input type="submit" value="Submit">
</form>
</body>
</html>