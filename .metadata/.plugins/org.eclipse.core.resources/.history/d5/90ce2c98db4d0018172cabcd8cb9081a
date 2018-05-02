<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%String rgPath=request.getContextPath();%>
	<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/common/js/jquery-1.3.2.min.js">
</script>
<title>照片采集</title>
	<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet"/>
    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>

<script type="text/JavaScript">
function setImg(obj){
	var f=$(obj).val();
    if(f == null || f ==undefined || f == ''){
        return false;
    }
    if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)){
        alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
        $(obj).val('');
        return false;
    }
    var element = $("#lyurl").val();
    $("#showSelectImage").attr("src",element);
    $("#url").attr("value",element);
	}
function setphoto(obj){
	var f=$(obj).val();
    if(f == null || f ==undefined || f == ''){
        return false;
    }
    if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(f)){
        alertLayel("类型必须是图片(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)");
        $(obj).val('');
        return false;
    }
    var element = $("#PhotofileName").val();
    alert(element);
    $("#showPhotoImage").attr("src",element);
	}
function selectFile(){ 
	//触发 文件选择的click事件 
	$("#lyurl").trigger("click"); 
	//其他code如 alert($("#file").attr("value")) 
	} 
function submit(){
    document.uploadimg.submit();
}
</script>
	</head>
	<body>
	
	<div class="col-xs-10">
                <div class="section-box">
                    <!--页面主体-->
                    <div class="center" style="padding-top:5px">
                        <object
						classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
						id="Anki_Photo_s" width="880" height="630"
						codebase="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">
						<param name="movie"
							value="<%=rgPath%>/jsp/Anki_Photo.swf" />
						<param name="quality" value="high" />
						<param name="bgcolor" value="#bdb5b5" />
						<param name="allowScriptAccess" value="sameDomain" />
						<param name="FlashVars"
							value="id=${ zjhm }&name=123&url=${ saveUrl } " />
						<embed
							src="<%=rgPath%>/jsp/Anki_Photo.swf"
							quality="high" bgcolor="#bdb5b5" width="450"
							height="326" name="Anki_Photo" align="middle"
							FlashVars="id=${ zjhm }&name=123&url=${ saveUrl } "
							play="true" loop="false" quality="high"
							allowScriptAccess="sameDomain"
							type="application/x-shockwave-flash"
							pluginspage="http://www.adobe.com/go/getflashplayer">
						</embed>
					</object>
                    </div>
                    <div>
                        <strong style="padding-left:30px">照片采集使用说明： </strong>
                        <ul>
                            <li>
                                1、如果您的视频采集区左上角出现一个近似正方形的小图标，请您安装Flash Player 10（
                                <a href="http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab">点击这里下载</a>）以上版本。
                            </li>
                            <li>
                                2、安装完成后，请刷新页面，即可进行在线视频照相。
                            </li>
                            <li>
                                3、当您点击〖开启本地视频〗按钮，弹出对话框时，请您选择〖允许〗，否则在线视频照相功能仍不能正常使用。
                            </li>
                        </ul>
                    </div>
                </div><!--section-box-->
            </div><!--col-xs-9-->
	<script type="text/javascript">	
		function DoReturnFlex(str) {
			opener.location.href='<%=rgPath%>/action/preGarher.do?zjhm=${FlowList.zjhm}';
    	}
	</script>
	 </body>
</html>