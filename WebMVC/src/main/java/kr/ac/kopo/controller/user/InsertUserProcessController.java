package kr.ac.kopo.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;

public class InsertUserProcessController implements Controller {

		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			request.setCharacterEncoding("utf-8");
			
			
			String id = request.getParameter("id");
			String password = request.getParameter("password"); 
			String name = request.getParameter("name"); 
			String phone = request.getParameter("phone");
	        String birthday = request.getParameter("birthday");
			
			MemberVO vo = new MemberVO(); //vo에 담아주기
			vo.setId(id);
			vo.setPassword(password);
			vo.setName(name);
			vo.setPhone(phone);
		    vo.setBirthday(birthday);
			
			MemberDAO dao = new MemberDAO();
			dao.insertUser(vo);
			
			return "/jsp/login/login.jsp";
		}
}
