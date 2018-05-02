<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.io.*"%>
<%@ page import="qxjc.peszp.action.UserCarInfoAction"%>
<%@ page import="qxjc.peszp.dao.PhotoDao"%>
<%@ page import="qxjc.peszp.action.StringTool"%>
<%@ page import="qxjc.peszp.dao.BaseDao"%>
<%@ page import="qxjc.peszp.dao.PhotoDao"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="qxjc.peszp.dao.WriteXml"%>


<%		
	// 取值
	String zjhm = session.getAttribute("zjhm").toString();
	String userId = session.getAttribute("userId").toString();
	String BusinessType = session.getAttribute("BusinessType").toString();
	String ymlx = session.getAttribute("ymlx").toString();
		
	int i = 0;
	int j = 0;
	int m = 0;
	WriteXml wx = new WriteXml();
	if ( !"".equals(StringTool.trim(zjhm))) {
		//构建路径
		PhotoDao pd = new PhotoDao();
		BaseDao bd = new BaseDao();
		String date = pd.findDate("yyyy/MM/dd");
		String date2 = pd.findDate("yyyyMM");
		String filePath = bd.findFileIp("4") + bd.findFileIp("7")+ userId +System.getProperty("file.separator")+ date +System.getProperty("file.separator");
		String fileName = String.format("%1$s.jpg", zjhm);
		String fileFullPath = filePath + fileName;		
		// 过滤路径
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}		
		// 保存文件
		BufferedInputStream inputStream = new BufferedInputStream(
				request.getInputStream());
		FileOutputStream outputStream = new FileOutputStream(
				new File(fileFullPath));
		byte[] bytes = new byte[1024];
		int v;
		while ((v = inputStream.read(bytes)) > 0) {
			outputStream.write(bytes, 0, v);
		}
		outputStream.close();
		inputStream.close();
		String orgId = bd.findOrg(userId);
		String ss = pd.GetImageStrFromPath(fileFullPath);
		String flowid = pd.FindflowId(orgId);
		if(ymlx.equals("idhand")){
			String IdnoType = session.getAttribute("IdnoType").toString();
		    i = pd.WriteFlowByHand(flowid, BusinessType, IdnoType, zjhm, fileFullPath,ss,userId);
		}
		if(ymlx.equals("idCard")){
		String idBase64 = session.getAttribute("idcardPhotoBuff").toString();
		i = pd.WriteFlowById(flowid, BusinessType, zjhm, ss, fileFullPath,idBase64,userId);
		}
		m = bd.insertScale(userId, date2);
		j = wx.saxCreateXml(zjhm, ss,userId);
		if (i==1 && j==1 && m==1) {
			// 数据库更新成功
		} else {
			// 数据库更新失败
			throw new Exception("error ：with db connection!");
		}
	} else {
		throw new Exception("error ：with out parameter!");
	}
%>
