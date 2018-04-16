package qxjc.peszp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import qxjc.peszp.bean.MenuBean;
import qxjc.peszp.dao.MenuDao;

@Controller
public class MenuAction {
	@RequestMapping("menu")
	public String Login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<MenuBean> menulist = null;
		String userRole = session.getAttribute("userRole").toString();
		MenuDao md = new MenuDao();
		menulist = md.findMenu(userRole);
		session.setAttribute("menulist",menulist);
		return "left";			

	}

}