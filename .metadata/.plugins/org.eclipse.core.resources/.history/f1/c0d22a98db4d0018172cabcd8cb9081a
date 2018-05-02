<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能菜单</title>
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
</head>
<body>
    <div class="container content-body" style="float: right;width:30%">
        <div class="row">
            <div class="">
                <div class="sidebar">
                    <div class="sidebar-title">
                       	 功能菜单
                    </div>
                    <c:forEach items="${menulist}" var="ml" varStatus="i">
                    <div class="sub-title">
                        <a href="${ml.url}" target="rightFrame">${ml.treeName}</a>
                    </div>
					</c:forEach>
                </div>
            </div>
        </div>
    </div>
</body>
</html>