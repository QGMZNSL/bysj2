<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript">
	    window.onload =function() { 
			var power = document.getElementById("enable1").value;	
				// 初始化多选框
				var chboxes = $(":radio");
				chboxes.attr("checked", false);
				if(power==1){
					$(chboxes[0]).attr("checked", true);
				}else{
					$(chboxes[1]).attr("checked", true);
				}
			};
	    
	    </script>
</head>
<body>
<div class="col-xs-10">
                <div class="section-box">
                    <!--页面主体-->
                    <form action="editUser.do" method="post">
                        <div class="form-horizontal create">
                           <c:forEach items="${edituserList}" var="eul">
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="zjhm">用户名</label>
                                <div class="col-sm-8">
                                    ${eul.userId}
                                    <input class="form-control text-box single-line" type="hidden" id="userid" name="userid" value="${eul.userId}" />
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">姓名</label>
                                <div class="col-sm-8">
                                    <input class="form-control text-box single-line" type="text" id="userName" name="userName" value="${eul.userName}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">原单位</label>
                                <div class="col-sm-8">
                                <input class="form-control text-box single-line" type="text" value="${eul.orgName}" />
                                </div>
                                </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">新单位</label>
                                <div class="col-sm-8">
                                    <select name="userOrg" id="userOrg" class="form-control text-box single-line" >
									<option value="${eul.userOrg}">
										--- 请选择 ---
									</option>
									<c:forEach items="${OrgTypelist}" var="ol">
										<option value="${ol.orgId}">
											${ol.orgName}
										</option>
									</c:forEach>
								</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">联系方式</label>
                                <div class="col-sm-8">
                                    <input class="form-control text-box single-line" type="text" id="userPhone" name="userPhone" value="${eul.userPhone}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">经办人</label>
                                <div class="col-sm-8">
                                    <input class="form-control text-box single-line" type="text" id="operater" name="operater" value="${eul.operater}"/>
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">是否启用</label>
                                <input type="hidden" value="${eul.enable}" id="enable1" name="enable1"/>
                                <div class="col-sm-8">
                                    <input type="radio" name="enable" id="enable" value="1"/>
									            启用
									<input type="radio" name="enable" id="enable" value="0"/>
									            禁用
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">原用户类型</label>
                                <div class="col-sm-8">
                                <input class="form-control text-box single-line" type="text" value="${eul.userRole}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">新用户类型</label>
                                <div class="col-sm-8">
                                    <select class="form-control text-box single-line" name="userType" id="userType">
											<option value="${eul.userType}">
												--- 请选择 ---
											</option>
											<c:forEach items="${UserTypelist}" var="ul">
												<option value="${ul.typeId}">
													${ul.typeName}
												</option>
											</c:forEach>
									</select>
									</div>
							</div>
							</c:forEach>
                        
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="noIdnoReason">密码</label>
                                <div class="col-sm-8">
                                    <input class="form-control text-box single-line" type="password" id="userpass" name="userpass" value="${eul.userPass}"/>
                                </div>
                            </div>
                            </div>
                            <div class="col-sm-offset-4 col-sm-8">
                            <input type="submit" value="确认修改" class="btn btn-primary" accesskey="S" style="font-size:18px;padding:3px 20px" />
                            <input type="button" value="返回" class="btn btn-primary" accesskey="S" style="font-size:18px;padding:3px 20px" onclick="javascript:history.back(-1);"/>
                            </div>
                        </div>
</form>
</div></div>

</body>
</html>