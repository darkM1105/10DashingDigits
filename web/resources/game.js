/*var wordList;
var userList;
var output;

function prepare() {

    wordList = document.getElementById("wordList").value;
    userList = document.getElementById("user");
    output = document.getElementById("output");

}

function verify(event) {

    var index = userList.length - 1;
    output.innerHTML = index;

    if (userList.value.charAt(index) === wordList.charAt(index)) {

        output.innerHTML = event.timeStamp;

    } else {

        userList.value = userList.value.substr(0, userList.value.length - 2);

    }

}*/

$(document).ready(function(){

    /*var obj = '${info}';
    alert(obj);
    $("#username").html(obj['username']);
    $("#opponentUsername").html(obj['opponentUsername']);*/

    var myObject = new Object();
    myObject.username = "Dante1105"
    var array = [];
    for(var i = 0; i < 270; i++){
        array.push(1000);
    }
    myObject.gameSession = array;
    myObject.listId = 5;
    var myString = JSON.stringify(myObject);

    window.location = "/post-game?info=" + myString;

    /*$.ajax({
        url: '/post-game',
        type: 'POST',
        dataType: 'json',
        data: "info=" + myString,
        success: function(result) {
            alert('SUCCESS');
        }
    });

    $("textarea").click(function(){

        var myObject = new Object();
        myObject.username = "Dante1105"
        var array = [];
        for(var i = 0; i < 270; i++){
            array.push(1000);
        }
        myObject.gameSession = array;
        myObject.listId = 5;
        var myString = JSON.stringify(myObject);

        $.post(

            "/post-game",
            myString

        );

    });*/

});