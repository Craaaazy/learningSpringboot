$(document).ready(function () { //改成button function

    var title = null;    //获取当前行json btitle

    $.ajax({
        url: "/blog/s" + title,
        type :'GET',
        dataType: 'json',
        dataSrc:'',

        success:function (data) {
            console.log(data);

            $('#blog-title').append(data[0].btitle);
            $('#blog-content').append(data[0].bcontent);

        },error:function (data) {
            console.log(data)
        }
    });


})