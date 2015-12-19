<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 12/15/2015
  Time: 2:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="resources/site.css">
</head>
<body>
    <form action="j_security_check" method="post">
        <input type="text" name="j_username"><br>
        <input type="text" name="j_password"><br>
        <input type="submit">
    </form>
</body>
</html>
