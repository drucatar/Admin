// ==================================================
// delete course in teacher back office
// ==================================================
var show_delete_course_window = function() {

    var delete_course_window = $('#delete_course_window'),
        back_office_dark_foreground = $('#back_office_dark_foreground');

    delete_course_window.addClass('show_delete_course_window');
    back_office_dark_foreground.addClass('show_back_office_dark_foreground');

};


var hide_delete_course_window = function() {

    var delete_course_window = $('#delete_course_window'),
        back_office_dark_foreground = $('#back_office_dark_foreground');

    delete_course_window.removeClass('show_delete_course_window');
    back_office_dark_foreground.removeClass('show_back_office_dark_foreground');

};




// ==================================================
// listeners
// ==================================================

// login button shows login window
$('.delete_course_button').click(function() {
    show_delete_course_window();
});

// home login background hides login window
$('#back_office_dark_foreground').click(function() {
    hide_delete_course_window();
});

// cancel button on login window hides login window
$('#cancel_delete_course_button').click(function() {
    hide_delete_course_window();
});
