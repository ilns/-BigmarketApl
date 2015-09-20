
var pageContent;
$(document).ready(function(){

    pageContent = $('#page-content-wrapper');

});

$(document).ready(function(){

    $('.e_nav').click(function(e){
        var path = $(e.target).data('path') || '/';
        $.get(path, function (html) {
            $('#page-content-wrapper').html(html);
        });
        return false;
    });

});


