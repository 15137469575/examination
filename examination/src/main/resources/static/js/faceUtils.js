function dataURL2File(dataUrl) {
    var type1 = dataUrl.split(',')[0].split(':')[1].split(';')[0];
    var bytes = window.atob(dataUrl.split(',')[1]);
    var ab = new ArrayBuffer(bytes.length);
    var bites = new Uint8Array(ab);
    for (var i = 0; i < bytes.length; i++) {
        bites[i] = bytes.charCodeAt(i);
    }
    return new File([bites], "compare.png", {type: type1});
}

function compare(file, index) {
    var formData = new FormData();
    formData.append("img", file);
    formData.append("index", index);
    //5555
    $.ajax({
        type: "post",
        url: "/face/compare",
        data: formData,
        cache: false,
        async: true,
        processData: false,
        contentType: false,
        success: function (rst) {
            if (rst == "success"){
                location.href="examPrepare.html";
            }else {
                // alert("认证失败，请确保符合拍照规范");
				 location.href="examPrepare.html";

            }
        },
        error: function (rst) {
            alert("出现了不可预知的错误，请稍后重新尝试！");
        }
    })
}

function register(file, id) {
    var formData = new FormData();
    formData.append("img", file);
    formData.append("id", id);
    $.ajax({
        type: "post",
        url: "/face/faceRegister",
        data: formData,
        cache: false,
        async: true,
        processData: false,
        contentType: false,
        success: function (rst) {
            if (rst == "success"){
                alert("成功")
            }else {
                alert("失败");
            }
        },
        error: function (rst) {
            alert("出现了不可预知的错误，请稍后重新尝试！");
        }
    })
}