package qxjc.peszp.jdbc;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import qxjc.peszp.jdbc.DbResult;
import qxjc.peszp.jdbc.JdbcTemplate;

public class LogUtil {

	public static void debug(String type,String info){
//		JdbcTemplate db=null;
//		
//		try{
//			info=info.replace('\'', '‘');
//			info=info.replace('\"', '“');
//			info=info.replace('\r', 'r');
//			info=info.replace('\n', 'n');
//			String sql=String.format("insert into sys_debug_log values(sysdate,'%1$s','%2$s')", type,info);
//			db = new JdbcTemplate();
//			DbResult result = db.Execute("!"+sql);
//		}catch(Exception exx){
//			exx.printStackTrace();
//		}finally{
//			if(db!=null)
//				db.close();
//		}
	}

	public static void debugx(String type,String info){
		JdbcTemplate db=null;
		
		try{
			info=info.replace('\'', '‘');
			info=info.replace('\"', '“');
			info=info.replace('\r', 'r');
			info=info.replace('\n', 'n');
			String sql=String.format("insert into sys_debug_log values(sysdate,'%1$s','%2$s')", type,info);
			db = new JdbcTemplate();
			DbResult result = db.Execute("!"+sql);
		}catch(Exception exx){
			exx.printStackTrace();
		}finally{
			if(db!=null)
				db.close();
		}
	}


	public static void debug(String type,Exception e){
//		try {
//			ByteArrayOutputStream bos=new ByteArrayOutputStream();
//			PrintStream ps;
//			ps = new PrintStream(bos,true,"gbk");
//			String stack=new String(bos.toByteArray(),"gbk");
//			debug(type,e.getMessage()+"\r\n"+stack);
//			ps.close();
//			bos.close();
//			e.printStackTrace(ps);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
	}
}
