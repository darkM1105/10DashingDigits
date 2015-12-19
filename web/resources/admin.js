$(document).ready(function(){

    var jc = $("button#justCreate");
    var cp = $("button#createAndPopulate");
    var d =  $("button#delete");
    var da = $("button#deleteAll");
    var trueCount = $("#trueCount");

    jc.click(function(){
        $.post("/admin", {'adminAction':'justCreate', 'count':$("#createCount").val()}, function(data){
            trueCount.innerHTML = ("<div>Word lists in database: " + data['trueCount'] + "</div>");
        })
    });

    cp.click(function(){
        $.post("/admin", {'adminAction':'createAndPopulate', 'count':$("#createAndPopulateCount").val(), 'countPer':$("#createAndPopulatePopulate")}, function(data){
            trueCount.innerHTML = ("<div>Word lists in database: " + data['trueCount'] + "</div>");
        })
    });

    d.click(function(){
        $.post("/admin", {'adminAction':'justDelete', 'count':$("#deleteCount").val()}, function(data){
            trueCount.innerHTML = ("<div>Word lists in database: " + data['trueCount'] + "</div>");
        })
    });

    da.click(function(){
        $.post("/admin", {'adminAction':'deleteAll'}, function(data){
            trueCount.innerHTML = ("<div>Word lists in database: " + data['trueCount'] + "</div>");
        })
    });

    $.get("/admin", function(data){
        trueCount.innerHTML = ("<div>Word lists in database: " + data['trueCount'] + "</div>");
    });


});