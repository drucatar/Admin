// ==================================================
// handle desktop menu
// ==================================================
var show_search_input = function() {

    var search_input = $('#desktop_nav_search_input');
    search_input.addClass('show_search_input');
};

var hide_search_input = function() {

    var search_input = $('#desktop_nav_search_input');
    search_input.removeClass('show_search_input');
};




// ==================================================
// listener
// ==================================================
$('.desktop_nav_search_form a').click(function() {
    show_search_input();
});

$("body > *").not("nav").click(function() {
    if ($('#desktop_nav_search_input').hasClass('show_search_input'))
        hide_search_input();
});

$(window).scroll(function() {
    if ($('#desktop_nav_search_input').hasClass('show_search_input'))
        hide_search_input();
});
