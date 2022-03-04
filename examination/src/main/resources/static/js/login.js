window.onload = function() {

	var studentLoginButton = document.getElementById('studentLoginButton');

	studentLoginButton.onclick = function() {

		location.href = 'student.html';

	}

	var teacherLoginButton = document.getElementById('teacherLoginButton');

	teacherLoginButton.onclick = function() {

		location.href = 'teacher.html';

	}

	var adminLoginButton = document.getElementById('adminLoginButton');

	adminLoginButton.onclick = function() {

		location.href = 'admin.html';

	}

}
