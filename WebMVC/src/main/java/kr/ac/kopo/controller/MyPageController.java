package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;

public class MyPageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
	
		
		MemberDAO memberDAO = new MemberDAO();
		MemberVO userInfo = memberDAO.getUser(loginUser.getId());
		
		request.setAttribute("userInfo", userInfo);
		
		return "/jsp/login/myPage.jsp";
	}
}