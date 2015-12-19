$(document).ready(function(){

    //Simple jQuery selector placeholder variables.
    var wordList = $("#wordList");
    var userList = $("#user");
    var opponent = $("#opponent");

    //Useful information for adding to the array later.
    var start = 0;
    var lastKeyStrokeTime = 0;
    var canAddToArray = true;

    //Information that is needed when submitting at the end of the game.
    var array = [];
    var username;
    var listId;

    //Information concerning the computerized opponent.
    var opponentActions;
    var opponentHasStarted = false;

    //Gets starting information needed for the game to run.
    $.get("/pregame", function(obj){

        var list = (obj['wordListArray']);
        var wordListValue = "";

        username = (obj['username']);
        listId = (obj['listId']);
        opponentActions = (obj['gameSessionArray']);
        $("#username").html(username);
        $("#opponentUsername").html(obj['opponentUsername']);

        for (var i = 0; i < list.length; i++) {

            wordListValue += (list[i] + " ");

        }

        $("#wordList").val(wordListValue);

    });

    /*When the page loads, your textarea gets autofocus. However, you yourself can't edit the textarea. It can only
    * be done through javascript here. That is why there is an event listener on your textarea. Every time that you
    * press a key, this function gets the character value of what would have been typed out. This can include capital
    * letters as well. i.e. you can press shift + whatever. NEVER DO BACKSPACE!!! If the character you would have
    * ended up typing corresponds to the current character index of the word list, then that character will get
    * printed out. If you mistyped the character, then nothing will get appended.*/
    userList.keypress(function(event){

        var i = userList.val().length;
        var aChar = String.fromCharCode(parseInt(event.charCode));
        var wordListVal = wordList.val();
        var time;

        //Makes sure that there is only one magic thread running.
        if (!opponentHasStarted) {

            opponentHasStarted = true;
            doOpponentActions();

        }

        if (aChar == wordListVal.charAt(i)) {

            userList.val(wordListVal.substr(0, i + 1));

            if (start == 0) {

                start = event.timeStamp;
                lastKeyStrokeTime = start;
                time = 0;

            }

            if (time !== 0) {

                time = event.timeStamp - lastKeyStrokeTime;
                lastKeyStrokeTime = event.timeStamp;

            }

            if (canAddToArray) {

                array.push(time);

            }

        }

        if (array.length === 210) {

            canAddToArray = false;
            submitGameSession();

        }

    });

    /*Thanks to "nebs" at "http://stackoverflow.com/questions/14430060/how-to-delay-after-every-iteration-in-javascript-for-loop",
    this function magically makes characters appear in the opponent's textarea. It is probably done in a very resource
    intensive way though.*/
    function doOpponentActions() {

        //This function definition has code in it which ends up calling itself.
        var loopTimeout = function(i, max, interval, func) {

            if (i >= max) {

                return;

            }

            func(i);

            i++;

            setTimeout(function() {

                loopTimeout(i, max, opponentActions[i], func);

            }, interval);

        };

        //Has to initially be called though.
        loopTimeout(0, opponentActions.length, opponentActions[0], function(i) {

            opponent.val(wordList.val().substr(0, i + 1));

        });

    }

    //Creates an object that will later be turned into a "GameSession" object.
    function submitGameSession() {

        var session = new Object();
        var gameSession;

        session.gameSession = array;
        session.username = username;
        session.listId = listId;

        gameSession = JSON.stringify(session);

        $.post("/postgame", {"info":gameSession}, function(){

            window.location = "/index";

        });

    }

});