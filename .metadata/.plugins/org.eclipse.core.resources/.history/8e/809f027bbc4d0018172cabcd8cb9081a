package qxjc.peszp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qxjc.peszp.bean.PageBean;
import qxjc.peszp.bean.UserBean;
import qxjc.peszp.dao.BaseDao;
import qxjc.peszp.dao.PhotoDao;

@Controller
public class ZpAction{
	//查找黑名单
	@RequestMapping("blackList")
	public String blackList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String idno = request.getParameter("blackIdNo");
		if(idno.equals("")){
			idno = "";
		}
//		int pageNum = Integer.valueOf(request.getParameter("pageNum"));
		String a = request.getParameter("pageNum");
		int pageNum = Integer.valueOf(a.substring(0, 1));
		List<Map> list = new ArrayList<Map>();
		List<Map> listall = new ArrayList<Map>();
		BaseDao bd = new BaseDao();
		listall = bd.findBlackListById(idno);
		int totalRecord = listall.size();
		int[] shouMo = bd.findPage(pageNum, 10, totalRecord);
		list = bd.findBlackListpage(shouMo[0], shouMo[1],idno);
		session.setAttribute("blackIdNo", idno);
		session.setAttribute("pageCount", shouMo[2]);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("blackList", list);
		return "blackList";
		
	}
	//根据身份证号查找黑名单
		@RequestMapping("findBlackById")
		public String findBlackById(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			int pageNum = Integer.valueOf(request.getParameter("pageNum"));
			String idno = request.getParameter("blackIdNo");
			List<Map> list = new ArrayList<Map>();
			BaseDao bd = new BaseDao();
			list = bd.findBlackListById(idno);
			session.setAttribute("blackList", list);
			return "blackList";
			
		}
	//添加黑名单
	@RequestMapping("addblackList")
	public void addBlackList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		WebActionSupport ws = new WebActionSupport();
		BaseDao bd = new BaseDao();
		PhotoDao pd = new PhotoDao();
		String userId = session.getAttribute("userId").toString();
		String idNo = request.getParameter("bidNo");
		String orgId = bd.findOrg(userId);
		String flowid = pd.FindflowId(orgId);
		String date = pd.findDate("yyyy/MM/dd HH:mm:ss");
		String changeContent = "添加黑名单用户："+idNo;
		String ip = pd.getIpAddr(request);
		String reason = request.getParameter("bReason");
		int i = bd.addBlackList(idNo,reason);
		int j = bd.writeSysLog(userId,"addBlack.jsp", flowid, "添加黑名单", changeContent, date, ip);
//		System.out.println("i="+i);
//		System.out.println("j="+j);
		if(i==1 & j==1){
			ws.OutWriteClient(response, "提交成功！","blackList.do?blackIdNo=&pageNum=1");
		}else{
			ws.OutWriteClient(response, "提交失败！","blackList.do?blackIdNo=&pageNum=1");
		}
	}
	//移除黑名单
	@RequestMapping("removeBlack")
	public void removeBlackList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		WebActionSupport ws = new WebActionSupport();
		String idNo = request.getParameter("idno");
		BaseDao bd = new BaseDao();
		PhotoDao pd = new PhotoDao();
		String userId = session.getAttribute("userId").toString();
		String orgId = bd.findOrg(userId);
		String flowid = pd.FindflowId(orgId);
		String date = pd.findDate("yyyy/MM/dd HH:mm:ss");
		String changeContent = "移除黑名单用户："+idNo;
		String ip = pd.getIpAddr(request);
		String reason = request.getParameter("bReason");
		int i = bd.removeBlackList(idNo);
		int j = bd.writeSysLog(userId,"addBlack.jsp", flowid, "移除黑名单", changeContent, date, ip);
		if(i==1 & j==1){
			ws.OutWriteClient(response, "删除成功！","blackList.do?blackIdNo=&pageNum=1");
		}else{
			ws.OutWriteClient(response, "删除失败！","blackList.do?blackIdNo=&pageNum=1");
		}
	}

}