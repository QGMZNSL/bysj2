<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户权限管理</title>
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript">
	     function qingkong()
	    {
	    	document.getElementById("searchForm").reset();
	    }
	    function fanye(ye){
	    	var userType = document.getElementById("userType").value;
	    	var userOrg = document.getElementById("userOrg").value;
	    	var userid = document.getElementById("userid").value;
	    	window.location.href="userRightsList.do?pageNum="+ye+"&userid="+userid+"&userOrg="+userOrg+"&userType="+userType; 
	    }
	    </script>
</head>
<body>
<div class="col-xs-10">
                <div class="section-box">
                    <form action="userRightsList.do?pageNum=1" id="searchForm" method="post">
                        <div class="search">
                            <div class="row">
                                <div class="col-sm-4">
                                    	用户类型：
                                    <select name="userType" id="userType">
                                    <c:if test="${ not empty userType}">
<%--                                     <c:forEach items="${UserTypelist}" var="ul" varStatus="vi"> --%>
<%-- 										<option value="${userType}"> --%>
<%-- 		                                    <c:if test="${userType==vi}"> --%>
<%-- 											 ${UserTypelist[vi-1].typeName} --%>
<%-- 		                                    </c:if> --%>
<!-- 	                                    </option> -->
<%-- 									</c:forEach> --%>
                                    <option value="${userType}">
                                    <c:if test="${userType==1}">
									 ${UserTypelist[0].typeName}
                                    </c:if>
                                    <c:if test="${userType==2}">
									 ${UserTypelist[1].typeName}
                                    </c:if>
                                    <c:if test="${userType==3}">
									 ${UserTypelist[2].typeName}
                                    </c:if>
                                    </option>
                                    </c:if>
									<option value="">
										--- 全部 ---
									</option>
									<c:forEach items="${UserTypelist}" var="ul">
										<option value="${ul.typeId}">
											${ul.typeName}
										</option>
									</c:forEach>
									</select>
                                </div>
                                <div class="col-sm-4">
                                  	  用户单位：
                                    <select name="userOrg" id="userOrg">
                                    <c:if test="${ not empty userOrg}">
                                    <option value="${userOrg}">
                                    <c:if test="${userOrg==OrgTypelist[0].orgId}">
									 ${OrgTypelist[0].orgName}
                                    </c:if>
                                    <c:if test="${userOrg==OrgTypelist[1].orgId}">
									 ${OrgTypelist[1].orgName}
                                    </c:if>
                                    <c:if test="${userOrg==OrgTypelist[2].orgId}">
									 ${OrgTypelist[2].orgName}
                                    </c:if>
                                    </option>
									</c:if>
										<option value="">
											--- 全部 ---
										</option>
										<c:forEach items="${OrgTypelist}" var="ol">
											<option value="${ol.orgId}">
												${ol.orgName}
											</option>
										</c:forEach>
									</select>
                                </div>
                                <div class="col-sm-4">
                                    用户姓名：<input id="userid" name="userid" value="${userid}">
                                </div>
                            </div>
                            <div class="row" style="padding-left:15px">
                                <input type="submit" value="查找" class="btn btn-primary" accesskey="S">
                                <input type="button" onclick="qingkong()" value="清空" class="btn btn-primary">
                            </div>
                        </div>
                    </form>
                    <div id="add">
                        <a href="addUserBefore.do"><span class="btn btn-default">添加用户</span></a>
                    </div>
                    <div id="kcs">
                        <div id="views">
                        
                            <table class="table-rw">
                                <tbody>
                                    <tr>
                                    <th>
                                           	 序号
                                        </th>
                                        <th>
                                           	 用户名
                                        </th>
                                        <th>
                                           	 用户姓名
                                        </th>
                                        <th>
                                           	 单位
                                        </th>
                                        <th>
                                          	  用户类型
                                        </th>
                                        <th>
                                            	状态
                                        </th>
                                        <th>
                                           	 操作
                                        </th>
                                    </tr>
                                    <tr>
                                    <c:if test="${ empty userList}">
												<td colspan="7" align="center">
												无相应数据！
												</td>
                                    </c:if>
                                    <c:if test="${ not empty userList}">
                                        <c:forEach items="${userList}" var="ul" varStatus="ctNum">
							<tr>
							<td align="center" class="center"> 
									&nbsp;${ ctNum.count}
								</td>
								<td class="center">
								${ul.userId}
								</td>
								<td class="center">
								${ul.userName}
								</td>
								<td class="center">
								${ul.orgName}
								</td>
								<td class="center">
								<c:if test="${ul.userType == 1}">
								管理员
								</c:if>
								<c:if test="${ul.userType == 2}">
								体检站
								</c:if>
								<c:if test="${ul.userType == 3}">
								建设方
								</c:if>
								
								</td>
								<td class="center">
								<c:if test="${ul.enable==1}">
								启用
								</c:if>
								<c:if test="${ul.enable==0}">
								禁用
								</c:if>
								</td>
								<td class="center">
								<a href="editUserBefore.do?userid=${ul.userId}">编辑</a>|
								<a href="deleteUser.do?userid=${ul.userId}&pageNum=1">删除</a>|
								<a href="editUserRight.do?userid=${ul.userId}&usertype=${ul.userType}">权限管理</a>
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