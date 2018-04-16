<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>用户管理</title>
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/js/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/jquery/jquery-1.3.2.min.js"></script>
		<script type="text/javascript">
		window.onload =function() { 
			var power = "${userRight}";
						// 初始化多选框
						var chboxes = $(":checkbox");
						chboxes.attr("checked", false);
						var ptVal = 0;
						for ( var i = 0; i < chboxes.length; i++) {
							ptVal = power.substring($(chboxes[i]).val() - 1, $(chboxes[i]).val());
							if ( ptVal == 1) 
							$(chboxes[i]).attr("checked", true);
						} 
			};
	</script>
</head>

	<body>
	<div class="col-xs-10">
	<form action="saveUserRight.do">
                <div class="section-box">
                   <div style="padding:20px">
                       <div>
                          <c:forEach items="${RightList}" var="rl" varStatus="ctNum">
								<td>
								${rl.menuId}.
								<input type="checkbox" name="pwrIndexes" id="pwrIndexes" value="${rl.menuId}"/>
								${rl.displayName}
							    </td>
						  </c:forEach>
                       </div>
                       <div style="margin-top:20px">
	                       <input type="hidden" id="rightUserId" name="rightUserId" value="${rightUserId}"/>
					       <input type="submit" value="保存" class="btn btn-primary" accesskey="S" style="font-size:18px;padding:3px 20px"/>
                       </div>
                   </div>
                </div><!--section-box-->
    </form>
            </div><!--col-xs-9-->
</body>
</html>