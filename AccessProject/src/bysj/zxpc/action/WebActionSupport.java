package bysj.zxpc.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 所有action必须继承此类
 * 
 * @author Administrator
 * 
 */

public class WebActionSupport {

	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	
	public void OutWriteClient(HttpServletResponse response, String str,String ym) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(
					"<script language='javascript'>alert('" + str
					+ "');location.href='"+ym+"'</script>");
			response.getWriter().flush();
		} catch (IOException e) {
		}
	}
	
	public void relogin(HttpServletResponse response, String str,String ym) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(
					"<script language='javascript'>alert('" + str
					+ "');top.location.href='"+ym+"'</script>");
			response.getWriter().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}	
	
}