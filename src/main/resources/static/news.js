$(document).ready(function () {
    .ajax({
        url:'my/news',
        type:'GET',
        contentType: 'application/json',
        datatype:'json',

        success:function (data) {
            console.log(data);
            $('#a').append('<p>' + data.id + '</p>');
            $('#a').append('<p>' + data.title + '</p>');
            $('#a').append('<p>' + data.content + '</p>');
        },error:function (data) {
            console.log(data);
        }

    });
})


