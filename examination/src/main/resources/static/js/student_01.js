window.onload = function() {
	var ulId = document.getElementById('ulId');
	ulId.onclick = function(event) {
		var event = event || window.event;
		var target = event.target || event.srcElement;
		if (target.tagName.toLowerCase() == 'button') {
			var tr = target.parentNode;
			tr.parentNode.removeChild(tr);
		}
	}
	var liArr = document.getElementsByTagName('li');
	var noticeNum = document.getElementById('noticeNum');
	noticeNum.innerText = liArr.length;
}
