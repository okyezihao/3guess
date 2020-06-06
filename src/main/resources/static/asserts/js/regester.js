// 注册信息校验
function nameBlur() {
    var username = document.getElementById("username");
    var re = /^[a-zA-Z0-9_]{6,18}$/;
    if (username.value === "") {
        document.getElementById("nameError").innerText = "用户名不能为空！";
    } else if (username.value.length < 6 || username.value.length > 18) {
        document.getElementById("nameError").innerText = "格式错误，长度应为6—18个字符！";
    } else if (!re.test(username.value)) {
        document.getElementById("nameError").innerText = "格式错误，只能包含英文字母、数字和下划线！";
    } else {
        document.getElementById("nameError").innerText = "";
    }
}

function nameFocus() {
    document.getElementById("nameError").innerText = "";
}

//密码校验
function pwdBlur() {
    var userpwd = document.getElementById("userpwd");
    if (userpwd.value === "") {
        document.getElementById("pwdError").innerText = "密码不能为空！";
    } else if (userpwd.value.length < 6) {
        document.getElementById("pwdError").innerText = "格式错误，密码长度至少为6位！";
    } else {
        document.getElementById("pwdError").innerText = "";
    }
}

function pwdFocus() {
    document.getElementById("pwdError").innerText = "";
}

// 确认密码校验
function pwd_trueBlur() {
    var userpwd = document.getElementById("userpwd");
    var userpwd_true = document.getElementById("userpwd_true");
    if (userpwd_true.value === "") {
        document.getElementById("pwd_trueError").innerText = "确认密码不能为空！";
    } else if (userpwd_true.value != userpwd.value) {
        document.getElementById("pwd_trueError").innerText = "两次密码输入不一致！";
    } else {
        document.getElementById("pwd_trueError").innerText = "";
    }
}

function pwd_trueFocus() {
    document.getElementById("pwd_trueError").innerText = "";
}


function emailBlur() {
    var email = document.getElementById("email");
    if (email.value === "") {
        document.getElementById("emailError").innerText = "邮箱不能为空！";
    } else {
        document.getElementById("emailError").innerText = "";
    }
}

function emailFocus() {
    document.getElementById("emailError").innerText = "";
}