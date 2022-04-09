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
	var toCreate = document.getElementById("toCreate");
	toCreate.onclick = function(){
		if(!paperId.value){
			alert("请先创建试卷");
		}
		else{
			window.location.href = "makePaperInPerson.html";
		}
	}
}
