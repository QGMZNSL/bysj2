<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%String rgPath=request.getContextPath();%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>课程详细</title>
  <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript">   
	    </script>
</head>
<body style="">
<%@ include file="top.jsp" %>
    <br/>
    <br/>
    <div class="container content-body">
        <div class="row">
            <div class="col-xs-3">
              <%@ include file="left.jsp" %>                           
            </div>
            <div class="col-xs-9">             
                <div class="section-box" style="text-align: center">            				
                    <!--页面主体-->                                   
                        <div class="search">                           
                            <div class="row">
                                <table class="table table-striped">
				                </table>     
				            </div><!--col-xs-9-->
				        </div>
	    			</div>
	    		</div>
	    </div>
    </div>
 <%@ include file="Dibutu.jsp" %>
</body>
</html>