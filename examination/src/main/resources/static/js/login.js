function getMsg() {
    var id = document.getElementById("usernameText").value;
    var pwd = document.getElementById("passwordText").value;
    var form = {
        "userId": id,
        "userPassword": pwd,
    };
    jQuery.get("/user/login", form, function (rst) {
        if (rst.identidy == "student") {
            handleLocalStorage('set', 'userId', id);
            window.location.href = "student_01.html";
        } else if (rst.identidy == "teacher") {
            handleLocalStorage('set', 'userId', id);
            window.location.href = "createPaper.html";
        } else if (!rst) {
            alert("您的登录信息有误，请重新登录");
        }
    });
}