package bysj.zxpc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bysj.zxpc.bean.MenuBean;
import bysj.zxpc.db.JdbcTemplate;

public class MenuDao {
	public List<MenuBean> findMune(String userRole){
		List<MenuBean> muneList = new ArrayList<MenuBean>();
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select * from base_tree m where  (m.tree_role& ?) = ? order by m.tree_id asc";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,userRole);
			pst.setString(2,userRole);
			rs=pst.executeQuery();
				while (rs.next()) {
					MenuBean mb = new MenuBean();
					mb.setTreeId(rs.getString("tree_id"));
					mb.setTreeName(rs.getString("tree_name"));
					mb.setTreeRole(rs.getString("tree_role"));
					mb.setTreeType(rs.getString("tree_type"));
					mb.setTreeUrl(rs.getString("tree_url"));
					muneList.add(mb);
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
		
		return muneList;
	}
	public List<Map> findTwoCourse(int courseId,String proRole) {
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from base_project t where couese_id=? and project_role=?";
		List<Map> proList = new ArrayList<Map>();
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setInt(1, courseId);
			pst.setString(2, proRole);
			rs=pst.executeQuery();
				while (rs.next()) {
					Map promap = new HashMap();
					promap.put("proId", rs.getInt("project_id"));
					promap.put("proName", rs.getString("project_name"));
					promap.put("proRole", rs.getString("project_role"));
					promap.put("courseId", rs.getInt("couese_id"));
					proList.add(promap);
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
		
		return proList;
	}

}
