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
    <title>在线评测系统</title>
        <link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript"> 
	    function finCourse(courseIds,proRole,i){
	    	var zdt = document.getElementById("zdt"+i);
	    	var ta = "#tPro"+i;
	    	if(zdt.value=="zd"){
            zdt.value = "sq";
	    	var zd= document.getElementById("zd"+i);
	    	zd.src = "<%=request.getContextPath()%>/img/sq.png";
	    	$.ajax({
				type : "post",
				data:{
					courseIds: courseIds,
					proRole: proRole
	            },
				url : "<%=request.getContextPath()%>/course.do?",
				async : false,
				success : function(data) {
					var jsonData = JSON.parse(data);
					$.each(jsonData,function(i,n){
						$(ta).append("<tr><td><a href='<%=request.getContextPath()%>/jsp/shipin.jsp?projectId="+n.proId+"'>"+n.proName+"</td></tr>");
					})
				}
			});
	    	}else{
	    		zdt.value = "zd";	
		    	var zd= document.getElementById("zd"+i);
		    	zd.src = "<%=request.getContextPath()%>/img/zd.png";
		    	$(ta).html("");
	    	}
	    }
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
                                <table class="table table-striped" >
				                        <tr>
				                        <td align="center">
				                       	 课程
				                        </td>
				                        <td>
				                       	 学分
				                        </td>
				                        <td>
				                       	 课时
				                        </td>
				                        <td>
				                       	 任课老师
				                        </td>
				                        </tr>
				                        <c:forEach items="${courseList}" var="cl" varStatus="i">
				                        <tr>
				                        <td align="center">
				                        <input type="hidden" value="zd" id="zdt${i.count}"/>
				                       	 <a onclick="finCourse(${cl.courseId},1,${i.count});">
				                       	 <img src="<%=request.getContextPath()%>/img/zd.png" id="zd${i.count}" height="15" width="15">&nbsp;&nbsp;${cl.courseName}</a>
				                        </td>
				                        <td>
				                       	${cl.courseGra}
				                        </td>
				                        <td>
				                       	 ${cl.courseTime}
				                        </td>
				                        <td>
				                       	 ${cl.courseTea} 
				                        </td>
				                        </tr>
				                        <tr>
				                        <td colspan="4" >
				                        <table id="tPro${i.count}" class="table table-striped">
				                        </table>
				                        </td>
				                        </tr>
				                        </c:forEach>
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