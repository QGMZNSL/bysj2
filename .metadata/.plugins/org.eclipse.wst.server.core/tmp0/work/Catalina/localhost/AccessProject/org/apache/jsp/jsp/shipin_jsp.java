/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.85
 * Generated at: 2018-05-03 06:24:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shipin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>在线学习</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<object id=\"video\" width=\"400\" height=\"200\" border=\"0\" classid=\"clsid:CFCDAA03-8BE4-11cf-B84B-0020AFBBCCFA\">\r\n");
      out.write("<param name=\"ShowDisplay\" value=\"0\">\r\n");
      out.write("<param name=\"ShowControls\" value=\"1\">\r\n");
      out.write("<param name=\"AutoStart\" value=\"1\">\r\n");
      out.write("<param name=\"AutoRewind\" value=\"0\">\r\n");
      out.write("<param name=\"PlayCount\" value=\"0\">\r\n");
      out.write("<param name=\"Appearance\"  value=\"0\">\r\n");
      out.write("<param name=\"BorderStyle\" value=\"0\">\r\n");
      out.write("<param name=\"MovieWindowHeight\" value=\"240\">\r\n");
      out.write("<param name=\"MovieWindowWidth\" value=\"320\">\r\n");
      out.write("<param name=\"FileName\" value=\"/Mbar.avi\">\r\n");
      out.write("<embed width=\"400\" height=\"200\" \r\n");
      out.write("       border=\"0\" showdisplay=\"0\" \r\n");
      out.write("       showcontrols=\"1\" autostart=\"1\" \r\n");
      out.write("       autorewind=\"0\" playcount=\"0\" \r\n");
      out.write("       moviewindowheight=\"240\" \r\n");
      out.write("       moviewindowwidth=\"320\" filename=\"/Mbar.avi\" src=\"D:\\study\\day03\\avi\\1.avi\">\r\n");
      out.write("</embed>\r\n");
      out.write("</object>\r\n");
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
