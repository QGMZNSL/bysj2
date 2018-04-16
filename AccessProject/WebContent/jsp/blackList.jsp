<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看黑名单</title>
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript">
	    function fanye(ye){
	    	var blackIdNo = document.getElementById("blackIdNo").value;
	    	window.location.href="blackList.do?pageNum="+ye+"&blackIdNo="+blackIdNo; 
	    }
	    </script>
</head>
<body>
<div class="col-xs-10">
                <div class="section-box">
                    <div>
                        <form action="blackList.do?pageNum=1" id="searchForm" method="post">
                            <div class="search">
                                <div class="row" >
                                    <div >
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号：
                                        <input type="text" id="blackIdNo" name="blackIdNo" value="${blackIdNo}">
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="submit" value="查找" class="btn btn-primary" accesskey="S">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div id="add">
                        <a href="jsp/addBlack.jsp"><span class="btn btn-default">添加黑名单</span></a>
                    </div>
                    <div id="kcs">
                        <div id="views">
                            <table class="table-rw">
                                <tbody>
                                    <tr>
                                        <th>身份证号</th>
                                        <th>原因</th>
                                        <th>操作</th>
                                    </tr>
                                    <tr>
                                    <c:if test="${ empty blackList}">
												<td colspan="3" align="center">
												无相应数据！
												</td>
                                    </c:if>
                                    <c:if test="${not empty blackList}">
                                        <c:forEach items="${blackList}" var="bl">
											<tr>
												<td>
												${bl.idNo}
												</td>
												<td>
												${bl.reason}
												</td>
												<td>
												<a href="removeBlack.do?idno=${bl.idNo}">删除</a>
												</td>
											</tr>
										</c:forEach>
                                    </c:if>
                                    </tr>  
                                </tbody>
                            </table>
                                    <ul class="pagination">
                                    <c:if test="${pageNum ne 1}">
                                    <li><a onclick="fanye(${pageNum-1});return false">&laquo;</a></li>
                                    </c:if> 
                                    <c:if test="${pageCount le 5}">
                                    <c:forEach var="i" begin="1" end="${pageCount+1-1}" step="1">
                                      <li><a onclick="fanye(${i});return false">${i}</a></li>
									</c:forEach>
                                    </c:if>
                                    <c:if test="${pageCount gt 5}">
                                    <c:if test="${pageNum le 2 }">
									  <c:forEach var="i" begin="1" end="${pageNum+4}" step="1">
                                      <li><a onclick="fanye(${i});return false">${i}</a></li>
									  </c:forEach>
									  </c:if>
									  <c:if test="${pageNum gt 2 }">
									  <c:forEach var="i" begin="${pageNum-2}" end="${pageNum+2}" step="1">
	                                    <li><a onclick="fanye(${i});return false">${i}</a></li>
										</c:forEach>
									  </c:if>
                                    </c:if> 
                                    <c:if test="${pageNum ne pageCount}">
									<li><a onclick="fanye(${pageNum+1});return false">&raquo;</a></li>
                                    </c:if> 
                                    </ul>
                        </div>
                    </div>
                </div>
            </div>

</body>
</html>