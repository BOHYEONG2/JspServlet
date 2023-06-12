package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.MemberVO;
import kr.ac.kopo.rentBook.RentBookDAO;
import kr.ac.kopo.rentBook.RentBookVO;

public class MyBooksController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		String id = loginUser.getId();
		
		RentBookDAO dao = new RentBookDAO();
		List<RentBookVO> rentvo = dao.getRentedBooks(id);
		
		request.setAttribute("myBooks", rentvo);
		
		
		
		return "/jsp/book/myBooks.jsp";
	}
	
}
