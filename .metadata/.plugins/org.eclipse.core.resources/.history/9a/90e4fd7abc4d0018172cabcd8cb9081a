package qxjc.peszp.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import qxjc.peszp.bean.FlowBean;
import qxjc.peszp.bean.MenuBean;
import qxjc.peszp.bean.ModuleTool;
import qxjc.peszp.bean.UserBean;
import qxjc.peszp.dao.BaseDao;
import qxjc.peszp.dao.DownloadExcel;
import qxjc.peszp.dao.ExcelUtil;
import qxjc.peszp.dao.MenuDao;
import qxjc.peszp.dao.PhotoDao;

@Controller
public class UserAction {
	//用户管理--用户列表
	@RequestMapping("userRightsList")
	public String userRightsList(HttpServletRequest request, HttpServletResponse response) {
		List<UserBean> listall = new ArrayList<UserBean>();
		List<UserBean> list = new ArrayList<UserBean>();
		List<Map> UserTypelist = new ArrayList<Map>();
		List<Map> OrgTypelist = new ArrayList<Map>();
		HttpSession session = request.getSession();
		String a = request.getParameter("pageNum");
		int pageNum = Integer.valueOf(a.substring(0, 1));
		String userType = request.getParameter("userType");
		String userid = request.getParameter("userid");
		String userOrg = request.getParameter("userOrg");
		BaseDao bd = new BaseDao();
		UserTypelist = bd.findUserType();//查询用户类型	
		OrgTypelist = bd.findORGTList();//查询单位列表
		listall = bd.findUserListByX(userType,userid,userOrg);
		int totalRecord = listall.size();
		int[] shouMo = bd.findPage(pageNum, 10, totalRecord);
		list = bd.findUserListByXpage(shouMo[0], shouMo[1], userType, userid, userOrg);
		session.setAttribute("UserTypelist", UserTypelist);
		session.setAttribute("OrgTypelist", OrgTypelist);
		session.setAttribute("pageCount", shouMo[2]);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("userType", userType);
		session.setAttribute("userid", userid);
		session.setAttribute("userOrg", userOrg);
		session.setAttribute("userList", list);
		return "userList";
	}
	//业务统计（总）
	@RequestMapping("businessCount")
	public String businessCount(HttpServletRequest request, HttpServletResponse response,
			String time,String BusinessType,String status) {
		
		HttpSession session = request.getSession();		
		String userId = session.getAttribute("userId").toString();
	    String regex ="[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regex);    
        Matcher mat = pat.matcher(time);   
        String repickStr = mat.replaceAll("");//时间
		List<FlowBean> list = new ArrayList<FlowBean>();
		ArrayList<Map> OrgNumlist = new ArrayList<Map>();
		BaseDao bd = new BaseDao();
//		String orgNum=bd.findOrg(userId);//单位编号
//		String temp = repickStr+orgNum;
		
		list=bd.findBusinessCountList(repickStr, BusinessType, status);
		session.setAttribute("businessCountList", list);
		session.setAttribute("time", time);
		return "businessCount";
	}
	
	
	@RequestMapping("DownloadExcel")
	public void test(HttpServletRequest request, HttpServletResponse response){
		String excelNetPath = request.getParameter("excelNetPath");
//		System.out.println("msg="+excelNetPath);
		DownloadExcel de = new DownloadExcel();
		de.xiazai(response, request,excelNetPath);
		
	}
	//下载业务数量（体检站）excal
	@RequestMapping("excel")
	public String doExcel(HttpServletRequest request, HttpServletResponse response,
			String time,String BusinessType) {
		WebActionSupport ws = new WebActionSupport();
		String msg = null;
		PrintWriter out = null;
		HttpSession session = request.getSession();		
		String userId = session.getAttribute("userId").toString();
	    String regex ="[\u4e00-\u9fa5]";
        Pattern pat = Pattern.compile(regex);    
        Matcher mat = pat.matcher(time);   
        String repickStr = mat.replaceAll("");
		List<FlowBean> list = new ArrayList<FlowBean>();
		ArrayList<Map> OrgNumlist = new ArrayList<Map>();
		BaseDao bd = new BaseDao();
		String orgNum=bd.findOrg(userId);
		String temp = repickStr+orgNum;
		list = bd.findBusinessList(repickStr,BusinessType,temp);
		session.setAttribute("businessList", list);
		if (list == null || list.size() == 0) {
			msg = "noData";		
		} else {
			PhotoDao pd = new PhotoDao();
			String excelFileName = userId + pd.findDate("yyyyMMddHHmmss")+".xls";
			String excelPhyPath = bd.findFileIp("4")+ System.getProperty("file.separator")+bd.findFileIp("11");
			String excelNetPath = bd.findFileIp("4")+ System.getProperty("file.separator")+bd.findFileIp("11") + System.getProperty("file.separator")+ excelFileName;
			// 合成真实的文件名
			String file = "";
			if (excelPhyPath.endsWith(System.getProperty("file.separator"))) {
				file = excelPhyPath + excelFileName;
			} else {
				file = excelPhyPath + System.getProperty("file.separator")
						+ excelFileName;
			}

			File f = new File(file);
			if (!f.exists()) {
				f.getParentFile().mkdirs();
			}

			BufferedOutputStream bos = null;
			WritableWorkbook book = null;
			try {
				bos = new BufferedOutputStream(new FileOutputStream(f));
				book = Workbook.createWorkbook(bos);
				WritableSheet sheet = null;
				ExcelUtil excelUtil = new ExcelUtil(); 
				int pagesize = 1000;
				int rownum = 0;
				Label label = null;
				WritableCellFormat haligncenter = excelUtil.getTitleformat();
				WritableCellFormat alignleft = excelUtil
						.getBodyformatAlignLeft();
				WritableCellFormat alignleftCenter = excelUtil
						.getBodyformatAlignLeftCenter();
				WritableCellFormat aligncenter = excelUtil
						.getBodyformatAlignCenter();
				WritableCellFormat demoleft = excelUtil.getDemoformat();
				String excelTile = "业务 表";
				FlowBean tmpSyl = null;
				for (int i = 0; i < list.size(); i++) {
					if (i % pagesize == 0) {
						// 新建sheet
						sheet = book.createSheet("业务表" + i / pagesize, i
								/ pagesize);
						label = new Label(0, 0, excelTile, haligncenter);
						sheet.addCell(label);
						sheet.mergeCells(0, 0, 4, 0);

						label = new Label(0, 1, "序号", aligncenter);
						sheet.addCell(label);
						label = new Label(1, 1, "流水号", aligncenter);
						sheet.addCell(label);
						label = new Label(2, 1, "业务类型", aligncenter);
						sheet.addCell(label);
						label = new Label(3, 1, "证件类型", aligncenter);
						sheet.addCell(label);
						label = new Label(4, 1, "证件号码", aligncenter);
						sheet.addCell(label);
						rownum = 2;
					}

					tmpSyl = list.get(i);
					label = new Label(0, rownum, String.valueOf(i + 1),
							alignleftCenter); // 序号
					sheet.addCell(label);
					label = new Label(1, rownum, tmpSyl.getFlowNo(),
							alignleftCenter); // 流水号
					sheet.addCell(label);
					label = new Label(2, rownum, tmpSyl.getFlowType(),
							alignleftCenter); // 业务类型
					sheet.addCell(label);
					label = new Label(3, rownum,
							tmpSyl.getZjlx(), alignleftCenter); // 证件类型
					sheet.addCell(label);
					label = new Label(4, rownum, tmpSyl.getZjhm(),
							alignleftCenter); // 证件号码
					sheet.addCell(label);

					rownum++;
				}
				book.write();
				msg = "<a href='DownloadExcel.do?excelNetPath="+excelNetPath+"' target='_blank'>下载</a>";
			} catch (Exception e) {
				e.printStackTrace();
				msg = "error";
			} finally {
				if (book != null) {
					try {
						book.close();
					} catch (WriteException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (bos != null) {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		try {
			out = response.getWriter();
			out.write(msg);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			if (out != null) {
				out.close();
			}		
		}

		return null;
	}		
	
	//下载业务统计（总）excal
		@RequestMapping("countexcel")
		public String doCountExcel(HttpServletRequest request, HttpServletResponse response,
				String time,String BusinessType,String status) {
			WebActionSupport ws = new WebActionSupport();
			String msg = null;
			PrintWriter out = null;
			HttpSession session = request.getSession();		
			String userId = session.getAttribute("userId").toString();
		    String regex ="[\u4e00-\u9fa5]";
	        Pattern pat = Pattern.compile(regex);    
	        Matcher mat = pat.matcher(time);   
	        String repickStr = mat.replaceAll("");
			List<FlowBean> list = new ArrayList<FlowBean>();
			ArrayList<Map> OrgNumlist = new ArrayList<Map>();
			BaseDao bd = new BaseDao();
			list = bd.findBusinessCountList(repickStr, BusinessType, status);
			session.setAttribute("businessCountList", list);
			if (list == null || list.size() == 0) {
				msg = "noData";		
			} else {
				PhotoDao pd = new PhotoDao();
				;
				String excelFileName = userId + pd.findDate("yyyyMMddHHmmss")+".xls";
				String excelPhyPath = bd.findFileIp("4")+ System.getProperty("file.separator")+bd.findFileIp("11");
				String excelNetPath = bd.findFileIp("3")+ System.getProperty("file.separator")+bd.findFileIp("11") + System.getProperty("file.separator")+ excelFileName;
				// 合成真实的文件名
				String file = "";
				if (excelPhyPath.endsWith(System.getProperty("file.separator"))) {
					file = excelPhyPath + excelFileName;
				} else {
					file = excelPhyPath + System.getProperty("file.separator")
							+ excelFileName;
				}

				File f = new File(file);
				if (!f.exists()) {
					f.getParentFile().mkdirs();
				}

				BufferedOutputStream bos = null;
				WritableWorkbook book = null;
				try {
					bos = new BufferedOutputStream(new FileOutputStream(f));
					book = Workbook.createWorkbook(bos);
					WritableSheet sheet = null;
					ExcelUtil excelUtil = new ExcelUtil(); 
					int pagesize = 1000;
					int rownum = 0;
					Label label = null;
					WritableCellFormat haligncenter = excelUtil.getTitleformat();
					WritableCellFormat alignleft = excelUtil
							.getBodyformatAlignLeft();
					WritableCellFormat alignleftCenter = excelUtil
							.getBodyformatAlignLeftCenter();
					WritableCellFormat aligncenter = excelUtil
							.getBodyformatAlignCenter();
					WritableCellFormat demoleft = excelUtil.getDemoformat();
					String excelTile = "业务统计 表";
					FlowBean tmpSyl = null;
					for (int i = 0; i < list.size(); i++) {
						if (i % pagesize == 0) {
							// 新建sheet
							sheet = book.createSheet("业务统计表" + i / pagesize, i
									/ pagesize);
							label = new Label(0, 0, excelTile, haligncenter);
							sheet.addCell(label);
							sheet.mergeCells(0, 0, 4, 0);

							label = new Label(0, 1, "序号", aligncenter);
							sheet.addCell(label);
							label = new Label(1, 1, "流水号", aligncenter);
							sheet.addCell(label);
							label = new Label(2, 1, "业务类型", aligncenter);
							sheet.addCell(label);
							label = new Label(3, 1, "证件类型", aligncenter);
							sheet.addCell(label);
							label = new Label(4, 1, "证件号码", aligncenter);
							sheet.addCell(label);
							label = new Label(5, 1, "状态", aligncenter);
							sheet.addCell(label);
//							label = new Label(6, 1, "指定教材", aligncenter);
//							sheet.addCell(label);
//							label = new Label(7, 1, "是否全国统考", aligncenter);
//							sheet.addCell(label);

							rownum = 2;
						}

						tmpSyl = list.get(i);
						label = new Label(0, rownum, String.valueOf(i + 1),
								alignleftCenter); // 序号
						sheet.addCell(label);
						label = new Label(1, rownum, tmpSyl.getFlowNo(),
								alignleftCenter); // 流水号
						sheet.addCell(label);
						label = new Label(2, rownum, tmpSyl.getFlowType(),
								alignleftCenter); // 业务类型
						sheet.addCell(label);
						label = new Label(3, rownum,
								tmpSyl.getZjlx(), alignleftCenter); // 证件类型
						sheet.addCell(label);
						label = new Label(4, rownum, tmpSyl.getZjhm(),
								alignleftCenter); // 证件号码
						sheet.addCell(label);
						label = new Label(5, rownum, tmpSyl.getStatu(),
								alignleftCenter); // 状态
						sheet.addCell(label);

						rownum++;
					}
					book.write();
					msg = "<a href='DownloadExcel.do?excelNetPath="+excelNetPath+"' target='_blank'>下载</a>";
				} catch (Exception e) {
					e.printStackTrace();
					msg = "error";
				} finally {
					if (book != null) {
						try {
							book.close();
						} catch (WriteException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (bos != null) {
						try {
							bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			try {
				out = response.getWriter();
				out.write(msg);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				if (out != null) {
					out.close();
				}		
			}

			return null;
		}	
	//修改用户信息
	@RequestMapping("editUserBefore")
	public String editUserBefore(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = request.getParameter("userid");
		List<UserBean> list = new ArrayList<UserBean>();
		BaseDao bd = new BaseDao();
		list = bd.editUserList(userid);
		session.setAttribute("edituserList", list);
		return "editUser";
	}
	//提交修改后的用户信息
		@RequestMapping("editUser")
		public void editUser(HttpServletRequest request, HttpServletResponse response,String userid,String userName,
				String userOrg,String userPhone,String operater,String enable,String scale,String userType,String userpass) {
			BaseDao bd = new BaseDao();
			WebActionSupport ws = new WebActionSupport();
			int i = bd.editUser(userid,userName,userOrg,userPhone,operater,enable,scale,userType,userpass);
			if(i==1){
				ws.OutWriteClient(response, "修改成功！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
			}else{
				ws.OutWriteClient(response, "修改失败！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
			}
		}
	//修改体检站权限	
		@RequestMapping("editUserRight")
		public String editUserRight(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			String userid = request.getParameter("userid");
			String usertype = request.getParameter("usertype");
			MenuDao md = new MenuDao();
			BaseDao bd = new BaseDao();
			Map map = bd.login(userid);
			String userRight = map.get("userRight").toString();
			List<MenuBean> menulist = new ArrayList<MenuBean>();
			menulist = md.findAllMenu(usertype);
			session.setAttribute("userRight", userRight);
			session.setAttribute("rightUserId", userid);
			session.setAttribute("RightList", menulist);
			return "editRight";
		}
		//保存体检站权限	
		@RequestMapping("saveUserRight")
		public void saveUserRight(HttpServletRequest request, HttpServletResponse response,String[] pwrIndexes,String rightUserId) {
			HttpSession session = request.getSession();
			WebActionSupport ws = new WebActionSupport();
			MenuDao md = new MenuDao();
			BaseDao bd = new BaseDao();
			PhotoDao pd = new PhotoDao();
			String pp = md.pwrLink(pwrIndexes);
			String userId = session.getAttribute("userId").toString();
			int i = bd.saveUserRight(pp,rightUserId);
			String orgId = bd.findOrg(userId);
			String flowid = pd.FindflowId(orgId);
			String date = pd.findDate("yyyy/MM/dd HH:mm:ss");
			String ip = pd.getIpAddr(request);
			int j = bd.writeSysLog(userId, "editRight", flowid,"修改用户"+rightUserId+"的权限","权限更改为："+pp, date, ip);
			if(i == 1 && j == 1){
				ws.OutWriteClient(response, "修改成功！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
			}else{
				ws.OutWriteClient(response, "修改失败！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
			}
			
		}
	//删除用户
		@RequestMapping("deleteUser")
		public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			String userid = request.getParameter("userid");
			String userId = session.getAttribute("userId").toString();
			WebActionSupport ws = new WebActionSupport();
			BaseDao bd = new BaseDao();
			PhotoDao pd = new PhotoDao();
			String orgId = bd.findOrg(userId);
			String flowid = pd.FindflowId(orgId);
			String date = pd.findDate("yyyy/MM/dd HH:mm:ss");
			String ip = pd.getIpAddr(request);
			int i = bd.removeUser(userid);
			int j = bd.writeSysLog(userId, "userList.jsp", flowid, "删除用户", "删除用户:"+userid, date, ip);
			if(i == 1){
				ws.OutWriteClient(response, "删除成功！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
			}else{
				ws.OutWriteClient(response, "删除失败！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
			}
		}
		//填写用户信息
		
		@RequestMapping("addUserBefore")
		public String addUserBefore(HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			List<Map> UserTypelist = new ArrayList<Map>();
			List<Map> OrgTypelist = new ArrayList<Map>();
			BaseDao bd = new BaseDao();
			//查询用户类型
			UserTypelist = bd.findUserType();
		    //查询单位列表	
			OrgTypelist = bd.findORGTList();
			session.setAttribute("UserTypelist", UserTypelist);
			session.setAttribute("OrgTypelist", OrgTypelist);
			return "addUser";
			
		}
		//添加用户
			@RequestMapping("addUser")
			public void addUser(HttpServletRequest request, HttpServletResponse response,
					String userid,String userName,String userOrg,String userPhone,
					String operater,String enable,String userType,String userpass) {
				HttpSession session = request.getSession();
				WebActionSupport ws = new WebActionSupport();
				String userId = session.getAttribute("userId").toString();
				BaseDao bd = new BaseDao();
				PhotoDao pd = new PhotoDao();
				String orgId = bd.findOrg(userId);
				String flowid = pd.FindflowId(orgId);
				String date = pd.findDate("yyyy/MM/dd HH:mm:ss");
				String ip = pd.getIpAddr(request);
				String userRight = bd.findRightByType(userType);
				String changeContent = "添加新用户："+userid;
				int i = bd.addUser(userid, userName, userOrg, userPhone, date, operater, enable, userRight, userType, userpass);
				int j = bd.writeSysLog(userId, "addUser.jsp", flowid, "添加新用户", changeContent, date, ip);
				if(i == 1){
					ws.OutWriteClient(response, "您已成功添加用户！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
				}else{
					ws.OutWriteClient(response, "添加用户失败！", "userRightsList.do?userid=&userOrg=&userType=&pageNum=1");
				}
				}

}
