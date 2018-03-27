$(document).ready(function () {

    $.ajax({
        url: "http://localhost:8070/shownews",
        type :'POST',
        contentType: 'application/json',
        datatype:'json',

        success: function(data) {

            console.log(data);
            $('#news_title').append(data.title);
            $('#news_content').append(data.content);
        },error: function (data) {
            console.log(data);
        }
    });

    return false;
});

$('#submit').on(function () {
    event.preventDefault();

    var data = new Object();
    data.title = $('#newnews_title').val();
    data.content = $('#newnews_content').val();


    $.ajax({
        url: "http://localhost:8070/my/news",
        type :'POST',
        contentType: 'application/json',
        data : JSON.stringify(data),
        datatype:'json',
        timeout:30000,

        success: function(data) {
            console.log(data);
            $('#news_title').append(data.title);
            $('#news_content').append(data.content);
        },error: function (data) {
            console.log(data);
        }
    });

    return false;
})