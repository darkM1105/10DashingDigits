var wordList;
var userList;
var output;
var lastentry = "";
var i = 0;
var object;

$(document).ready(function(){

    wordList = $("#wordList");
    userList = $("#user");
    output = $("#output");

    var array = [];
    var startTime = 0;
    var lastTime;
    var sameCharacter;

    userList.focusout(function(){
        alert();
    });

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

    var username = $("#username").innerHTML;
    alert(username);
    $.get("/game", function(obj){

        object = obj;

    });
    alert(obj);
    $("#opponentUsername").html(obj['opponentUsername']);

});


    /*var myObject = new Object();
    myObject.username = "Dante1105"
    var array = [];
    for(var i = 0; i < 270; i++){
        array.push(1);
    }
    myObject.gameSession = array;
    myObject.listId = 5;
    var myString = JSON.stringify(myObject);

    window.location = "/post-game?info=" + myString;*/

    /*$.ajax({
        url: '/post-game',
        type: 'POST',
        dataType: 'json',
        data: "info=" + myString,
        success: function(result) {
            alert('SUCCESS');
        }
    });

     $.post(

         "/post-game",
         myString

     );*/