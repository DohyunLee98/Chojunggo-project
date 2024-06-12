$(document).ready(function() {

	$("#imgUpload").change(function(event) {
		var preview = $("#preview");
		var file = event.target.files;

		/*var imgCount = preview.querySelectorAll('img').length;*/
		var imgCount = preview.find('img').length;
		var newImg = file.length;

		if (imgCount + newImg > 4) {
			alert("이미지는 최대 4개까지 업로드 가능합니다.");
			return;
		}

		if (preview.children.length === 1 && preview.children().first().is('p')) {
			preview.html('');
		}

		Array.from(file).forEach(file => {
			var reader = new FileReader();

			reader.onload = function(e) {
				/*var img = document.createElement('img');
				img.src = e.target.result;
				preview.appendChild(img);*/
				/*var img = $('<img>').attr('src', e.target.result);*/
				var img = $('<div class="image-container"><img src="' + e.target.result + '"><button type="button" class="delete-button">X</button></div>');

				preview.append(img);

				// 똑같은 이름의 이미지 연속으로 등록 시 등록 안되는 현상 발생 **
			}
			reader.readAsDataURL(file);
		});

		if (file.length + preview.find('img').length >= 4) {
			$('#img_file').hide();
		} else {
			$('#img_file').show();
		}
	});
});

$(document).on('click', '.delete-button', function() {
	var preview = $("#preview");
	var file = $("#imgUpload")[0].files;

	if (file.length + preview.find('img').length <= 3) {
		$('#img_file').show();
	}
	$(this).parent().remove();
});

/*$(document).on('click', '.delete-button', function() {

	if (file.length + preview.find('img').length < 3) {
		$('#img_file').show();
	}
	$(this).parent().remove();
});*/