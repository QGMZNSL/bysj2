package qxjc.peszp.ImpService;

import java.util.Map;

import qxjc.peszp.bean.FlowBean;
import qxjc.peszp.bean.IdInformationBean;

public interface ImpPeszp {
	//登录
	public Map login(String userid,String userpass);
	//读取身份证信息
	public IdInformationBean readIdInformation(String userid);
	//人脸识别
	public int faceRecognition();
	//手工输入
	int readCarId(String flowId, String flowNo, String flowType, String zjlx, String zjhm, String idcardPhotoBuff,
			String img, String statu);
	FlowBean photo(String zjhm, String idcardPhotoBuff);
	int searchReport();
	int adminIsEnable(String enable, String roleid, String userid);

}
