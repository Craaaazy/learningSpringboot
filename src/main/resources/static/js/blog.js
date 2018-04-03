$(function () {

    $('#sumbit_btn').on('click', function (event) {
        event.preventDefault();

        var data = new Object();
        data.title = $('#b_title').val();
        data.content = $('#b_content').val();

        $.ajax({
            url:'/blog/s',
            type:'POST',
            contentType: 'application/json',
            dataType:'json',
            data:JSON.stringify(data),

            success:function (data) {
                console.log(data);
            },error:function (data) {
                console.log(data);
            }

        });

        return false;
    });
})


$(document).ready(function () {

    $('#myTable').dataTable({

        style: 'display',

        ajax: {
            url: '/blog/s',
            type: 'GET',
            dataType: 'json',
            dataSrc:'',
        },

        columnDefs:[
            {
                targets: 0,
                searching:false,
                ordering:false,
                render: function (data, type, row, meta) {
                    return '<center><input style="width: auto" type="checkbox"></center>';
                }
            },{
                targets:1,
                data:'btitle',
            },{
                targets:2,
                data:'bcontent',
            },{
                targets:3,
                searching:false,
                ordering:false,
                render: function (data, type, row, meta) {
                    return '<button type="button" class="btn btn-primary" onclick="deleteBlog(this)">delete</button>' +
                        '&nbsp;<button type="button" class="btn btn-secondary" onclick="showDetail(this)">detail</button>' +
                        '&nbsp;<button type="button" class="btn btn-danger" onclick="putBlog(this)">change</button>';
                }
            }
        ],

    });

});



function deleteBlog(_this) {
    var title = $(_this).parent().siblings().eq(1).text();
    console.log(title);

    $.ajax({
        url: '/blog/s/' + title,
        type: 'DELETE',
    })
}


function showDetail(_this) {  //转跳详细页 不会实现 暂时放着
    var title = $(_this).parent().siblings().eq(1).text();

}


function putBlog(_this) {  //更新 暂时不会

    // var data = new Object();
    // data.title = $(_this).parent().siblings().eq(1).text();
    // data.content = $(_this).parent().siblings().eq(2).text();
    //
    // $('#b_title').text(data.title);
    // $('#b_content').text(data.content);
    //
    // $.ajax({
    //     url:'/blog/s',
    //     type:'PUT',
    //     contentType: 'application/json',
    //     dataType:'json',
    //     data:JSON.stringify(data),
    //
    //     success:function (data) {
    //         console.log(data);
    //     },error:function (data) {
    //         console.log(data);
    //     }
    //
    // });
}
