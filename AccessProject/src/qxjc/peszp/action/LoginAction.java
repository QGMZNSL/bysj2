package qxjc.peszp.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qxjc.peszp.bean.FlowBean;
import qxjc.peszp.bean.MD5;
import qxjc.peszp.bean.UserBean;
import qxjc.peszp.dao.BaseDao;
import qxjc.peszp.dao.PhotoDao;

@Controller
public class LoginAction{
	@RequestMapping("login")
	public String Login(HttpServletRequest request, HttpServletResponse response) {
		WebActionSupport ws = new WebActionSupport();
		Map userMap = new HashMap();
		HttpSession session = request.getSession();
		UserBean user = new UserBean();
		PhotoDao pd = new PhotoDao();
		String userid = request.getParameter("userId");
		String userpass = request.getParameter("userPass");//文本框密码
		String ip = pd.getIpAddr(request);
		BaseDao bd = new BaseDao();		
		userMap = bd.login(userid);	
		boolean pass= false;
		if(userMap.size()==0){
			ws.OutWriteClient(response, "用户名不存在！","index.jsp");
			bd.userlog(userid, "失败", "用户名不存在！", ip);
			return "";
		}else {
			pass=userMap.get("userPass").toString().equals(MD5.getMD5String(userpass));
			if (!pass){
				ws.OutWriteClient(response, "密码错误！","index.jsp");
				bd.userlog(userid, "失败", "密码错误！", ip);
				return "";
			}else{
				bd.userlog(userid, "成功", " ", ip);
				session.setAttribute("User", userMap);
				session.setAttribute("userName", userMap.get("userName"));
				session.setAttribute("userRole", userMap.get("userRole"));
				return "main";			
			}
		}
		
	}

	@RequestMapping("idHand")
	public String idHand(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		BaseDao bd = new BaseDao();
		PhotoDao pd = new PhotoDao();
		List<Map> handlist = new ArrayList<Map>();
		List<Map> businesslist = new ArrayList<Map>();
		WebActionSupport ws = new WebActionSupport(); 
		String createdate = pd.findDate("HHmm");
		int a = Integer.parseInt(createdate);
		String workTime=bd.findFileIp("1");
		String closeTime = bd.findFileIp("2");
		int b = Integer.parseInt(workTime);	
		int c = Integer.parseInt(closeTime);		
		if(a<b || a>c){
			ws.OutWriteClient(response, "此功能在非工作时间内禁止使用！工作时间：8:00~18:00","photo.do");
		}
		handlist = bd.findIdType();
		businesslist = bd.findBusinessType();
		session.setAttribute("handList", handlist);
		session.setAttribute("businesslist", businesslist);
		return "idHand";
		
	}
	@RequestMapping("idCard")
	public String idCard(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		BaseDao bd = new BaseDao();
		PhotoDao pd = new PhotoDao();
		List<Map> businesslist = new ArrayList<Map>();
		WebActionSupport ws = new WebActionSupport(); 
		String createdate = pd.findDate("HHmm");
		int a = Integer.parseInt(createdate);
		businesslist = bd.findBusinessType();
		session.setAttribute("businesslist", businesslist);
		return "userCarInfo";
		
	}
	
	//注销
	@RequestMapping("Exit")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		WebActionSupport ws = new WebActionSupport();
		int i = 0 ;
		try {
			request.getSession().invalidate();
			i = 1;
		} catch (Exception e) {
			i = -1;
		} 
		if(i == 1){
			ws.relogin(response, "您已安全退出！","index.jsp");
		}else{
			ws.relogin(response, "安全退出异常！","index.jsp");
		}
	}

	
	@RequestMapping("view")
	public String businessView(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<Map> businesslist = new ArrayList<Map>();
		List<Map> businesstimelist = new ArrayList<Map>();
		List<FlowBean> listall = new ArrayList<FlowBean>();
		List<FlowBean> list = new ArrayList<FlowBean>();
		List timelist = new ArrayList();
		BaseDao bd = new BaseDao();
		
		String userId = session.getAttribute("userId").toString();
		String time = request.getParameter("time");
		String BusinessType = request.getParameter("BusinessType");
		String a = request.getParameter("pageNum");
		int pageNum = Integer.valueOf(a.substring(0, 1));
		
		String orgNum=bd.findOrg(userId);
		String regex ="[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regex);    
        Matcher mat = pat.matcher(time);   
        String repickStr = mat.replaceAll("");
		String temp = repickStr+orgNum;
		
		listall = bd.findBusinessList(repickStr,BusinessType,temp);
		businesslist = bd.findBusinessType();
		businesstimelist=bd.findBusinessTime();
		
		int totalRecord = listall.size();
		int[] shouMo = bd.findPage(pageNum, 10, totalRecord);
		list = bd.findBusinessListPage(shouMo[0],shouMo[1],time, BusinessType, temp);
		for(int i=0;i<businesstimelist.size();i++){			
			String timel = (String) businesstimelist.get(i).get("flowNo");
			try {
				Date date = new SimpleDateFormat("yyyyMMdd").parse(timel.substring(0, 8));
				String now = new SimpleDateFormat("yyyy年MM月dd日").format(date);
				timelist.add(now);		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		 
		 for  ( int  i  =   0 ; i  <  timelist.size()  -   1 ; i ++ )   { 
			    for  ( int  j  =  timelist.size()  -   1 ; j  >  i; j -- )   { 
			      if  (timelist.get(j).equals(timelist.get(i)))   { 
			        timelist.remove(j); 
			      } 
			    } 
			  } 
		 session.setAttribute("time", time);
		 session.setAttribute("BusinessType", BusinessType);
		 session.setAttribute("pageCount", shouMo[2]);
		 session.setAttribute("pageNum", pageNum);
		 session.setAttribute("totalRecord", totalRecord);
		 session.setAttribute("timelist", timelist);
		 session.setAttribute("businessNumList", list);
		return "businessView";
		
	}
	
	
	
	@RequestMapping("count")
	public String businessCount(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String time = request.getParameter("time");
		String BusinessType = request.getParameter("BusinessType");
		String status = request.getParameter("status");
		
		BaseDao bd = new BaseDao();
		String userId = session.getAttribute("userId").toString();
		String a = request.getParameter("pageNum");
		int pageNum = Integer.valueOf(a.substring(0, 1));
		String orgNum=bd.findOrg(userId);
		String regex ="[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regex);    
		Matcher mat = pat.matcher(time);   
		String repickStr = mat.replaceAll("");//时间
		
		List<FlowBean> list = new ArrayList<FlowBean>();
		List<Map> businesslist = new ArrayList<Map>();
		List<Map> businesstimelist = new ArrayList<Map>();
		List<Map> businessstatuslist = new ArrayList<Map>();
		List timelist = new ArrayList();
		List<FlowBean> listall = new ArrayList<FlowBean>();
		
		listall = bd.findBusinessCountList(repickStr, BusinessType, status);
		businesslist = bd.findBusinessType();//业务类型
		businesstimelist=bd.findBusinessTime();//流水号
		businessstatuslist= bd.findStatusList();//业务状态
		
	    int totalRecord = listall.size();
		int[] shouMo = bd.findPage(pageNum, 10, totalRecord);
		list = bd.findBusinessCountListPage(shouMo[0],shouMo[1],repickStr, BusinessType, status);
		for(int i=0;i<businesstimelist.size();i++){			
			String timel = (String) businesstimelist.get(i).get("flowNo");
			try {
				Date date = new SimpleDateFormat("yyyyMMdd").parse(timel.substring(0, 8));
				String now = new SimpleDateFormat("yyyy年MM月dd日").format(date);
				timelist.add(now);		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}		 
		 for  ( int  i  =   0 ; i  <  timelist.size()  -   1 ; i ++ )   { 
			    for  ( int  j  =  timelist.size()  -   1 ; j  >  i; j -- )   { 
			      if  (timelist.get(j).equals(timelist.get(i)))   { 
			        timelist.remove(j); 
			      } 
			    } 
			  } 
		 session.setAttribute("timelist", timelist);//时间
		 session.setAttribute("time", time);
		 session.setAttribute("BusinessType", BusinessType);
		 session.setAttribute("status", status);
		 session.setAttribute("pageCount", shouMo[2]);
		 session.setAttribute("pageNum", pageNum);
		 session.setAttribute("totalRecord", totalRecord);
		 session.setAttribute("businessCountList", list);
		 session.setAttribute("businesslist", businesslist);
		 session.setAttribute("businesstimelist", businesstimelist);
		 session.setAttribute("businessstatuslist", businessstatuslist);
		return "businessCount";
		
	}
	@RequestMapping("photo")
	public String  photo() {
		return "photo";
	}

	
}
