<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>在线评测系统</title>
	    
	    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="../assets/css/bootstrap.css" rel="stylesheet">
	    <link href="../assets/css/yhz.css" rel="stylesheet">
	    <script src="../Content/js/html5shiv.min.js"></script>
	    <script src="../Content/js/respond.js"></script>
	    <script src="../assets/css/jquery-1.10.2.min.js"></script>
</head>
<body>
 <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <div class="navbar-brand" style="display:inline;">在线评测系统</div>
            </div>
            <div class="navbar-collapse collapse">

                <form action="" id="logoutForm" method="post">
                    <input name="__RequestVerificationToken" type="hidden" value="lxn8TVWdVXH2D--PKXECf803v0PAOoe6ypTiFW-JWv4ntU879B2MSPLOLTcL9G66fTk4tIKJ5h7Q0P2nGKnoswT59PwXOH3jylZMhxeEPWzUz_KBjFuS_fW0e6536Kq3VpOZxNbAtVbjTDeYX3nY4w2">        
                    <div class="navbar-right loginpartial">
                        <span>欢迎您，${User.userName}/ <c:choose>
							<c:when test="${ User.userRole == 1}">学生用户</c:when>
							<c:when test="${ User.userRole == 2}">老师用户</c:when>
							<c:when test="${ User.userRole == 4}">管理员用户</c:when>
						</c:choose> </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="../Exit.do">注销</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>