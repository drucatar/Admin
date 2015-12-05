// ==================================================
// handle desktop menu
// ==================================================
var open_desktop_menu = function() {

    var desktop_menu = $('#desktop_menu');
    desktop_menu.addClass('show_desktop_menu');
};

var close_desktop_menu = function() {

    var desktop_menu = $('#desktop_menu');
    desktop_menu.removeClass('show_desktop_menu');
};




// ==================================================
// listeners
// ==================================================
$('#open_desktop_menu').click(function() {
    open_desktop_menu();
});

$('#close_desktop_menu').click(function() {
    close_desktop_menu();
});

// $("body > *").not("#desktop_menu").click(function() {
//     if ($('#desktop_menu').hasClass('show_desktop_menu'))
//         close_desktop_menu();
// });

$(window).scroll(function() {
    if ($('#desktop_menu').hasClass('show_desktop_menu'))
        close_desktop_menu();
});
