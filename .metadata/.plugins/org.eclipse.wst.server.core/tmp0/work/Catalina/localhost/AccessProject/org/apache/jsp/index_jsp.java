/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.85
 * Generated at: 2018-05-02 09:01:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>java在线评测系统</title>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"assets/font-awesome/4.5.0/css/font-awesome.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link href=\"assets/css/ace.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <script src=\"Content/js/html5shiv.min.js\"></script>\r\n");
      out.write("    <script src=\"Content/js/respond.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            background: #F7FAFC;\r\n");
      out.write("            overflow: hidden;\r\n");
      out.write("            background: #fff;\r\n");
      out.write("            background-color: #1891d8;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        #canvas {\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            left: 0px;\r\n");
      out.write("            top: 0px;\r\n");
      out.write("            z-index: -1;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write(" \tfunction checklogin(){ \r\n");
      out.write(" \t\tvar no = document.getElementById(\"userName\");         \r\n");
      out.write(" \t    var pwd = document.getElementById(\"userPass\"); \r\n");
      out.write(" \t    if(no.value == \"\") {\r\n");
      out.write(" \t        alert('请输入用户名!'); \r\n");
      out.write(" \t        return false;\r\n");
      out.write(" \t    } \r\n");
      out.write(" \t     if(pwd.value == \"\") {\r\n");
      out.write(" \t        alert('请输入密码!'); \r\n");
      out.write(" \t        return false;\r\n");
      out.write(" \t    }  \r\n");
      out.write(" \t    \r\n");
      out.write(" \t} \r\n");
      out.write(" </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"login-layout light-login vertical-center\">\r\n");
      out.write("    <div class=\"main-container\">\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            <div class=\"row \">\r\n");
      out.write("                <div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("                    <div class=\"login-container\">\r\n");
      out.write("                        <div class=\"center\">\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <br />\r\n");
      out.write("                            <h2>\r\n");
      out.write("                                <span class=\"white\">\r\n");
      out.write("                                    <img src=\"Content/Image/top.png\" class=\"img-responsive\" style=\"max-height:70px\" />\r\n");
      out.write("                                </span>\r\n");
      out.write("                                <span class=\"white\">在线评测系统</span>\r\n");
      out.write("                            </h2>\r\n");
      out.write("                            <h4 class=\"white\" id=\"id-company-text\">&copy;--java教育 </h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"position-relative\">\r\n");
      out.write("                            <div id=\"login-box\" class=\"login-box visible widget-box no-border\">\r\n");
      out.write("                                <div class=\"widget-body\">\r\n");
      out.write("                                    <div class=\"widget-main\">\r\n");
      out.write("                                        <h4 class=\"header lighter bigger\">\r\n");
      out.write("                                            <i class=\"ace-icon fa fa-bullhorn\"></i>\r\n");
      out.write("                                                                                                                        请输入您的信息\r\n");
      out.write("                                        </h4>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("                                       \r\n");
      out.write("                                            <form action=\"login.do\" class=\"form-horizontal\" method=\"post\" onsubmit=\"return checklogin()\">\r\n");
      out.write("                                                <input name=\"__RequestVerificationToken\" type=\"hidden\" value=\"VW0RfoySbpKr-0gHl1pu2sfK8siWc8JfRYkO1pt4V-fqN6lPN7w49GUMk4-4eNdnsIdD-1WM5nvqAk-a-9WzKiNVvHARh2VA0BiwchDZjTi3zW46_t2Jn6CpgprLtEQH59-jfUvH416rUHi2kD8zAQ2\">                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label class=\"col-md-3 control-label\" for=\"Username\">用户名</label>\r\n");
      out.write("                                                    <div class=\"col-md-9\">\r\n");
      out.write("                                                        <input class=\"form-control\" type=\"text\" name=\"userName\" id=\"userName\" >\r\n");
      out.write("                                                        <span class=\"field-validation-valid text-danger\" data-valmsg-for=\"Username\" data-valmsg-replace=\"true\"></span>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <label class=\"col-md-3 control-label\" for=\"Password\">密    码</label>\r\n");
      out.write("                                                    <div class=\"col-md-9\">\r\n");
      out.write("                                                        <input class=\"form-control\" type=\"password\" name=\"userPass\" id=\"userPass\">\r\n");
      out.write("                                                        <span class=\"field-validation-valid text-danger\" data-valmsg-for=\"Password\" data-valmsg-replace=\"true\"></span>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"form-group\">\r\n");
      out.write("                                                    <div class=\"col-md-offset-2 col-md-10\">\r\n");
      out.write("                                                        <input type=\"submit\" value=\"登录\" class=\"btn btn-primary\" style=\"padding: 5px 50px\"/>\r\n");
      out.write("                                                        <input type=\"button\" value=\"注册\" class=\"btn btn-primary\" style=\"padding: 5px 50px\"/>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        <div class=\"space-4\"></div>\r\n");
      out.write("                                        <div class=\"social-or-login left\">\r\n");
      out.write("                                            <span class=\"bigger-110\">若忘记密码，请点击此处-><a href=\"\"><span class=\"bigger-110\"> 修改密码</span></a>！</span>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div><!-- /.widget-main -->\r\n");
      out.write("\r\n");
      out.write("                                </div><!-- /.widget-body -->\r\n");
      out.write("                            </div><!-- /.login-box -->\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div><!-- /.col -->\r\n");
      out.write("            </div><!-- /.row -->\r\n");
      out.write("        </div><!-- /.main-content -->\r\n");
      out.write("    </div><!-- /.main-container -->\r\n");
      out.write("    <canvas id=\"canvas\"></canvas>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}