// ==================================================
// add course image
// ==================================================
var show_uploaded_image = function(input_image) {

    if (input_image.files && input_image.files[0]) {

        var reader = new FileReader();

        reader.onload = function(event) {
            $('#course_image_container').css('background-image', 'url(' + event.target.result + ')');
            $('#course_image_container').css('border', 'none');
            $('#course_image_container label span').css('display', 'none');
        }

        reader.readAsDataURL(input_image.files[0]);
    }
};




// ==================================================
// listeners
// ==================================================
$('#course_image_input').change(function() {
    show_uploaded_image(this);
});
