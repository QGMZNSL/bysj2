package qxjc.peszp.action;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qxjc.peszp.dao.BaseDao;
import qxjc.peszp.dao.CarIdDao;


@Controller
public class UserCarInfoAction extends WebActionSupport {
	@RequestMapping("checkMess")
	public String checkMess(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();
		String zjhm = request.getParameter("zjhm");
		String BusinessType = request.getParameter("BusinessType");
		String IdnoType = request.getParameter("IdnoType");
		String ymlx = request.getParameter("ymlx");
		String saveUrl = request.getContextPath()+"/jsp/photoUpload.jsp?zjhm="+zjhm;
		session.setAttribute("saveUrl", saveUrl);
		session.setAttribute("zjhm", zjhm);
		session.setAttribute("BusinessType", BusinessType);
		session.setAttribute("IdnoType", IdnoType);
		session.setAttribute("ymlx", ymlx);
		session.setAttribute("userId", userId);
		return "phoGather";		
	}
	
	

	@RequestMapping("carId")
	public String carId(HttpServletRequest request, HttpServletResponse response) {
		WebActionSupport ws = new WebActionSupport();
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();//用户id
		String zjhm = request.getParameter("zjhm");//身份证号
		String BusinessType = request.getParameter("BusinessType");//业务类型
		//String IdnoType = request.getParameter("IdnoType");//证件类型
		String ymlx = request.getParameter("ymlx");//页面类型
		String idcardPhotoBuff=request.getParameter("idcardPhotoBuff");//身份证64编码
		String saveUrl = request.getContextPath()+"/jsp/photoUpload.jsp?zjhm="+zjhm;
		session.setAttribute("saveUrl", saveUrl);
		session.setAttribute("zjhm", zjhm);
		session.setAttribute("BusinessType", BusinessType);
		session.setAttribute("idcardPhotoBuff", idcardPhotoBuff);
		session.setAttribute("ymlx", ymlx);
		session.setAttribute("userId", userId);
		return "userCarInfo";		
	}
}