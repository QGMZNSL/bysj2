
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml" >
<%String rgPath=request.getContextPath();%>
<head>
<title>日常照相</title>
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/js/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript">
	    function qingkong()
	    {
	    	document.getElementById("idCardfrom").reset();
	    }
	    function checknext(){
		    var BusinessType = document.getElementById('BusinessType');		    
		    if(BusinessType.value == '') {
		        alert('请选择业务类型!');
		        return false;
		    }  		    
		}   
	    </script>
</head>
<body style="text-align: center">
<div class="col-xs-10">
                <div class="section-box">
                    <!--页面主体-->
                    <form action="carId.do" id="idCardfrom" method="post" onsubmit="return checknext()">
                    <input type="hidden" id="ymlx" name="ymlx" value="idCard">
                        <div class="search">
                            <div class="row">
                                <div class="center">
                                <table width="100%">
                                	<tr>
                                		<td>
                                			 姓名：<input id="name" name="name" readonly="readonly">
                                		</td>
                                		<td>
                                			  性别：<input id="xb" name="xb" readonly="readonly">
                                		</td>
                                		<td>
                                			身份证号：<input id="zjhm" name="zjhm" readonly="readonly" value="111">
                                		</td>
                                		<td>
                                		<input type="hidden" id="idcardPhotoBuff" name="idcardPhotoBuff" readonly="readonly" value="111">
                                		</td>
                                	</tr>
                                </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 center">
                                <table width="1000">
                                	<tr>
                                		<td>
                                			 业务类型：
			                                    <select name="BusinessType" id="BusinessType">
													<option value="">
														--- 请选择 ---
													</option>
													<c:forEach items="${businesslist}" var="bl">
														<option value="${bl.businessType}">
															${bl.businessType}
														</option>
													</c:forEach>
												</select>
                                		</td>
                                		<td>
                                			 <input type="submit" value="确定" class="btn btn-primary" accesskey="S">&nbsp;&nbsp;&nbsp;&nbsp;
                                             <input type="button" onclick="qingkong()" value="清空" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;
                                		</td>
                                	</tr>
                                </table> 
                                </div>
                            </div>
                        </div>
                    </form>
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
                    <!--页面主体结束-->
                </div><!--section-box-->
            </div><!--col-xs-9-->
<script type="text/javascript" src="<%=request.getContextPath()%>/idcard/idcard.js"></script>
<script type="text/javascript">
	//实现者注意：请根据实际替换等号后的网页标题
	window.document.title = "信息采集";
	var runSign = 0;
	var t;
	window.onload = function() {
		if(initial("showInfo")!=0){
			setTimeout("window.location.reload()", 10000);
		}
		else{
			t = setTimeout("forRead()", 500);
		}
	};

	function init() {
		initial("showInfo");
		chkRunSign(runSign);
	}

	function forRead() {
		var reader = readIdCard(0, "showInfo");
		if( reader == -1){
			t = setTimeout("forRead()", 2000);
			return;
		}
		else
		{		
			alert("read");
			document.getElementById("name").value = reader.Name;
			document.getElementById("xb").value = parseInt(reader.Sex) == '1'?'男':'女';
			document.getElementById("zjhm").value = reader.IDNo;
			document.getElementById("idcardPhotoBuff").value = reader.PhotoBuffer;
		}
	}
	   function checknext(){
		    var BusinessType = document.getElementById('BusinessType');		    
		    if(BusinessType.value == '') {
		        alert('请选择业务类型!');
		        return false;
		    }  		    
		}   
</script>
</body>
</html>
