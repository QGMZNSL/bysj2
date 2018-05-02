package qxjc.peszp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import qxjc.peszp.bean.MenuBean;
import qxjc.peszp.bean.ModuleTool;
import qxjc.peszp.jdbc.JdbcTemplate;

public class MenuDao {
	
	public List<MenuBean> findAllMenu(String user_type){
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select * from sys_menu m where m.enable = 1  and bitand(m.right, ?) = ? order by m.menu_id asc";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		List<MenuBean> menulist = new ArrayList<MenuBean>();
		try{
			pst.setString(1, user_type);
			pst.setString(2, user_type);
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					MenuBean mb = new MenuBean();
					mb.setTreeId(rs.getString("tree_id"));
					mb.setTreeType(rs.getString("tree_type"));
					mb.setTreeRole(rs.getString("tree_role"));
					mb.setUrl(rs.getString("tree_url"));
					mb.setTreeName(rs.getString("tree_name"));
					menulist.add(mb);
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
		return menulist;
		}
	
	public List<MenuBean> findMenu(String userRight){
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "SELECT t.* FROM base_tree t WHERE (?&tree_role)=? ORDER BY t.tree_id";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		List<MenuBean> menulist = new ArrayList<MenuBean>();
		try{
			pst.setString(1, userRight);
			pst.setString(2, userRight);
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					MenuBean mb = new MenuBean();
					mb.setTreeId(rs.getString("tree_id"));
					mb.setTreeType(rs.getString("tree_role"));
					mb.setTreeRole(rs.getString("tree_role"));
					mb.setTreeName(rs.getString("tree_name"));
					mb.setUrl(rs.getString("tree_url"));
					menulist.add(mb);
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
		return menulist;
		}
	//拼接字符串
			public String pwrLink(String[] pwrIndexes) {
				int[] power = new int[ModuleTool.MODULE_MAX_INDEX_COUNT];
				// 对传递过来的权限列表排序
				String tmpPwr = null;
				for (int i = 0; i < pwrIndexes.length; i++) {
					for (int j = i + 1; j < pwrIndexes.length; j++) {
						if (Integer.parseInt(pwrIndexes[i]) > Integer
								.parseInt(pwrIndexes[j])) {
							tmpPwr = pwrIndexes[i];
							pwrIndexes[i] = pwrIndexes[j];
							pwrIndexes[j] = tmpPwr;
						}
					}
				}
				int point = 0;
				int pwrIndex = 0;
				boolean indexesIsNull = pwrIndexes == null
						|| pwrIndexes.length == 0;
				for (int idx = 1; idx <= power.length; idx++) {
					if (indexesIsNull) {
						power[idx - 1] = 0;
					} else {
						pwrIndex = Integer.parseInt(pwrIndexes[point]);
						// 位数相等时，位数-1的值变为1
						if (pwrIndex == idx) {
							power[idx - 1] = 1;
							point++;

							// 保存的权限位数组的指针位达到数组末尾时，结束循环
							if (point == pwrIndexes.length)
								break;
						}
					}
				}

				// 连接权限码
				StringBuilder pwrBuf = new StringBuilder();
				for (int p : power)
					pwrBuf.append(p);
				return pwrBuf.toString();
			}
}

