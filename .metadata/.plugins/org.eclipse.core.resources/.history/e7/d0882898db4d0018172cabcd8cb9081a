<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>手工录入信息</title>
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<script type="text/javascript">
    function checknext(){   
    
		var IdnoType = document.getElementById('IdnoType');          
	    var zjhm = document.getElementById('zjhm');
	    var noIdnoReason = document.getElementById('noIdnoReason'); 
	    var BusinessType = document.getElementById('BusinessType');
// 	    var sfz=/^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$/;
	    var sfz=/^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/
	    var jgz =/^[\u4e00-\u9fa5]{1}[0-9]*$/
	    var hz =/^(G|E){1}[0-9]{8}$/
	    var sbz =/^[0-9]{7}$/
	    if(BusinessType.value == '') {
	        alert('请选择业务类型!');
	        return false;
	    }  
	    
	    if(IdnoType.value == '') {
	        alert('请选择证件类型!');
	        return false;
	    }
	    
		if(zjhm.value == '') {
	        alert('请输入证件号码!');
	        return false;
	    }
	    
	    if(noIdnoReason.value == '') {
	        alert('请填写未采集身份证原因!');
	        return false;
	    }	
	    
	    if(IdnoType.value == '身份证') {
	        if (!sfz.test(zjhm.value)) {
				alert("请输入正确的身份证号！");				
	            return false;
			}	
	    }	
	    
	    if(IdnoType.value == '军官证') {	       
	        if (!jgz.test(zjhm.value)) {
				alert("请输入正确的军官证号！");				
	            return false;
			}	
	    }
	    
	     if(IdnoType.value == '护照') {
	        
	        if (!hz.test(zjhm.value)) {
				alert("请输入正确的护照编号！");				
	            return false;
			}	
	    }	
	        
	    if(IdnoType.value == '士兵证') {	       
	        if (!sbz.test(zjhm.value)) {
				alert("请输入正确的士兵证编号！");				
	            return false;
			}	
	    }
	    	
	}
</script>
<div class="col-xs-10">
                <div class="section-box">
                    <!--页面主体-->
                    <form action="checkMess.do" onsubmit="return checknext()" method="post">
                        <input type="hidden" id="ymlx" name="ymlx" value="idhand">
                        <div class="form-horizontal create">
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="BusinessType">业务类型</label>
                                <div class="col-sm-8">
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
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4" for="Username">证件类型</label>
                                <div class="col-sm-8">
                                    <select name="IdnoType" id="IdnoType">
										<option value="">
											--- 请选择 ---
										</option>
										<c:forEach items="${handList}" var="idNoType">
											<option value="${idNoType.type}">
												${idNoType.type}
											</option>
										</c:forEach>
								</select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4" for="zjhm">证件号码</label>
                                <div class="col-sm-8">
                                    <input class="form-control text-box single-line" data-val="true" id="zjhm" name="zjhm" type="text" value="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">手工采集原因</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control text-box single-line" data-val="true" id="noIdnoReason" name="noIdnoReason" type="text" value=""></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-4 col-sm-8">
                                    <input type="submit" value="下一步" class="btn btn-primary" accesskey="S" style="font-size:18px;padding:3px 20px">
                                </div>
                            </div>
                        </div>
                    </form>
                    <!--页面主体结束-->
                </div><!--section-box-->
            </div><!--col-xs-9-->
</body>
</html>