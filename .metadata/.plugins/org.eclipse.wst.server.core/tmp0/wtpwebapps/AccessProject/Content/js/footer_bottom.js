
//window.onload 所有页面的文件下载完加载完再执行JS   
window.onload = function () {
    handleSuccess();
}

$(document).ready(function () {
    $(window).resize(function () {
        handleSuccess();
    });   
});

//计算高度是因为footer下边的黑条.footer高度没加上，有bug，才有此解决办法,否则直接用resize()
function handleSuccess() {

    var footerH = $("footer").height();
    //content - body  上下padding 20  
    if ($(".content-body").offset().top + $(".content-body").height() +40+ footerH > document.documentElement.clientHeight) {
        $("footer").removeClass("navbar-fixed-bottom");
    }
    else {
        $("footer").addClass("navbar-fixed-bottom");
    }
}

//function resize() {                
//        if (document.documentElement.scrollHeight > document.documentElement.clientHeight) {
//            $("footer").removeClass("navbar-fixed-bottom");
//        }
//        else {
//            $("footer").addClass("navbar-fixed-bottom");
//        }
//    }            
