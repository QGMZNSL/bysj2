<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>java在线评测系统</title>

        <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>

    <style>
        body {
            text-align: center;
            background: #F7FAFC;
            overflow: hidden;
            background: #fff;
            background-color: #1891d8;
        }

        #canvas {
            position: absolute;
            left: 0px;
            top: 0px;
            z-index: -1;
            display: inline-block;
        }
    </style>
    <script type="text/javascript">
 	function checklogin(){ 
 		var no = document.getElementById("userName");         
 	    var pwd = document.getElementById("userPass"); 
 	    if(no.value == "") {
 	        alert('请输入用户名!'); 
 	        return false;
 	    } 
 	     if(pwd.value == "") {
 	        alert('请输入密码!'); 
 	        return false;
 	    }  
 	    
 	} 
 </script>
</head>

<body class="login-layout light-login vertical-center">
    <div class="main-container">
        <div class="main-content">
            <div class="row ">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="login-container">
                        <div class="center">
                            <br />
                            <br />
                            <br />
                            <br />
                            <br />
                            <br />
                            <h2>
                                <span class="white">
                                    <img src="Content/Image/top.png" class="img-responsive" style="max-height:70px" />
                                </span>
                                <span class="white">在线评测系统</span>
                            </h2>
                            <h4 class="white" id="id-company-text">&copy;--java教育 </h4>
                        </div>

                        <div class="space-6"></div>

                        <div class="position-relative">
                            <div id="login-box" class="login-box visible widget-box no-border">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <h4 class="header lighter bigger">
                                            <i class="ace-icon fa fa-bullhorn"></i>
                                                                                                                        请输入您的信息
                                        </h4>

                                        <div class="space-6"></div>

                                       
                                            <form action="login.do" class="form-horizontal" method="post" onsubmit="return checklogin()">
                                                <input name="__RequestVerificationToken" type="hidden" value="VW0RfoySbpKr-0gHl1pu2sfK8siWc8JfRYkO1pt4V-fqN6lPN7w49GUMk4-4eNdnsIdD-1WM5nvqAk-a-9WzKiNVvHARh2VA0BiwchDZjTi3zW46_t2Jn6CpgprLtEQH59-jfUvH416rUHi2kD8zAQ2">                                                <div class="form-group">
                                                    <label class="col-md-3 control-label" for="Username">用户名</label>
                                                    <div class="col-md-9">
                                                        <input class="form-control" type="text" name="userName" id="userName" >
                                                        <span class="field-validation-valid text-danger" data-valmsg-for="Username" data-valmsg-replace="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label" for="Password">密    码</label>
                                                    <div class="col-md-9">
                                                        <input class="form-control" type="password" name="userPass" id="userPass">
                                                        <span class="field-validation-valid text-danger" data-valmsg-for="Password" data-valmsg-replace="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-offset-2 col-md-10">
                                                        <input type="submit" value="登录" class="btn btn-primary" style="padding: 5px 50px"/>
                                                        <input type="button" value="注册" class="btn btn-primary" style="padding: 5px 50px"/>
                                                    </div>
                                                </div>
                                            </form>
                                        <div class="space-4"></div>
                                        <div class="social-or-login left">
                                            <span class="bigger-110">若忘记密码，请点击此处-><a href=""><span class="bigger-110"> 修改密码</span></a>！</span>
                                        </div>
                                    </div><!-- /.widget-main -->

                                </div><!-- /.widget-body -->
                            </div><!-- /.login-box -->

                        </div>

                    </div>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container -->
    <canvas id="canvas"></canvas>
</body>
</html>