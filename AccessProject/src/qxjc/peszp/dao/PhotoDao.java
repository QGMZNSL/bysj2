package qxjc.peszp.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import qxjc.peszp.bean.FlowBean;
import qxjc.peszp.jdbc.JdbcTemplate;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PhotoDao{

	public FlowBean photo(String zjhm, String img) {
		int n=0;
		FlowBean flow = new FlowBean();
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "INSERT INTO ZP_FLOW(img) VALUES (?) where zjhm=?";
		//String sql = "select * from zp_flow where zjhm=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
				pst.setString(1,img);
				pst.setString(2,zjhm);
				n=pst.executeUpdate();
			
			} catch (SQLException e) {
				// e.printStackTrace();
				n=0;
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// e.printStackTrace();
					}
				}
				if (db != null) {
					db.close();
				}

			}
			db.close();
		return null;
	}

//图片转换成base64编码
public String GetImageStrFromUrl(String imgURL) {  
        byte[] data = null;  
        try {  
            // 创建URL  
        URL url = new URL(imgURL);  
        // 创建链接  
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
        conn.setRequestMethod("GET");  
        conn.setConnectTimeout(5 * 1000);  
        InputStream inStream = conn.getInputStream();  
        data = new byte[inStream.available()];  
        inStream.read(data);  
        inStream.close();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  
    // 对字节数组Base64编码  
    BASE64Encoder encoder = new BASE64Encoder();  
    // 返回Base64编码过的字节数组字符串  
        return encoder.encode(data);  
    }  
  
    /** 
 * @Title: GetImageStrFromPath 
 * @Description: TODO(将一张本地图片转化成Base64字符串) 
 * @param imgPath 
 * @return 
 */  
public String GetImageStrFromPath(String imgPath) {  
    InputStream in = null;  
    byte[] data = null;  
    // 读取图片字节数组  
    try {  
        in = new FileInputStream(imgPath);  
        data = new byte[in.available()];  
        in.read(data);  
        in.close();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  
    // 对字节数组Base64编码  
    BASE64Encoder encoder = new BASE64Encoder();  
    // 返回Base64编码过的字节数组字符串  
        return encoder.encode(data);  
    }  
  
    /** 
 * @Title: GenerateImage 
 * @Description: TODO(base64字符串转化成图片) 
 * @param imgStr 
 * @return 
 */  
public  boolean GenerateImage(String imgStr) { 
    if (imgStr == null) // 图像数据为空  
        return false;  
    BASE64Decoder decoder = new BASE64Decoder();  
    try {  
        // Base64解码  
        byte[] b = decoder.decodeBuffer(imgStr);  
        for (int i = 0; i < b.length; ++i) {  
            if (b[i] < 0) {// 调整异常数据  
                b[i] += 256;  
            }  
        }  
        // 生成jpeg图片  
        String imgFilePath = "d://222.jpg";  
        OutputStream out = new FileOutputStream(imgFilePath);  
        out.write(b);  
        out.flush();  
        out.close();  
        return true;  
    } catch (Exception e) {  
        return false;  
    }  
} 
//获取当前系统日期
public String findDate(String geshi){
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat(geshi);//可以方便地修改日期格式
	String date = dateFormat.format(now);
	return date;
	
}
//获取ip
public String getIpAddr(HttpServletRequest request) {  
	String ip = request.getRemoteAddr();
	String localip=ip;
	if(ip.equals("0:0:0:0:0:0:0:1")){	
	InetAddress ia=null;
    try {
        ia=ia.getLocalHost();
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    localip=ia.getHostAddress();
	}
//    System.out.println("localip="+localip);
    return localip;
}
//拼接流水号
public String FindflowId(String orgId){
	Date now = new Date();
	String flowId = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//可以方便地修改日期格式
	String date = dateFormat.format(now);
	SerialNumberTool snt = new SerialNumberTool();
	String flow = SerialNumberTool.getInstance().generaterNextNumber(6);
	flowId = date+orgId+flow;
	return flowId;
}
public String FindflowId2(String orgId){
	Date now = new Date();
	String flowId = "";
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//可以方便地修改日期格式
	String date = dateFormat.format(now);
	SerialNumberTool snt = new SerialNumberTool();
	String flow = SerialNumberTool.getInstance().generaterNextNumber(6);
	flowId = date+orgId+flow;
	System.out.println(flowId);
	return flowId;
}

//记录身份证流水
public int WriteFlowById(String floeNo,String flowType,String zjhm,String base64,String imageUrl,String idBase64,String userId){
	int i = 0;
	JdbcTemplate db = new JdbcTemplate();
	String sql = "insert into zp_flow(flow_no,Flow_type,zjlx,zjhm,base64,img_url,id_base64,user_Id) values(?,?,?,?,?,?,?,?) ";
	PreparedStatement pst= db.GetPrepareStatement(sql);
	try{
		pst.setString(1,floeNo);
		pst.setString(2,flowType);
		pst.setString(3,"身份证");
		pst.setString(4,zjhm);
		pst.setString(5,base64);
		pst.setString(6,imageUrl);
		pst.setString(7,idBase64);
		pst.setString(8,userId);
		
		pst.executeUpdate(); 
		i = 1;
	}catch (SQLException e) {
		i = -1;
	}finally{
		if (db != null) {
			db.close();
		}

	}
	db.close();
	return i;
}

//记录手工流水
public int WriteFlowByHand(String floeNo,String flowType,String zjlx,String zjhm,String imageUrl,String base64,String userId){
	int i = 0;
	JdbcTemplate db = new JdbcTemplate();
	String sql = "insert into zp_flow(flow_no,Flow_type,zjlx,zjhm,img_url,base64,user_Id) values(?,?,?,?,?,?,?)";
	PreparedStatement pst= db.GetPrepareStatement(sql);
	try{
		pst.setString(1,floeNo);
		pst.setString(2,flowType);
		pst.setString(3,zjlx);
		pst.setString(4,zjhm);
		pst.setString(5,imageUrl);
		pst.setString(6, base64);
		pst.setString(7, userId);
		
		pst.executeUpdate();
		i=1;
	}catch (SQLException e) {
		i = -1;
	}finally{
		if (db != null) {
			db.close();
		}

	}
	db.close();
	return i;
}
//更新规模
public int updateScale(String userid){
	int i = 0;
	BaseDao bd = new BaseDao();
	JdbcTemplate db = new JdbcTemplate();
	Map map = bd.login(userid);
	String scale = map.get("scale").toString();
    scale = scale+1;
	String sql = "update sys_user set scale=? where user_id=?";
	PreparedStatement pst= db.GetPrepareStatement(sql);
	try{
		pst.setString(1,userid);
		pst.setString(2,scale);
		pst.executeUpdate();
		i=1;
	}catch (SQLException e) {
		i = -1;
	}finally{
		if (db != null) {
			db.close();
		}

	}
	db.close();
	return i;
	
}



}
