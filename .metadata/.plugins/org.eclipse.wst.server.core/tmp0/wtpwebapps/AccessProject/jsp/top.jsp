<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="navbar navbar-inverse navbar-fixed-top" style="z-index=1;">
       <iframe  src='about:blank' frameBorder='0' marginHeight='0' marginWidth='0' style='position: absolute; visibility: inherit; top: 0px; left: 0px; width: 100%; height: 100%; z-index: -1; filter: alpha(opacity = 0);'></iframe>
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
                        <span>${usermap.UserName}</span>&nbsp;|&nbsp;
                        <a href="<%=request.getContextPath()%>/Exit.do">注销</a>
                    </div>
                </form>
            </div>     
        </div>
    </div>
    
       