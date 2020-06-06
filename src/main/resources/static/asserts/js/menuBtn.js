// 菜单按钮
function click_btn_my() {
    var content = document.getElementById("content");
    var btn_xhy = document.getElementById("btn_xhy");
    var btn_cl = document.getElementById("btn_cl");
    if (content.style.display === "block") {
        content.style.display = "none";
        btn_xhy.style.left = "0px";
        btn_cl.style.left = "0px";
    } else {
        content.style.display = "block";
        btn_xhy.style.left = "1000px";
        btn_cl.style.left = "1000px";
    }
}

function click_btn_xhy() {
    var content = document.getElementById("content");
    var btn_my = document.getElementById("btn_my");
    var btn_xhy = document.getElementById("btn_xhy");
    var btn_cl = document.getElementById("btn_cl");
    if (content.style.display === "block") {
        content.style.display = "none";
        btn_my.style.left = "0px";
        btn_xhy.style.left = "0px";
        btn_cl.style.left = "0px";
    } else {
        content.style.display = "block";
        btn_my.style.left = "-1000px";
        btn_xhy.style.left = "-265px";
        btn_cl.style.left = "1000px";
    }
}

function click_btn_cl() {
    var content = document.getElementById("content");
    var btn_xhy = document.getElementById("btn_xhy");
    var btn_my = document.getElementById("btn_my");
    var btn_cl = document.getElementById("btn_cl");
    if (content.style.display === "block") {
        content.style.display = "none";
        btn_xhy.style.left = "0px";
        btn_my.style.left = "0px";
        btn_cl.style.left = "0px"
    } else {
        content.style.display = "block";
        btn_xhy.style.left = "-1000px";
        btn_my.style.left = "-1000px";
        btn_cl.style.left = "-530px";
    }
}