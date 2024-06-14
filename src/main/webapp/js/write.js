document.addEventListener('DOMContentLoaded', function() {
 
    document.querySelectorAll('.image-upload').forEach(function(element) {
        element.addEventListener('click', function(event) {
            
            if (!event.target.classList.contains('delete-button')) {
                var fileInput = this.querySelector("input[type='file']");
               /* if (fileInput) {
                    fileInput.click();
                }
                */
                event.stopPropagation();
            }
        });
    });


    document.querySelectorAll("input[type='file']").forEach(function(fileInput) {
        fileInput.addEventListener('change', function(event) {
            var file = event.target.files[0];
            
            if (!file) return;

            var reader = new FileReader();
            reader.onload = function(e) {
                var imgContainer = document.createElement('div');
                var img = document.createElement('img');
                img.src = e.target.result;
                img.alt = "Uploaded Image";
                var deleteButton = document.createElement('button');
                deleteButton.type = 'button';
                deleteButton.className = 'delete-button';
                deleteButton.textContent = 'X';

                imgContainer.appendChild(img);
                imgContainer.appendChild(deleteButton);

                var parentDiv = event.target.closest('.image-upload');
                parentDiv.appendChild(imgContainer);

                parentDiv.style.border = 'none';
                fileInput.style.display = 'none';
                var icon = parentDiv.querySelector("i");
                var paragraph = parentDiv.querySelector("p");
                if (icon) icon.style.display = 'none';
                if (paragraph) paragraph.style.display = 'none';
                parentDiv.classList.add('has-image');
            }
            reader.readAsDataURL(file);
        });
    });

    document.addEventListener('click', function(event) {
        if (event.target.classList.contains('delete-button')) {
            var parentDiv = event.target.closest('.image-upload');

            parentDiv.style.border = '2px dashed #ccc';
            var img = parentDiv.querySelector('img');
            var deleteButton = parentDiv.querySelector('.delete-button');
            if (img) img.remove();
            if (deleteButton) deleteButton.remove();
            var fileInput = parentDiv.querySelector('input[type="file"]');
            fileInput.value = '';
            fileInput.style.display = 'block';
            var icon = parentDiv.querySelector("i");
            var paragraph = parentDiv.querySelector("p");
            if (icon) icon.style.display = 'block';
            if (paragraph) paragraph.style.display = 'block';
            parentDiv.classList.remove('has-image');

            var preview = document.getElementById("preview");
            if (preview.querySelectorAll('.image-upload.has-image').length < 4) {
                var hiddenUploads = document.querySelectorAll('.image-upload[style="display: none;"]');
                if (hiddenUploads.length > 0) {
                    hiddenUploads[0].style.display = 'block';
                }
            }
        }
    });
});