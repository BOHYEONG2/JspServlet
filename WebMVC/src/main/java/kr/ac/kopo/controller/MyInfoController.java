package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberVO;

public class MyInfoController implements Controller {
	
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user");

        if (user != null) {
            request.setAttribute("user", user);
            return "/jsp/user/myPage.jsp";
        } else {
            return "/jsp/login/login.jsp";
        }
    }

}