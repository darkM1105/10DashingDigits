<%--
  Created by IntelliJ IDEA.
  User: Matthew
  Date: 12/15/2015
  Time: 2:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin's Special Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="resources/admin.js"></script>
    <link rel="stylesheet" type="text/css" href="resources/site.css">
</head>
<body>
    <h1>The Admin's Super Duper Secret Page</h1>
    <div id="adminContent">
    <h3 id="trueCount"></h3>
    <form>
        Just Create: <input id="createCount" type="text" name="createCount"><br>
        <button type="button" id="justCreate">Submit</button>
    </form>
    <br>
    <br>
    <br>
    <form>
        Create: <input id="createAndPopulateCount" type="text" name="createAndPopulateCount"><br>
        Populate: <input id="createAndPopulatePopulate" type="text" name="createAndPopulatePopulate"><br>
        <button type="button" id="createAndPopulate">Submit</button>
    </form>
    <br>
    <br>
    <br>
    <form>
        Just Delete: <input id="deleteCount" type="text" name="deleteCount">
        <button type="button" id="delete">Submit</button>
    </form>
    <br>
    <br>
    <br>
    <button type="button" id="deleteAll">Delete Everything In The Database</button>
    <br>
    <br>
    <br>
    <a href="index.jsp">Home</a>
    </div>
</body>
</html>
