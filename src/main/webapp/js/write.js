$(document).ready(function() {
    // Trigger file input click when .image-upload is clicked
    $(document).on('click', '.image-upload', function() {
        $(this).find("input[type='file']").click();
    });

    // When file input changes (image is selected)
    $(document).on('change', "input[type='file']", function(event) {
        var preview = $("#preview");
        var file = event.target.files[0];

        var reader = new FileReader();
        reader.onload = function(e) {
            var imgContainer = $('<img src="' + e.target.result + '" alt="Uploaded Image"><button type="button" class="delete-button">X</button>');
            var parentDiv = $(event.target).closest('.image-upload');
            parentDiv.append(imgContainer);

           
            parentDiv.css('border', 'none');
            parentDiv.find('input[type="file"]').hide();
            parentDiv.find("i, p").hide();
            parentDiv.addClass('has-image');
        }
        reader.readAsDataURL(file);

        $(this).val(''); 
    });

    $(document).on('click', '.delete-button', function() {
        var parentDiv = $(this).parent();

        parentDiv.css('border', '2px dashed #ccc');
        parentDiv.find('img').remove();
        parentDiv.find('button').remove();
        parentDiv.find('input[type="file"]').val('').show();
        parentDiv.find("i, p").show();
        parentDiv.removeClass('has-image');

        var preview = $("#preview");
        if (preview.find('.image-upload.has-image').length < 4) {
            $('.image-upload:hidden').first().show();
        }
    });
});