// ==================================================
// delete course in teacher back office
// ==================================================
var show_special_offer_window = function(course_id) {

    var special_offer_window = $('#special_offer_window'),
        back_office_dark_foreground = $('#back_office_dark_foreground');

    // get_course_special_offer(course_id);

    special_offer_window.addClass('show_special_offer_window');
    back_office_dark_foreground.addClass('show_back_office_dark_foreground');

};


var hide_special_offer_window = function() {

    var special_offer_window = $('#special_offer_window'),
        back_office_dark_foreground = $('#back_office_dark_foreground');

    special_offer_window.removeClass('show_special_offer_window');
    back_office_dark_foreground.removeClass('show_back_office_dark_foreground');

};




// ==================================================
// listeners
// ==================================================

// login button shows login window
$('#create_special_offer_button').click(function() {
    show_special_offer_window();
});

// home login background hides login window
$('#back_office_dark_foreground').click(function() {
    hide_special_offer_window();
});

// cancel button on login window hides login window
$('#cancel_create_special_offer_button').click(function() {
    hide_special_offer_window();
});
