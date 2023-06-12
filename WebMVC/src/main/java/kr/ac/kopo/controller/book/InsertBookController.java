package kr.ac.kopo.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class InsertBookController implements Controller  {

		@Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
        return "/jsp/book/insertBook.jsp";
	
	 }
}