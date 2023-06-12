package kr.ac.kopo.controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.rentBook.RentBookDAO;
import kr.ac.kopo.rentBook.RentBookVO;

public class RentalListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId"); // 사용자 ID를 파라미터로 받아옴

	    RentBookDAO dao = new RentBookDAO();
	    List<RentBookVO> rentvo = dao.getRentedBooks(userId); // 회원 ID를 전달하여 메서드 호출
	    request.setAttribute("rentedusers", rentvo);

	    return "/jsp/rentedUsers.jsp";
	}
}