var wordList;
var userList;
var output;
var lastentry = "";
var i = 0;

$(document).ready(function(){

    wordList = $("#wordList");
    userList = $("#user");
    output = $("#output");

    var array = [];
    var startTime = 0;
    var lastTime;
    var sameCharacter;

    var gameSession;
    var username;
    var listId;
    var list;

    var wordListValue = "";
    var opponentTextArea = "";

    userList.keyup(function(e) {
        i = userList.val().length - 1;
        if (startTime == 0) {
            startTime = e.timeStamp;
            lastTime = startTime;
        }
        sameCharacter = (userList.val().charAt(i) == wordList.val().charAt(i));
        if (/*(userList.val() != lastentry) &&*/ (userList.val().charAt(i) == wordList.val().charAt(i))) {
            array.push(lastTime - e.timeStamp);
            lastTime = e.timeStamp;
        } else {
            userList.value = userList.val().substr(0, userList.val().length - 1);
        }
        lastentry = userList.val();
    });

    $.get("/game", function(obj){
        username = (obj['username']);
        listId = (obj['listId']);
        gameSession = (obj['gameSessionArray']);
        $("#username").html(username);
        $("#opponentUsername").html(obj['opponentUsername']);
        list = (obj['wordListArray']);
        for(var i = 0; i < list.length; i++) {
            wordListValue += (list[i] + " ");
        }
        $("#wordList").val(wordListValue);
    });

    $("h1").click(function(){

        var myObject = new Object();
        myObject.username = $("#username").html();
        for(var i = 0; i < 270; i++){
            gameSession.push(1);
        }
        myObject.gameSession = gameSession;
        myObject.listId = listId;
        var myString = JSON.stringify(myObject);

        $.post("/post-game", {"info":myString}, function(){
            window.location = "/index.jsp";
        });

    });

    $("#opponent").click(function(){

        for (var i = 0; i < gameSession.length; i++){

            setTimeout(doOpponentAction(i), gameSession[i]);

        }

    });

    function doOpponentAction(i) {

        opponentTextArea = wordListValue.substring(0, (i + 1));
        $("#opponent").val(opponentTextArea);

    }

});