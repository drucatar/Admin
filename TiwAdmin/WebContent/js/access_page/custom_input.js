// ==================================================
// custom inputs in signup form
// ==================================================
var select_custom_input = function(element) {

    var element_to_select_id = $(element).prev().attr('id'),
        element_to_select = document.getElementById(element_to_select_id);

    if (element_to_select.checked) {

        if (element_to_select.type == 'checkbox')
            element_to_select.checked = false;

    } else
        element_to_select.checked = true;
};




// ==================================================
// listeners
// ==================================================
$('.custom_input_container label').click(function(event) {
    select_custom_input(event.target);
});
