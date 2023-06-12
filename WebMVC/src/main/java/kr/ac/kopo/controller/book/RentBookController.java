package kr.ac.kopo.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.rentBook.RentBookDAO;
import kr.ac.kopo.rentBook.RentBookVO;

public class RentBookController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		
		String id = request.getParameter("id");
		int bookNo = Integer.parseInt(request.getParameter("no"));
			
		BookDAO dao = new BookDAO();
		dao.rentAvailable(bookNo);
		
		RentBookVO rentBook = new RentBookVO();
		rentBook.setBookNo(bookNo);
		rentBook.setId(id);
		
		RentBookDAO rentdao = new RentBookDAO();
		rentdao.rentBook(rentBook);
		
		String msg = "대출 완료";
		String url = "/WebMVC/getBookList.do";
		
		 request.setAttribute("msg", msg);
	     request.setAttribute("url", url);
		
		return "/jsp/book/rentBookProcess.jsp";
	}
	
}