// 轮播功能
var num = 1;
var flag;
var init1;  //正常速度轮播
var init2;  //减速×1轮播
var init3;  //减速×2轮播
var init4;  //加速×1轮播
var init5;  //加速×2轮播
var car_btn_play = document.getElementById("car_btn_play");
var car_btn_low = document.getElementById("car_btn_low");
var car_btn_high = document.getElementById("car_btn_high");

//自动轮播
var f = function () {
    if (num === 1) {
        document.getElementById("above").innerText = ("上刀山");
        document.getElementById("below").innerText = ("下火海");
    }
    if (num === 2) {
        document.getElementById("above").innerText = ("左青龙");
        document.getElementById("below").innerText = ("右白虎");
    }
    if (num === 3) {
        document.getElementById("above").innerText = ("托儿索");
        document.getElementById("below").innerText = ("儿童劫");
    }
    if (num === 4) {
        document.getElementById("above").innerText = ("abcd");
        document.getElementById("below").innerText = ("dcba");
    }
    if (num === 5) {
        document.getElementById("above").innerText = ("你是疯子");
        document.getElementById("below").innerText = ("也是傻子");
        num = 1;
    }
    num++;
    console.log("action");
    return f;
};

//手动轮播
function left() {
    num--;
    if (num < 1) {
        num = 5;
    }
    if (num === 1) {
        document.getElementById("above").innerText = ("上刀山");
        document.getElementById("below").innerText = ("下火海");
    }
    if (num === 2) {
        document.getElementById("above").innerText = ("左青龙");
        document.getElementById("below").innerText = ("右白虎");
    }
    if (num === 3) {
        document.getElementById("above").innerText = ("托儿索");
        document.getElementById("below").innerText = ("儿童劫");
    }
    if (num === 4) {
        document.getElementById("above").innerText = ("abcd");
        document.getElementById("below").innerText = ("dcba");
    }
    if (num === 5) {
        document.getElementById("above").innerText = ("你是疯子");
        document.getElementById("below").innerText = ("也是傻子");
    }
}

function right() {
    num++;
    if (num > 5) {
        num = 1;
    }
    if (num === 1) {
        document.getElementById("above").innerText = ("上刀山");
        document.getElementById("below").innerText = ("下火海");
    }
    if (num === 2) {
        document.getElementById("above").innerText = ("左青龙");
        document.getElementById("below").innerText = ("右白虎");
    }
    if (num === 3) {
        document.getElementById("above").innerText = ("托儿索");
        document.getElementById("below").innerText = ("儿童劫");
    }
    if (num === 4) {
        document.getElementById("above").innerText = ("abcd");
        document.getElementById("below").innerText = ("dcba");
    }
    if (num === 5) {
        document.getElementById("above").innerText = ("你是疯子");
        document.getElementById("below").innerText = ("也是傻子");
    }
}

//播放和暂停轮播轮播
function play() {
    if (car_btn_play.textContent.match("播放")) {
        if (car_btn_high.textContent.match("×2")) {
            init5 = setInterval(f(), 500); //加速×2轮播
        }
        if (car_btn_high.textContent.match("×1")) {
            init4 = setInterval(f(), 1000); //加速×1轮播
        }
        if (car_btn_low.textContent.match("×2")) {
            init3 = setInterval(f(), 7000); //减速×2轮播
        }
        if (car_btn_low.textContent.match("×1")) {
            init2 = setInterval(f(), 5000); //减速×1轮播
        }
        if (!car_btn_high.textContent.match("×2") && !car_btn_high.textContent.match("×1") &&
            !car_btn_low.textContent.match("×2") && !car_btn_low.textContent.match("×1")) {
            init1 = setInterval(f(), 3000); //正常速度轮播
        }
        car_btn_play.innerText = ("暂停");
    } else {
        clearInterval(init1);
        clearInterval(init2);
        clearInterval(init3);
        clearInterval(init4);
        clearInterval(init5);
        car_btn_play.innerText = ("播放");
    }
}

//减速轮播
function low() {
    if (car_btn_low.textContent.match("×2")) {
        init1 = setInterval(f(), 3000); //正常速度轮播
        clearInterval(init2);
        clearInterval(init3);
        clearInterval(init4);
        clearInterval(init5);
        car_btn_low.innerText = ("减速");
        car_btn_high.innerText = ("加速");
    } else if (car_btn_low.textContent.match("×1")) {
        clearInterval(init1);
        clearInterval(init2);
        init3 = setInterval(f(), 7000); //减速×2轮播
        clearInterval(init4);
        clearInterval(init5);
        car_btn_low.innerText = ("减速×2");
        car_btn_high.innerText = ("加速");
    } else {
        clearInterval(init1);
        init2 = setInterval(f(), 5000); //减速×1轮播
        clearInterval(init3);
        clearInterval(init4);
        clearInterval(init5);
        car_btn_low.innerText = ("减速×1");
        car_btn_high.innerText = ("加速");
    }
}

//加速轮播
function high() {
    if (car_btn_high.textContent.match("×2")) {
        init1 = setInterval(f(), 3000); //正常速度轮播
        clearInterval(init2);
        clearInterval(init3);
        clearInterval(init4);
        clearInterval(init5);
        car_btn_high.innerText = ("加速");
        car_btn_low.innerText = ("减速");
    } else if (car_btn_high.textContent.match("×1")) {
        clearInterval(init1);
        clearInterval(init2);
        clearInterval(init3);
        clearInterval(init4);
        init5 = setInterval(f(), 500); //加速×2轮播
        car_btn_high.innerText = ("加速×2");
        car_btn_low.innerText = ("减速");
    } else {
        clearInterval(init1);
        clearInterval(init2);
        clearInterval(init3);
        init4 = setInterval(f(), 1000); //加速×1轮播
        clearInterval(init5);
        car_btn_high.innerText = ("加速×1");
        car_btn_low.innerText = ("减速");
    }
}