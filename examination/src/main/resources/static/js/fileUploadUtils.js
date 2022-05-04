// 定长分割
function sliceFilesBySize(file, size) {
	if (!file) {
		return;
	}

	var fileList = [];
	var location = 0;
	while (location < file.size) {
		fileList.push(file.slice(location, location + size));
		location += size;
	}

	return fileList;
}

// 文件判断
function analysFile(file) {
	if (file == undefined) {
		alert("未上传文件");
		return false;
	} else {
		if (file.name.toLowerCase().endsWith(".zip")) {
			return true;
		} else {
			alert("文件类型错误，请确保上传的是.zip文件");
			return false;
		}
	}
}

// 文件上传
function uploadFlieSingle(file, fileName) {
	return new Promise(function(resolve, reject) {
		var formData = new FormData();
		formData.append("file", file);
		formData.append("fileName", fileName);

		$.ajax({
			type: "post",
			url: "/face/sliceUpload",
			data: formData,
			async: true,
			cache: false,
			processData: false,
			contentType: false,
			success: function(rst) {
				resolve(fileName.split("-")[0] + "-success");
			},
			error: function(rst) {
				reject(fileName.split("-")[0] + "-fail");
			},
		});

	});
}

// 上传入口
function upload() {
	var files = document.getElementById("files").files[0];

	if (!analysFile(files)) {
		return;
	} else {
		var fileList = sliceFilesBySize(files, 20 * 1024 * 1024);
		var name = files.name;
		var promise = [];

		$.each(fileList, (index, item) => {
			var fileName = index + "-" + name;
			var sliceFile = item;
			promise.push(uploadFlieSingle(sliceFile, fileName));
		});

		Promise.all(promise).then(function(res) {
			mergeFile(name, fileList.length);
		}).catch(function(err) {
			var span = document.getElementById("msg");
			span.innerText = "上传失败";
		});
	}
}

// 文件合并
function mergeFile(fileName, size) {
	var form = {
		"fileName": fileName,
		"size": size,
	};
	$.ajax({
		type: "post",
		url: "/face/mergeFile",
		data: form,
		success: function(rst) {
			if (rst) {
				var span = document.getElementById("msg");
				span.innerText = "上传成功，请耐心等待人脸注册结果";
				compressRegister(fileName);
			} else {
				var span = document.getElementById("msg");
				span.innerText = "文件上传成功，但暂时无法进行人脸注册，请联系管理员解决";
			}
		},
		error: function(rst) {
			var span = document.getElementById("msg");
			span.innerText = "上传文件发生了一些不被期待的错误，请联系管理员解决";
		},
	});
}

// 压缩文件-人脸注册
function compressRegister(fileName) {
	var form = {
		"fileName": fileName,
	};
	jQuery("/face/compressRegister",form,function (rst) {
		if(rst){
			var span = document.getElementById("msg");
			span.innerText = "全部人脸注册成功";
		}else{
			var span = document.getElementById("msg");
			span.innerText = "存在一些人脸认证失败";
		}
	});
}
