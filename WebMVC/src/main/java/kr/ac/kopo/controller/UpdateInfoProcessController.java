package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberDAO;
import kr.ac.kopo.member.MemberVO;

public class UpdateInfoProcessController implements Controller  {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String pwcheck = request.getParameter("pwcheck");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPassword(password);
        vo.setName(name);
        vo.setPhone(phone);

        MemberDAO dao = new MemberDAO();
        MemberVO user = dao.login(vo);

        MemberVO chuser = new MemberVO();
        chuser.setId(id);
        chuser.setPassword(pw);
        chuser.setName(name);
        chuser.setPhone(phone);

        String msg = "";
        String url = "";


		if(user != null && pw != "" && pw.equals(pwcheck)) {
			dao.updateInfo(chuser);
			loginUser.setName(name);
			loginUser.setPhone(phone);
			loginUser.setPassword(pw);
			session.setAttribute("loginUser", loginUser);
			
			msg = "수정 완료";
			url = "WebMVC/mypage.do";
			
			// 사용자 정보를 userInfo 변수에 저장
		    request.setAttribute("userInfo", loginUser);
		}else if(user != null && pw == ""){
			dao.updateInfo(vo);
			loginUser.setName(name);
			loginUser.setPhone(phone);
			loginUser.setPassword(password);
			session.setAttribute("loginUser", loginUser);
			msg = "수정 완료";
			url = "WebMVC/mypage.do";
			// 사용자 정보를 userInfo 변수에 저장
		    request.setAttribute("userInfo", loginUser);
		}
		else {
			msg = "비밀번호를 잘못 입력했습니다";
			url = "WebMVC/updateInfo.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
		  return "/jsp/login/myPage.jsp";
	}
}