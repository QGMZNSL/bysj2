package bysj.zxpc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bysj.zxpc.bean.CourseBean;
import bysj.zxpc.bean.MenuBean;
import bysj.zxpc.dao.BaseDao;
import bysj.zxpc.dao.MenuDao;

public class LoginService {
	//登录
	public Map loginService(String userName,String userPass){
		int i = 0;
		BaseDao bd = new BaseDao();
		Map usermap = new HashMap();
		usermap = bd.login(userName);
		return usermap;
	}
	//查找功能菜单
	public List<MenuBean> findMenuService(String userRole){
		MenuDao md = new MenuDao();
		List<MenuBean> muneList = new ArrayList<MenuBean>();
		muneList = md.findMune(userRole);
		return muneList;
	}
	//查找课程目录
	public List<CourseBean> findCourseService(){
		BaseDao bd = new BaseDao();
		List<CourseBean> courseList = new ArrayList<CourseBean>();
		courseList = bd.findCourse();
		return courseList;
	}

}
