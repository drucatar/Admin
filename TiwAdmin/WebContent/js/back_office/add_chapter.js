// ==================================================
// add chapter
// ==================================================
var chapter_count = 1;

var add_chapter = function() {

    // increase chapter count
    chapter_count += 1;

    // create DOM element to insert in html
    var input_container_to_add = "<div class='file_input_container'><input type='file' name='chapter_'" + chapter_count + "'_file' class='file_input' id='chapter_'" + chapter_count + "'_file' data-multiple-caption='{count} files selected' multiple><label for='chapter_'" + chapter_count + "'_file'><span>Chapter " + chapter_count + " File</span></label></div>";

    // insert
    $('.file_input_container_wrapper').append(input_container_to_add);
};




// ==================================================
// listeners
// ==================================================
$('.add_chapter_button').click(function() {
    add_chapter();
});




// ==================================================
// enhancement for input file
// ==================================================
var inputs = document.querySelectorAll( '.file_input' );
Array.prototype.forEach.call( inputs, function( input )
{
	var label	 = input.nextElementSibling,
		labelVal = label.innerHTML;

	input.addEventListener( 'change', function( e )
	{
		var fileName = '';
		if( this.files && this.files.length > 1 )
			fileName = ( this.getAttribute( 'data-multiple-caption' ) || '' ).replace( '{count}', this.files.length );
		else
			fileName = e.target.value.split( '\\' ).pop();

		if( fileName )
			label.querySelector( 'span' ).innerHTML = fileName;
		else
			label.innerHTML = labelVal;
	});
});
