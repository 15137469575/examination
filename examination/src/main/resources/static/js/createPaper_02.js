window.onload = function() {

	var paperId = document.getElementById('paperId');

	var str = localStorage.getItem('id');
	if (str) {

		paperId.value = str;
		localStorage.removeItem('id');
	}
	window.onbeforeunload = function() {
		localStorage.setItem('id', paperId.value);
	}
}
