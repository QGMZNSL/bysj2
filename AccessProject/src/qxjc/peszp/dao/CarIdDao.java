
package qxjc.peszp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import qxjc.peszp.ImpService.ImpPeszp;
import qxjc.peszp.bean.FlowBean;
import qxjc.peszp.bean.IdInformationBean;
import qxjc.peszp.bean.UserBean;
import qxjc.peszp.jdbc.JdbcTemplate;

public class CarIdDao{

	public int readCarId(String flowId, String flowNo, String flowType, String zjlx, String zjhm, String idcardPhotoBuff,
			String img, String statu) {
	    int n=0;
		FlowBean flow = new FlowBean();
		ResultSet rs = null;
		JdbcTemplate db = new JdbcTemplate();
		String sql = "insert into zp_flow(zjlx,zjhm,base64) values("+"身份证"+",?,?) ";
		System.out.println("sql=="+sql);
		PreparedStatement pst= db.GetPrepareStatement(sql);
		try{
				pst.setString(1,zjhm);
				pst.setString(2,idcardPhotoBuff);
				n=pst.executeUpdate();
			} catch (SQLException e) {
				n=0;
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
	return n;
	}

	
}
