<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="sidebar" >
    <div class="sidebar-title">
       	 功能菜单
    </div>
    <c:forEach items="${muneList}" var="ml">
    <div class="sub-title">
    <a href="<%=request.getContextPath()%>/${ml.treeUrl}" target="_parent">${ml.treeName}</a>
    </div>
    </c:forEach>
</div>
     
