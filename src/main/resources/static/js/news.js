$(document).ready(function() {
    $('#example').dataTable( {
        ajax: {
            url: '/my/news',

            success:function (data) {
                console.log(data)
            }
        },
        column:[
            {data:'title'},
            {data:'content'}
        ]
    } );
} );