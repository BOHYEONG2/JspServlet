package kr.ac.kopo.controller.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class GetBookListController implements Controller {

	@Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 BookVO vo = new BookVO();
		 BookDAO bookDAO = new BookDAO();
        
        // 도서 목록 조회
        List<BookVO> bookList = bookDAO.getBookList(vo);
        
        
        // 조회된 도서 목록을 request에 저장
        request.setAttribute("bookList", bookList);
        
        // bookList.jsp로 forward
        return "/jsp/book/getBookList.jsp";
	}       
}
