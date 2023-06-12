package kr.ac.kopo.controller.book;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class SearchBookController implements Controller {

	@Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		  try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	      String title = request.getParameter("title");
	      BookVO book = new BookVO();
	      book.setTitle(title);
	      
	      BookDAO bookDAO = new BookDAO();
	      List<BookVO> bookList = bookDAO.searchBook(book);
	      
	      request.setAttribute("bookList", bookList);
	      
	      return "/jsp/book/searchBook.jsp";
	      
	   }

	   
	   
	}
	
	

