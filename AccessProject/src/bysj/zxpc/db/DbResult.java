package bysj.zxpc.db;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author sc4 数据库操作返回值存储类
 * 
 */
public class DbResult {

	/**
	 * 标准返回对象（执行"select max(id) from ..."之类返回首行一个字段值语句时的结果）
	 */
	public Object Result;

	/**
	 * 捕捉到的异常（没有异常的话为null）
	 */
	public Exception Exception;

	/**
	 * 描述错误的文本
	 */
	public String ErrorText;

	/**
	 * 是否执行成功
	 */
	public boolean IsSuccess;

	/**
	 * 受到影响的行数
	 */
	public long AffectedLines;

	/**
	 * 用GetSequenceID方法得到的新的可用的唯一ID
	 */
	public long SequenceID;

	/**
	 * 得到的ResultSet
	 */
	public ResultSet ResultSet;

	/**
	 * 得到的List<Map>
	 */
	public List<Map> List;

	protected void finalize() {
		if (ResultSet != null) {
			try {
				ResultSet.close();
			} catch (Exception e) {
			}
		}
	}
}
