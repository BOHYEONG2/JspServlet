package kr.ac.kopo.controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class SearchBookProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
        HttpSession session = request.getSession();

        BookVO book = new BookVO();
        book.setTitle(title);

        BookDAO dao = new BookDAO();
        List<BookVO> bookList = dao.searchBook(book);

        String msg = "";
        request.setAttribute("bookList", bookList);
        msg = "검색된 내역입니다.";

        return "/jsp/book/searchBook.jsp";
    }
}
