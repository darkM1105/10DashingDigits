<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>

        <title>10 Dashing Digits</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="resources/game.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/game.css">

    </head>

    <body>

        <h1>Welcome to "10 Dashing Digits"</h1>
        <textarea id="wordList" rows="3" cols="70" readonly tabindex="-1"></textarea>
        <br>
        <h4 id="username">${username}</h4>
        <textarea id="user" rows="3" cols="70" autofocus></textarea>
        <br>
        <h4 id="opponentUsername"></h4>
        <textarea id="opponent" rows="3" cols="70" readonly tabindex="-1"></textarea>
        <br>
        <h3 id="output"></h3>

    </body>

</html>
