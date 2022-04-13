window.onload = function() {
	var delete = document.getElementById('delete');
	delete.onclick = function(event) {
		var event = event || window.event;
		var target = event.target || event.srcElement;
		if (target.tagName.toLowerCase() == 'button') {
			var tr = target.parentNode;
			tr.parentNode.removeChild(tr);
		}
	}
	var trArr = document.getElementsByTagName('tr');
	
}
