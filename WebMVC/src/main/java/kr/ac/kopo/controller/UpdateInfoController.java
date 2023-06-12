package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;

public class UpdateInfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {	
		
		return "/jsp/login/updateInfo.jsp";
	}
	
	
	
}