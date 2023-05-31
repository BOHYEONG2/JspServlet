package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		// VO에 아이디랑 비밀번호 담고, // 이제 확인을 해야함 >> UserDAO로 넘어가서 
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "Ok.jsp";
		} else {
			return "login.html";
		}
		
	}
}
