// ==================================================
// show/hide login screen in home page
// ==================================================
var show_signup_window = function() {

    var home_signup_window = $('#home_signup_window'),
        home_dark_foreground = $('#home_dark_foreground');

    home_signup_window.addClass('show_home_form_window');
    home_dark_foreground.addClass('show_home_dark_foreground');

};


var hide_signup_window = function() {

    var home_signup_window = $('#home_signup_window'),
        home_dark_foreground = $('#home_dark_foreground');

    home_signup_window.removeClass('show_home_form_window');
    home_dark_foreground.removeClass('show_home_dark_foreground');

};




// ==================================================
// listeners
// ==================================================

// login button shows login window
$('#home_signup_button').click(function() {
    show_signup_window();
});

// home login background hides login window
$('#home_dark_foreground').click(function() {
    hide_signup_window();
});

// cancel button on login window hides login window
$('.home_form_window_cancel_button').click(function() {
    hide_signup_window();
});
