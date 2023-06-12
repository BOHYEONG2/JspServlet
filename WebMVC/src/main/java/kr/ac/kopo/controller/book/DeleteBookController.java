package kr.ac.kopo.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class DeleteBookController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bookNo = Integer.parseInt(request.getParameter("no"));

        // BookVO 객체 생성 및 bookNo 설정
        BookVO book = new BookVO();
        book.setNo(bookNo);

        // BookDAO 생성 및 책 삭제 메서드 호출
        BookDAO bookDAO = new BookDAO();
        bookDAO.deleteBook(book);

        // 도서 삭제 후 다시 도서 목록 페이지로 리다이렉트
        response.sendRedirect("getBookList.do");

        return null;
}
}