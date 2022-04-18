
	$(document).ready(function() {
		$("#object_select").change(function() {
			($("#object_select").val());
		});
	});
	$("#creatPaper").on("click", function() {
		if ($("#object_select").val() == -1) {
			alert("请选择考试科目");
		} else {
			
			var form = {
				"object": $("#object_select").val(),
				"teacherName": $("#teacherName").val(),
				"questionNumber": $("#questionNumber").val(),
				"normal": $("#normal").val()
			};

			$.get("paperInformation/insert", form, function(res) {
				var subject = document.getElementById('object_select').value;
				// alert(object.value);
				handleLocalStorage("set","subject",subject);
				var paperId = document.getElementById('paperId');
				paperId.value = res;
			})
		}
	})

