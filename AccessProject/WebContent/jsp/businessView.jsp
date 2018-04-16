<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务查看</title>
<link href="<%=request.getContextPath()%>/assets/css/bootstrap.css" rel="stylesheet">
	    <link href="<%=request.getContextPath()%>/assets/css/yhz.css" rel="stylesheet">
	    <script src="<%=request.getContextPath()%>/Content/jsml5shiv.min.js"></script>
	    <script src="<%=request.getContextPath()%>/Content/js/respond.js"></script>
	    <script src="<%=request.getContextPath()%>/assets/css/jquery-1.10.2.min.js"></script>
	    <script type="text/javascript">
	    function fanye(ye){
	    	var time = document.getElementById("time").value;
	    	var BusinessType = document.getElementById("BusinessType").value;
	    	window.location.href="view.do?pageNum="+ye+"&BusinessType="+BusinessType+"&time="+time; 
	    }
	     function qingkong()
	    {
	    	document.getElementById("searchForm").reset();
	    }
	    	function doExcel() {
	    		
	    		var time = $("#time").val();
	    		var BusinessType = $("#BusinessType").val();

	    		var str = "list.time=" + time
	    				+ "&list.BusinessType=" + BusinessType;
	    		var ajaxurl = "<%=request.getContextPath()%>/excel.do?"
	    		$.ajax({
	    			type : "post",
	    			data: {
	                  time: time,
	                  BusinessType: BusinessType
	                },
	    			url : ajaxurl,
	    			async : false,
	    			success : function(msg) {
	    				if ("error" == msg) {
	    					$('#expdown').html("");
	    					alert("导出失败！");
	    					$('#expdown').html("");
	    				} else if ("noData" == msg) {
	    					alert("没有记录！");
	    					$('#expdown').html("");
	    				} else {
	    					alert("导出成功！请点击下载链接进行下载！");
	    					$('#expdown').html(msg);
	    				}
	    			}
	    		});
	    	}
	    </script>
</head>
<body>
<div class="col-xs-10">
                <div class="section-box">
                    <form action="view.do?pageNum=1" id="searchForm" method="post">
                        <div class="search">
                            <div class="row">
                                <div class="col-sm-4">
                                    	 年月日
								        <select name="time" id="time">
								        <c:if test="${ not empty time}">
                                    <option value="${time}">
                                    <c:if test="${time==timelist[0]}">
									 ${timelist[0]}
                                    </c:if>
                                    <c:if test="${time==timelist[1]}">
									 ${timelist[1]}
                                    </c:if>
                                    <c:if test="${time==timelist[2]}">
									 ${timelist[2]}
                                    </c:if>
                                    </option>
									</c:if>
											<option value="">
												--- 全部 ---
											</option>
											<c:forEach items="${timelist}" var="tl">
												<option value="${tl}">
													${tl}
												</option>
											</c:forEach>
										</select>
                                </div>
                                <div class="col-sm-4">
                                  	  业务类型：
                                    <select name="BusinessType" id="BusinessType">
								        <c:if test="${ not empty BusinessType}">
                                    <option value="${BusinessType}">
                                    <c:if test="${BusinessType eq businesslist[0].businessType}">
									 ${businesslist[0].businessType}
                                    </c:if>
                                    <c:if test="${BusinessType eq businesslist[1].businessType}">
									 ${businesslist[1].businessType}
                                    </c:if>
                                    <c:if test="${BusinessType eq businesslist[2].businessType}">
									 ${businesslist[2].businessType}
                                    </c:if>
                                    </option>
									</c:if>
										<option value="">
											--- 全部 ---
										</option>
										<c:forEach items="${businesslist}" var="bl">
											<option value="${bl.businessType}">
												${bl.businessType}
											</option>
										</c:forEach>
									</select>
                                </div>
                            </div>
                            <div class="row" style="padding-left:15px">
                                <input type="submit" value="查找" class="btn btn-primary" accesskey="S">
                                <input type="button" value="下载EXCEL" class="btn btn-primary"
												onclick="doExcel()" />
<!--                                 <input type="button" onclick="qingkong()" value="清空" class="btn btn-primary"> -->
                                <span id="expdown"></span>
                            </div>
                        </div>
                    </form>
                    <div id="kcs">
                        <div id="views">
                        
                            <table class="table-rw">
                                <tbody>
                                    <tr>
                                    	<th>
                                           	序号
                                        </th>
                                        <th>
                                           	 流水号
                                        </th>
                                        <th>
                                           	 业务类型
                                        </th>
                                        <th>
                                           	 证件类型
                                        </th>
                                        <th>
                                          	  证件号码
                                        </th>
                                       
                                    </tr>
                                    <tr>
                                    <c:if test="${ empty businessNumList}">
												<td colspan="5" align="center">
												无相应数据！
												</td>
                                    </c:if>
                                    <c:if test="${ not empty businessNumList}">
                               <c:forEach items="${businessNumList}" var="bl" varStatus="ctNum">
							<tr>
							<td> 
									&nbsp;${ ctNum.count}
								</td>
								<td>
								${bl.flowNo}
								</td>
								<td>
								${bl.flowType}
								</td>
								<td>
								${bl.zjlx}
								</td>
								<td>
								${bl.zjhm}								
								</td>
							</tr>
							</c:forEach>
							<tr>
							<td></td><td></td><td></td>
	<td>总数：</td><td>${totalRecord}	</td>
	</tr>
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