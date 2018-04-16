package qxjc.peszp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

import qxjc.peszp.ImpService.ImpPeszp;
import qxjc.peszp.bean.FlowBean;
import qxjc.peszp.bean.IdInformationBean;
import qxjc.peszp.bean.MD5;
import qxjc.peszp.bean.PageBean;
import qxjc.peszp.bean.UserBean;
import qxjc.peszp.jdbc.JdbcTemplate;

public class BaseDao {

	public Map login(String userid) {
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from base_user t where user_name=?";
		Map user = new HashMap();
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,userid);
//			System.out.println("select sql="+sql);
			rs=pst.executeQuery();
				while (rs.next()) {
					user.put("userRole", rs.getString("user_role"));
					user.put("userName",rs.getString("user_name"));
					user.put("userPass", rs.getString("user_pass"));
					user.put("userPhone", rs.getString("user_phone"));
					user.put("userSex", rs.getString("user_sex"));  
				}
			} catch (SQLException e) {
				// e.printStackTrace();
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
//		System.out.println("user="+user.get("userRole"));
		return user;
	}
	//用户登录日志
	public void userlog(String userid,String statu,String reason,String userip){
		JdbcTemplate db = new JdbcTemplate(); 
		PhotoDao pd = new PhotoDao();
		String data = pd.findDate("yyyy/MM/dd hh:mm:ss");
	    String sql="insert into zp_user_log(user_id,operation,statu,reason,ip,time) values(?,?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'))";  
	    PreparedStatement pst= db.GetPrepareStatement(sql); 
		try{
			pst.setString(1,userid);
			pst.setString(2,"登录");
			pst.setString(3,statu);
			pst.setString(4,reason);
			pst.setString(5,userip);
			pst.setString(6,data);
			pst.executeUpdate(); 
		}catch (SQLException e) {
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}

		}
		db.close();
	}
	//查找身份证类型
	
	public List<Map> findIdType(){
		ResultSet rs = null;
		List<Map> list = new ArrayList<Map>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from zp_id_type t";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Map map = new HashMap();
					map.put("id",rs.getString("id_no"));
					map.put("type",rs.getString("id_type"));
					list.add(map);
					}
				}
		}catch (SQLException e) {
			// e.printStackTrace();
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
		return list;
	}
	
	//查找业务类型
	public List<Map> findBusinessType(){
		ResultSet rs = null;
		List<Map> list = new ArrayList<Map>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from zp_business_type t";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Map map = new HashMap();
					map.put("businessId",rs.getString("business_Id"));
					map.put("businessType",rs.getString("business_Type"));
					list.add(map);
					}
				}
		}catch (SQLException e) {
			// e.printStackTrace();
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
		return list;
	}
	
	//查看flow表的流水号
	
	public List<Map> findBusinessTime(){
		ResultSet rs = null;
		List<Map> list = new ArrayList<Map>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from zp_flow t";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Map map = new HashMap();
					map.put("flowId",rs.getString("flow_id"));
					map.put("flowNo",rs.getString("flow_no"));				
					list.add(map);
					}
				}
		}catch (SQLException e) {
			// e.printStackTrace();
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
		return list;
	}
	
	//查找黑名单列表
	public List<Map> findBlackListById(String idNo){
		ResultSet rs = null;
		List<Map> list = new ArrayList<Map>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from zp_blacklist t ";
		if(!idNo.equals("")){
			sql = sql+" where id_no=? ";
		}
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			if(!idNo.equals("")){
				pst.setString(1, idNo);
			}
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Map map = new HashMap();
					map.put("idNo",rs.getString("id_no"));
					map.put("reason",rs.getString("reason"));
					list.add(map);
					}
				}
		}catch (SQLException e) {
			// e.printStackTrace();
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
		return list;
	}
	//查找黑名单列表
		public List<Map> findBlackList(){
			ResultSet rs = null;
			List<Map> list = new ArrayList<Map>();
			JdbcTemplate db = new JdbcTemplate();
			String sql = "select t.* from zp_blacklist t";
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Map map = new HashMap();
						map.put("idNo",rs.getString("id_no"));
						map.put("reason",rs.getString("reason"));
						list.add(map);
						}
					}
			}catch (SQLException e) {
				// e.printStackTrace();
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
			return list;
		}
		
		
		
//黑名单分页
		public List<Map> findBlackListpage(int shou,int mo,String idNo){
			ResultSet rs = null;
			List<Map> list = new ArrayList<Map>();
			JdbcTemplate db = new JdbcTemplate();
			String sql = "select * from (select t.*, rownum rc from zp_blacklist t where ";
			if(!idNo.equals("")){
				sql = sql+" id_no=? and ";
				
			}
			sql = sql + "rownum<=?) a where a.rc>?";
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				if(!idNo.equals("")){
					pst.setString(1, idNo);
					pst.setInt(2, mo);
					pst.setInt(3, shou);
					
				}else{
					pst.setInt(1, mo);
					pst.setInt(2, shou);	
				}
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Map map = new HashMap();
						map.put("idNo",rs.getString("id_no"));
						map.put("reason",rs.getString("reason"));
						list.add(map);
						}
					}
			}catch (SQLException e) {
				// e.printStackTrace();
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
			return list;
		}
		
	
	//添加黑名单
	public int addBlackList(String idNop,String reason){
		int i = 0;
//		System.out.println("idNop="+idNop);
//		System.out.println("reason="+reason);
		JdbcTemplate db = new JdbcTemplate();
		String sql = "insert into zp_blacklist(id_no,reason) values(?,?) ";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,idNop);
			pst.setString(2,reason);
			pst.executeUpdate(); 
			i = 1;
		}catch (SQLException e) {
			i =-1;
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}

		}
		db.close();
		return i;
	}
	
	//删除黑名单
	public int removeBlackList(String idNop){
		int i = 0;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "delete from zp_blacklist where id_no=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,idNop);
			pst.executeUpdate(); 
			i = 1;
		}catch (SQLException e) {
			i = -1;
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}

		}
		db.close();
		return i;
	}
	//查找用户列表
	public List<UserBean> findAllUserList(){
		
		ResultSet rs = null;
		List<UserBean> list = new ArrayList<UserBean>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.*,(select s.org_name from sys_org s where t.user_org = s.org_id) as org_name from sys_user t";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					UserBean user = new UserBean();
					user.setUserName(rs.getString("user_name"));
					user.setUserPass(rs.getString("user_pass"));
					user.setCreateTime(rs.getString("createtime"));
					user.setEnable(rs.getString("enable"));
					user.setOperater(rs.getString("operater"));
					user.setScale(rs.getString("scale"));
					user.setUserId(rs.getString("user_id"));
					user.setUserOrg(rs.getString("user_Org"));
					user.setUserPhone(rs.getString("user_Phone"));
					user.setUserType(rs.getString("user_Type"));
					user.setOrgName(rs.getString("org_name"));
					list.add(user);
				}
				
			}
			} catch (SQLException e) {
				// e.printStackTrace();
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
			return list;
	}
	//编辑用户信息
public List<UserBean> editUserList(String userid){
		
		ResultSet rs = null;
		List<UserBean> list = new ArrayList<UserBean>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.*,(select o.org_name from sys_org o where o.org_id=t.user_org ) as org_name,(select r.role_type from sys_role r where r.role_id=t.user_type ) as usertype from sys_user t where user_id=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,userid);
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					UserBean user = new UserBean();
					user.setUserName(rs.getString("user_name"));
					user.setUserPass(rs.getString("user_pass"));
					user.setCreateTime(rs.getString("createtime"));
					user.setEnable(rs.getString("enable"));
					user.setOperater(rs.getString("operater"));
					user.setScale(rs.getString("scale"));
					user.setUserId(rs.getString("user_id"));
					user.setUserOrg(rs.getString("user_Org"));
					user.setUserPhone(rs.getString("user_Phone"));
					user.setUserType(rs.getString("user_Type"));
					user.setUserType(rs.getString("user_Type"));
					user.setOrgName(rs.getString("org_name"));
					user.setUserRole(rs.getString("usertype"));
					list.add(user);
				}
				
			}
			} catch (SQLException e) {
				// e.printStackTrace();
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
			return list;
	}
    //修改用户信息
	public int editUser(String userid,String userName,String userOrg,String userPhone,String operater,
			String enable,String scale,String userType,String userpss){
		int i = 0;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "update sys_user set user_name=?,user_org=?,user_phone=?,operater=?,enable=?,user_type=?,scale=?,user_pass=? where user_id=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);;
		try{
			pst.setString(1,userName);
			pst.setString(2,userOrg);
			pst.setString(3,userPhone);
			pst.setString(4,operater);
			pst.setString(5,enable);
			pst.setString(6,userType);
			pst.setString(7,scale);
			pst.setString(8,MD5.getMD5String(userpss));
			pst.setString(9,userid);
			pst.executeUpdate(); 
			i = 1;
		}catch (SQLException e) {
			i=-1;
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}
	
		}
		db.close();
		return i;
	}
	//获取系统设置路径
	public String findFileIp(String setId) {
		List<Map> list = new ArrayList<Map>();
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from ZP_setup t where setup_id=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		String setvalue = "";
		try{
			pst.setString(1, setId);
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Map map = new HashMap();
					map.put("setupId", rs.getObject("setup_id"));
					map.put("setName", rs.getObject("set_name"));
					map.put("setValue",rs.getObject("set_value"));
					list.add(map);
				};
				setvalue = list.get(0).get("setValue").toString();
				}
				
			} catch (SQLException e) {
				// e.printStackTrace();
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
		
		return setvalue;
	}
	//查询单位
	public String findOrg(String userid){
		ResultSet rs = null;
		List<UserBean> list = new ArrayList<UserBean>();
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from sys_user t where user_id=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1, userid);
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					UserBean user = new UserBean();
					user.setUserName(rs.getString("user_name"));
					user.setUserPass(rs.getString("user_pass"));
					user.setCreateTime(rs.getString("createtime"));
					user.setEnable(rs.getString("enable"));
					user.setOperater(rs.getString("operater"));
					user.setScale(rs.getString("scale"));
					user.setUserId(rs.getString("user_id"));
					user.setUserOrg(rs.getString("user_Org"));
					user.setUserPhone(rs.getString("user_Phone"));
					user.setUserType(rs.getString("user_Type"));
					list.add(user);
				}
				
			}
			} catch (SQLException e) {
				// e.printStackTrace();
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
			return list.get(0).getUserOrg();
	}
	//保存用户权限
	public int saveUserRight(String pow,String rightUserId){
		int i = 0;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "update sys_user set user_right=? where user_id=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,pow);
			pst.setString(2,rightUserId);
			pst.executeUpdate(); 
			i = 1;
		}catch (SQLException e) {
			i=-1;
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}
	
		}
		db.close();
		return i;
	}
	
	//记录操作员更改日志
	public int writeSysLog(String operatorId,String pageId,String flowId,String change,String changeContent,String date,String ip ){
		int i = 0;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "insert into zp_log(operator_id,page_id,flow_id,change,change_date,ip,change_content) values(?,?,?,?, to_date(?,'YYYY-MM-DD HH24:MI:SS') ,?,?)";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,operatorId);
			pst.setString(2,pageId);
			pst.setString(3,flowId);
			pst.setString(4,change);
			pst.setString(5,date);
			pst.setString(6,ip);
			pst.setString(7,changeContent);
			pst.executeUpdate(); 
			i=1;
		}catch (SQLException e) {
			i = -1;
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}
			
		}
		db.close();
		return i;
	}
	
	//删除用户
	public int removeUser(String idNop){
		int i = 0;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "delete from sys_user where user_id=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,idNop);
			pst.executeUpdate(); 
			i = 1;
		}catch (SQLException e) {
			i = -1;
			// e.printStackTrace();
		}finally{
			if (db != null) {
				db.close();
			}

		}
		db.close();
		return i;
	}
	
	
	
	//添加用户
		public int addUser(String userId,String userName,String userOrg,String userPho,String createTime,
				String operater,String enable,String userRight,String userType,String userpass){
			int i = 0;
			JdbcTemplate db = new JdbcTemplate();
			String sql = "insert into sys_user(user_id,user_Name,user_org,user_phone,createtime,operater,enable,user_right,user_type,user_pass) values(?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI:SS'),?,?,?,?,?)";
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				pst.setString(1,userId);
				pst.setString(2,userName);
				pst.setString(3,userOrg);
				pst.setString(4,userPho);
				pst.setString(5,createTime);
				pst.setString(6,operater);
				pst.setString(7,enable);
				pst.setString(8,userRight);
				pst.setString(9,userType);
				pst.setString(10,MD5.getMD5String(userpass));
				pst.executeUpdate(); 
				i = 1;
			}catch (SQLException e) {
				i = -1;
				// e.printStackTrace();
			}finally{
				if (db != null) {
					db.close();
				}

			}
			db.close();
			return i;
		}
//查找用户类型
		public List<Map> findUserType(){
			ResultSet rs = null;
			List<Map> list = new ArrayList<Map>();
			JdbcTemplate db = new JdbcTemplate();
			String sql = "select t.*, t.rowid from sys_role t";
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Map map = new HashMap();
						map.put("typeId",rs.getString("role_id"));
						map.put("typeName",rs.getString("role_type"));
						list.add(map);
						}
					}
			}catch (SQLException e) {
				// e.printStackTrace();
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
			return list;
		}
		//查找单位列表
				public List<Map> findORGTList(){
					ResultSet rs = null;
					List<Map> list = new ArrayList<Map>();
					JdbcTemplate db = new JdbcTemplate();
					String sql = "select t.*, t.rowid from sys_org t";
					PreparedStatement pst= db.GetPrepareStatement(sql);
					try{
						rs=pst.executeQuery();
						if (rs != null) {
							while (rs.next()) {
								Map map = new HashMap();
								map.put("orgId",rs.getString("org_id"));
								map.put("orgName",rs.getString("org_name"));
								list.add(map);
								}
							}
					}catch (SQLException e) {
						// e.printStackTrace();
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
					return list;
				}
		//查询状态列表
				public List<Map> findStatusList(){
					ResultSet rs = null;
					List<Map> list = new ArrayList<Map>();
					JdbcTemplate db = new JdbcTemplate();
					String sql = "select t.* from zp_status t";
					PreparedStatement pst= db.GetPrepareStatement(sql);
					try{
						rs=pst.executeQuery();
						if (rs != null) {
							while (rs.next()) {
								Map map = new HashMap();
								map.put("statusId",rs.getString("status_id"));
								map.put("statusName",rs.getString("status_name"));
								list.add(map);
								}
							}
					}catch (SQLException e) {
						// e.printStackTrace();
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
					return list;
				}	
				
//根据用户类型查询默认权限
		public String findRightByType(String usertype){
			ResultSet rs = null;
			List<Map> list = new ArrayList<Map>();
			JdbcTemplate db = new JdbcTemplate();
			String sql = "select t.*, t.rowid from sys_user_role t where user_type=?";
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				pst.setString(1, usertype);
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Map map = new HashMap();
						map.put("userType",rs.getString("user_Type"));
						map.put("userRole",rs.getString("user_Role"));
						list.add(map);
						}
					}
			}catch (SQLException e) {
				// e.printStackTrace();
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
			
			return list.get(0).get("userRole").toString();
		}
		public List<UserBean> findUserListByX(String userType, String userid, String userOrg) {
			ResultSet rs = null;
			List<UserBean> list = new ArrayList<UserBean>();
			JdbcTemplate db = new JdbcTemplate();
			String sql = "select t.*,(select s.org_name from sys_org s where t.user_org = s.org_id) as org_name from sys_user t where 1=1 ";
			if(!userType.equals("")){
				sql = sql +" and user_type='"+userType+"'";
			}
			if(!userid.equals("")){
				sql = sql +" and user_id='"+userid+"'";
			}
			if(!userOrg.equals("")){
				sql = sql +" and user_Org='"+userOrg+"'";
			}
			//System.out.println("sql="+sql);
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						UserBean user = new UserBean();
						user.setUserName(rs.getString("user_name"));
						user.setUserPass(rs.getString("user_pass"));
						user.setCreateTime(rs.getString("createtime"));
						user.setEnable(rs.getString("enable"));
						user.setOperater(rs.getString("operater"));
						user.setScale(rs.getString("scale"));
						user.setUserId(rs.getString("user_id"));
						user.setUserOrg(rs.getString("user_Org"));
						user.setUserPhone(rs.getString("user_Phone"));
						user.setUserType(rs.getString("user_Type"));
						user.setOrgName(rs.getString("org_name"));
						list.add(user);
					}
					
				}
				} catch (SQLException e) {
					// e.printStackTrace();
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
				return list;
		} 
		public List<UserBean> findUserListByXpage(int shou,int mo,String userType, String userid, String userOrg) {
			ResultSet rs = null;
			List<UserBean> list = new ArrayList<UserBean>();
			JdbcTemplate db = new JdbcTemplate();
			String sql = "select * from (select t.*,rownum rc,(select s.org_name from sys_org s where t.user_org = s.org_id) as org_name from sys_user t where 1=1 ";
			if(!userType.equals("")){
				sql = sql +" and user_type='"+userType+"'";
			}
			if(!userid.equals("")){
				sql = sql +" and user_id='"+userid+"'";
			}
			if(!userOrg.equals("")){
				sql = sql +" and user_Org='"+userOrg+"'";
			}
			sql = sql +" and rownum<=?) a where a.rc>?";
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				pst.setInt(1, mo);
				pst.setInt(2, shou);
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						UserBean user = new UserBean();
						user.setUserName(rs.getString("user_name"));
						user.setUserPass(rs.getString("user_pass"));
						user.setCreateTime(rs.getString("createtime"));
						user.setEnable(rs.getString("enable"));
						user.setOperater(rs.getString("operater"));
						user.setScale(rs.getString("scale"));
						user.setUserId(rs.getString("user_id"));
						user.setUserOrg(rs.getString("user_Org"));
						user.setUserPhone(rs.getString("user_Phone"));
						user.setUserType(rs.getString("user_Type"));
						user.setOrgName(rs.getString("org_name"));
						list.add(user);
					}
					
				}
				} catch (SQLException e) {
					// e.printStackTrace();
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
				return list;
		} 
	//体检站业务数量	
 		public List<FlowBean> findBusinessList(String time, String BusinessType, String temp) {
			ResultSet rs = null;
			List<FlowBean> list = new ArrayList<FlowBean>();
			JdbcTemplate db = new JdbcTemplate();			
			String sql = "select t.* from zp_flow t where";
			if(BusinessType.equals("") && time.equals("") ){
				sql = sql +" flow_no like '________"+temp+"%'";
			}
			if(!BusinessType.equals("") && time.equals("") ){
				sql = sql +" flow_type='"+BusinessType+"'";
				sql = sql +" and flow_no like '________"+temp+"%'";
			}
			if(!time.equals("") && BusinessType.equals("")){
				sql = sql +" flow_no like '"+temp+"%'";
			}
			if(!BusinessType.equals("") && !time.equals("")){
				sql = sql +" flow_type='"+BusinessType+"'";
				sql = sql +" and flow_no like '"+temp+"%'";
			}
//			System.out.println("sql="+sql);
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				rs=pst.executeQuery(sql);
				if (rs != null) {
					while (rs.next()) {
						FlowBean flow = new FlowBean();
						flow.setFlowId(rs.getString("flow_id"));
                        flow.setFlowNo(rs.getString("flow_no"));
                        flow.setFlowType(rs.getString("flow_type"));
                        flow.setZjlx(rs.getString("zjlx"));
                        flow.setZjhm(rs.getString("zjhm"));
                        flow.setImgurl(rs.getString("img_url"));
                        flow.setStatu(rs.getString("statu"));
                        flow.setBase64(rs.getString("base64"));
                        flow.setIdbase64(rs.getString("id_base64"));
						list.add(flow);
					}					
				}
				} catch (SQLException e) {
					// e.printStackTrace();
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
				return list;
		}
 		public List<FlowBean> findBusinessListPage(int shou,int mo,String time, String BusinessType, String temp) {
			ResultSet rs = null;
			List<FlowBean> list = new ArrayList<FlowBean>();
			JdbcTemplate db = new JdbcTemplate();			
			String sql = "select * from (select t.*,rownum rc from zp_flow t where";
			if(BusinessType.equals("") && time.equals("") ){
				sql = sql +" flow_no like '________"+temp+"%'";
			}
			if(!BusinessType.equals("") && time.equals("") ){
				sql = sql +" flow_type='"+BusinessType+"'";
				sql = sql +" and flow_no like '________"+temp+"%'";
			}
			if(!time.equals("") && BusinessType.equals("")){
				sql = sql +" flow_no like '"+temp+"%'";
			}
			if(!BusinessType.equals("") && !time.equals("")){
				sql = sql +" flow_type='"+BusinessType+"'";
				sql = sql +" and flow_no like '"+temp+"%'";
			}
			sql = sql + "and rownum<=?) a where a.rc>?";
//			System.out.println("sal="+sql);
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				pst.setInt(1, mo);
				pst.setInt(2, shou);
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						FlowBean flow = new FlowBean();
						flow.setFlowId(rs.getString("flow_id"));
                        flow.setFlowNo(rs.getString("flow_no"));
                        flow.setFlowType(rs.getString("flow_type"));
                        flow.setZjlx(rs.getString("zjlx"));
                        flow.setZjhm(rs.getString("zjhm"));
                        flow.setImgurl(rs.getString("img_url"));
                        flow.setStatu(rs.getString("statu"));
                        flow.setBase64(rs.getString("base64"));
                        flow.setIdbase64(rs.getString("id_base64"));
						list.add(flow);
					}					
				}
				} catch (SQLException e) {
					// e.printStackTrace();
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
				return list;
		}
	//分页
		 public int[] findPage(int pageNum,int pageSize,int totalRecord){
		    	int[] shouMo = new int[3];
		    	int totalPage = 0;
		        //totalPage 总页数
		        if(totalRecord%pageSize==0){
		            //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
		        	if(totalRecord==0){
		        		totalPage = 1;
		        	}else{
		            totalPage = totalRecord / pageSize;
		        	}
		        }else{
		            //不整除，就要在加一页，来显示多余的数据。
		            totalPage = totalRecord / pageSize +1;
		        }
		        shouMo[0] = (pageNum-1)*pageSize;  //起始条
		        shouMo[1] = pageNum * pageSize;    //结束条
		        shouMo[2] = totalPage;
		    	
		    	return shouMo;
		    };
		    
		    
		//查找用户规模
		    public String findScale(String date,String userid){
		    	
		    	ResultSet rs = null;
		    	JdbcTemplate db = new JdbcTemplate();
		    	String sql = "select count(1) as scale from zp_flow t where flow_no like ? and user_id=?";
		    	String scale = "";
		    	PreparedStatement pst= db.GetPrepareStatement(sql);
		    	try{
		    		pst.setString(1,date);
		    		pst.setString(2,userid);
		    		rs=pst.executeQuery();
		    		while (rs.next()) {
		    			scale = rs.getNString("scale");
		    		
		    		}
		    	} catch (SQLException e) {
		    		// e.printStackTrace();
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
		    	
		    	return scale;
		    	
		    			
		    }
		//业务统计（管理员）
		
		public List<FlowBean> findBusinessCountList(String time, String BusinessType, String status) {
			ResultSet rs = null;
			List<FlowBean> list = new ArrayList<FlowBean>();
			JdbcTemplate db = new JdbcTemplate();			
			String sql = "select t.* from zp_flow t where";
			if(time.equals("")){
				if(BusinessType.equals("")){
					if(status.equals("")){
						sql = sql +" 1=1 ";
					}else{
						sql = sql +" statu='"+status+"'";
					}
				}else{
					if(status.equals("")){
						sql = sql +" flow_type='"+BusinessType+"'";
					}else{
						sql = sql +" statu='"+status+"'";
						sql = sql +" and flow_type='"+BusinessType+"'";
					}
				}
			}else{
				if(BusinessType.equals("") ){
					if(status.equals("")){						
						sql = sql +" flow_no like '"+time+"%'";
					}else{
						sql = sql +" statu='"+status+"'";
						sql = sql +" and flow_no like '"+time+"%'";
					}
				}else{
					if(status.equals("")){						
						sql = sql +" flow_type='"+BusinessType+"'";
						sql = sql +" and flow_no like '"+time+"%'";
					}else{
						sql = sql +" statu='"+status+"'";
						sql = sql +" and flow_type='"+BusinessType+"'";
						sql = sql +" and flow_no like '"+time+"%'";
					}
				}
			}
//			System.out.println("sql=="+sql);
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						FlowBean flow = new FlowBean();
						flow.setFlowId(rs.getString("flow_id"));
                        flow.setFlowNo(rs.getString("flow_no"));
                        flow.setFlowType(rs.getString("flow_type"));
                        flow.setZjlx(rs.getString("zjlx"));
                        flow.setZjhm(rs.getString("zjhm"));
                        flow.setImgurl(rs.getString("img_url"));
                        flow.setStatu(rs.getString("statu"));
                        flow.setBase64(rs.getString("base64"));
                        flow.setIdbase64(rs.getString("id_base64"));
						list.add(flow);
					}					
				}
				} catch (SQLException e) {
					// e.printStackTrace();
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
				return list;
		} 
		public List<FlowBean> findBusinessCountListPage(int shou,int mo,String time, String BusinessType, String status) {
			ResultSet rs = null;
			List<FlowBean> list = new ArrayList<FlowBean>();
			JdbcTemplate db = new JdbcTemplate();			
			String sql = "select * from (select t.*,rownum rc from zp_flow t where";
			if(time.equals("")){
				if(BusinessType.equals("")){
					if(status.equals("")){
						sql = sql +" 1=1 ";
					}else{
						sql = sql +" statu='"+status+"'";
					}
				}else{
					if(status.equals("")){
						sql = sql +" flow_type='"+BusinessType+"'";
					}else{
						sql = sql +" statu='"+status+"'";
						sql = sql +" and flow_type='"+BusinessType+"'";
					}
				}
			}else{
				if(BusinessType.equals("") ){
					if(status.equals("")){						
						sql = sql +" flow_no like '"+time+"%'";
					}else{
						sql = sql +" statu='"+status+"'";
						sql = sql +" and flow_no like '"+time+"%'";
					}
				}else{
					if(status.equals("")){						
						sql = sql +" flow_type='"+BusinessType+"'";
						sql = sql +" and flow_no like '"+time+"%'";
					}else{
						sql = sql +" statu='"+status+"'";
						sql = sql +" and flow_type='"+BusinessType+"'";
						sql = sql +" and flow_no like '"+time+"%'";
					}
				}
			}
			sql = sql + "and rownum<=?) a where a.rc>?";
//			System.out.println("sql=="+sql);
			PreparedStatement pst= db.GetPrepareStatement(sql);
			try{
				pst.setInt(1, mo);
				pst.setInt(2, shou);
				rs=pst.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						FlowBean flow = new FlowBean();
						flow.setFlowId(rs.getString("flow_id"));
                        flow.setFlowNo(rs.getString("flow_no"));
                        flow.setFlowType(rs.getString("flow_type"));
                        flow.setZjlx(rs.getString("zjlx"));
                        flow.setZjhm(rs.getString("zjhm"));
                        flow.setImgurl(rs.getString("img_url"));
                        flow.setStatu(rs.getString("statu"));
                        flow.setBase64(rs.getString("base64"));
                        flow.setIdbase64(rs.getString("id_base64"));
						list.add(flow);
					}					
				}
				} catch (SQLException e) {
					// e.printStackTrace();
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
				return list;
		} 
		
		public int insertScale(String userid,String date){
			int i = 0;
			System.out.println("date="+date);
			JdbcTemplate db = new JdbcTemplate();
			String sql = "update sys_user set scale=(select count(1) as scale from zp_flow t where flow_no like ? and user_id=?) where user_id=?";
			PreparedStatement pst= db.GetPrepareStatement(sql);;
			try{
				pst.setString(1,date+"%");
				pst.setString(2,userid);
				pst.setString(3,userid);
				pst.executeUpdate(); 
				i = 1;
			}catch (SQLException e) {
				i=-1;
				// e.printStackTrace();
			}finally{
				if (db != null) {
					db.close();
				}
		
			}
			db.close();
			return i;
		}
}
