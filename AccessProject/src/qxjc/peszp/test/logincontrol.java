package qxjc.peszp.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qxjc.peszp.jdbc.JdbcTemplate;

@Controller 

public class logincontrol {

    @RequestMapping("logintest")  

    public String Login(String UserName, String UserPassword) {
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "select t.* from sys_user t where user_id=? and user_pass=?";
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
			pst.setString(1,"22");
			pst.setString(2,"123456");
			rs=pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					System.out.println("sql="+sql);
					return "seccuss";
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
			return "Error";
		
	}

}

 