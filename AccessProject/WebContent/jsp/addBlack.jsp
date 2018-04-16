<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加黑名单</title>
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript">
	    function checknext(){
		    var BusinessType = document.getElementById('bidNo');	
		    var Reason = document.getElementById('bReason');
		    
		    if(BusinessType.value == '') {
		        alert('请填写证件号码!');
		        return false;
		    }  	
		    if(Reason.value == '') {
		        alert('请填写原因!');
		        return false;
		    }  	
		}   
	    </script>
</head>
<body>
<div class="col-xs-10">
                <div class="section-box">
                    <!--页面主体-->
                    <form action="../addblackList.do" method="post" onsubmit="return checknext()">
                        <div class="form-horizontal create">
                           
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="zjhm">证件号码</label>
                                <div class="col-sm-8">
                                    <input class="form-control text-box single-line" data-val="true" id="bidNo" name="bidNo" type="text" value="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4" for="Reason">原因</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control text-box single-line" data-val="true" id="bReason" name="bReason" type="text" value=""></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-8">
                                    <input type="submit" value="提交" class="btn btn-primary" accesskey="S" style="font-size:18px;padding:3px 20px">
                                </div>
                            </div>
                        </div>
                    </form>
                    <script>
                        function formReset() {
                            $(':input', '#searchForm')
                           .not(':button,:submit,:reset,:hidden')
                           .val("")
                        }
                    </script>
                    <!--页面主体结束-->
                </div><!--section-box-->
            </div><!--col-xs-9-->
</body>
</html>