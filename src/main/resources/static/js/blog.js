$('#to').on('click',function (event) {
    event.preventDefault();

    var data = new Object();
    data.title = $('#b_title').val();
    data.content = $('#b_content').val();

    $.ajax({
        url:'/blog/s',
        type:'POST',
        dataType:'json',
        data:JSON.stringify(data),

        success:function (data) {
            console.log(data);
        },error:function (data) {
            console.log(data);
        }

    });

})
