package kr.ac.kopo.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class InsertBookProcessController implements Controller {

	@Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
  	
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String publisher = request.getParameter("publisher");
    boolean isAvailable = Boolean.parseBoolean(request.getParameter("isAvailable"));
    // boolean isAvailable = request.getParameter("isAvailable") != null;
    // BookVO 객체 생성
    BookVO book = new BookVO();
    book.setTitle(title);
    book.setWriter(writer);
    book.setPublisher(publisher);

    // BookDAO 생성 및 책 등록 메서드 호출
    BookDAO bookDAO = new BookDAO();
    bookDAO.insertBook(book);
    	
    
    return "/jsp/book/insertBook.jsp";

	}
}
