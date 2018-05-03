package bysj.zxpc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bysj.zxpc.bean.CourseBean;
import bysj.zxpc.db.JdbcTemplate;

public class BaseDao {
	public Map login(String userid) {
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from base_user t where user_name=?";
		Map user = new HashMap();
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,userid);
			rs=pst.executeQuery();
				while (rs.next()) {
					user.put("UserName", rs.getString("user_name"));
					user.put("UserPass", rs.getString("user_pass"));
					user.put("UserPhone", rs.getString("user_phone"));
					user.put("UserRole", rs.getString("user_role"));
					user.put("UserSex", rs.getString("user_sex"));

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
		
		return user;
	}
	public List<CourseBean> findCourse() {
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from base_course t";
		List<CourseBean> courseList = new ArrayList<CourseBean>();
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			rs=pst.executeQuery();
				while (rs.next()) {
					CourseBean cb = new CourseBean();
					cb.setCourseId(rs.getInt("course_id"));
					cb.setCourseName(rs.getString("course_name"));
					cb.setCourseTime(rs.getInt("course_time"));
					cb.setCourseGra(rs.getInt("course_gra"));
					cb.setCourseTea(rs.getString("course_gra"));
					cb.setCourseBz(rs.getString("course_gra"));
					courseList.add(cb);
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
		
		return courseList;
	}
	

}
