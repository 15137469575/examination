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
    $.ajax({
        type: "post",
        url: "/face/compare",
        data: formData,
        cache: false,
        async: true,
        processData: false,
        contentType: false,
        success: function (rst) {
            if (rst == "成功"){
                location.href="examPrepare.html";
            }else {
				console.log(rst);
                alert("999");
            }
        },
        error: function (rst) {
            alert("333");
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
            if (rst == "�ɹ�"){
                alert("�ɹ�")
            }else {
                alert("ʧ��");
            }
        },
        error: function (rst) {
            alert("�����˲���Ԥ֪�Ĵ������Ժ����³��ԣ�");
        }
    })
}