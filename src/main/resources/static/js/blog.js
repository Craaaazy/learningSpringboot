$(function () {

    $('#delete_btn').on('click', function () {

        var title = $(this).parent("td").siliblings(1).text;
        alert(title);

        // $.ajax({
        //     url: '/blog/s/' + title,
        //     type: 'delete',
        //
        // })

    });

    $('#detail_btn').on('click',function () {

        //getTitle.
        //to showBlog Page.


    })

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
                    return '<center><input type="checkbox"></center>';
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
                        '&nbsp;<button type="button" class="btn btn-secondary" id="detail_btn">detail</button>';
                }
            }
        ],

    });

});

function deleteBlog(_this) {
    var title = $(_this).parent().siblings().eq(1).text();
    console.log(title)

    $.ajax({
        url: '/blog/s/' + title,
        type: 'DELETE',

    })

}

