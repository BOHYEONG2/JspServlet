package kr.ac.kopo.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.rentBook.RentBookDAO;

public class ReturnBookController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		int bookNo = Integer.parseInt(request.getParameter("bno"));
		
		BookDAO bookdao = new BookDAO();
		bookdao.rentCheck(bookNo);
		
		RentBookDAO rentdao = new RentBookDAO();
		rentdao.returnBook(bookNo);
		
		String msg = "반납 완료";
		String url = "/WebMVC/getBookList.do";
		
		request.setAttribute("msg", msg);
	    request.setAttribute("url", url);
		
		return "/jsp/book/returnBookProcess.jsp";
		
	}
	
	
}
