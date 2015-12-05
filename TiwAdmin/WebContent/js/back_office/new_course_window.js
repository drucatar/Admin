// ==================================================
// show/hide login screen in home page
// ==================================================
var show_new_course_window = function() {

    var new_course_window = $('#new_course_window'),
        back_office_dark_foreground = $('#back_office_dark_foreground');

    new_course_window.addClass('show_new_course_window');
    back_office_dark_foreground.addClass('show_back_office_dark_foreground');

};


var hide_new_course_window = function() {

    var new_course_window = $('#new_course_window'),
        back_office_dark_foreground = $('#back_office_dark_foreground');

    new_course_window.removeClass('show_new_course_window');
    back_office_dark_foreground.removeClass('show_back_office_dark_foreground');

};




// ==================================================
// listeners
// ==================================================

// login button shows login window
$('.back_office_new_course_button').click(function() {
    show_new_course_window();
});

// home login background hides login window
$('#back_office_dark_foreground').click(function() {
    hide_new_course_window();
});

// cancel button on login window hides login window
$('.back_office_new_course_form_cancel_button').click(function() {
    hide_new_course_window();
});
