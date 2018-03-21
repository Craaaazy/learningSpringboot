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