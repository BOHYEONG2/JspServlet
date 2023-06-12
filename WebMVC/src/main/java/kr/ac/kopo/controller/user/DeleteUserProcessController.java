package kr.ac.kopo.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;
import kr.ac.kopo.rentBook.RentBookDAO;
import kr.ac.kopo.rentBook.RentBookVO;

public class DeleteUserProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String pwcheck = request.getParameter("pwcheck");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		
		MemberDAO dao = new MemberDAO();
		MemberVO user = dao.login(vo);
		
		RentBookDAO rentdao = new RentBookDAO();
		List<RentBookVO> rentvo = rentdao.getRentedBooks(id);
		
		
		String msg = "";
		String url = "";
			
		if(user != null && password.equals(pwcheck) && rentvo.size() == 0) {
			dao.deleteUser(vo);
			HttpSession session = request.getSession();
			session.invalidate();
			msg = "탈퇴 완료";
			url = "/WebMVC/main.do";
		}else if(rentvo.size() != 0){
			msg = "대여중인 책이 있습니다.";
			url = "/WebMVC/myBooks.do";
		
		}else {
		
			msg = "비밀번호를 잘못 입력했습니다";
			url = "/WebMVC/deleteUser.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/login/deleteuserprocess.jsp";
	}
	
}
