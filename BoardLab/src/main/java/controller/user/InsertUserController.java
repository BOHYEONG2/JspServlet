package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class InsertUserController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id"); 
		String password = request.getParameter("password"); 
		String name = request.getParameter("name"); 
		String role = request.getParameter("role"); 
		
		UserVO vo = new UserVO(); //vo에 담아주기
		vo.setId(id);
		vo.setName(name);
		vo.setPassword(password);
		vo.setRole(role);
		
		UserDAO dao = new UserDAO();
		dao.insertUser(vo);
		
		return "login.html";
		
	}
}