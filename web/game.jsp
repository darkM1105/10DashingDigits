<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>

        <title>10 Dashing Digits</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="resources/game.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/game.css">

    </head>

    <body onload="prepare()">

        <h1>Welcome to "10 Dashing Digits"</h1>
        <textarea id="wordList" rows="10" cols="70" readonly tabindex="-1">This is the text you will have to type out.</textarea>
        <br>
        <textarea id="user" rows="10" cols="70" autofocus onchange="verify(event)"></textarea>
        <br>
        <textarea id="opponent" rows="10" cols="70" readonly tabindex="-1">This is your opponent.</textarea>
        <br>
        <h3 id="output"></h3>

    </body>

</html>
