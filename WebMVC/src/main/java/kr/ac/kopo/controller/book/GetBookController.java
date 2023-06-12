package kr.ac.kopo.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.book.BookDAO;
import kr.ac.kopo.book.BookVO;
import kr.ac.kopo.framework.Controller;

public class GetBookController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터로 전달된 도서번호 가져오기
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));

		// BookVO 객체 생성 및 도서번호 설정
		BookVO book = new BookVO();
		book.setNo(bookNo);
		
		// BookDAO 생성
		BookDAO bookDAO = new BookDAO();

		// 도서 조회 메서드 호출하여 도서 정보 가져오기
		BookVO result = bookDAO.getBook(book);

		// 도서 정보를 request 속성에 저장
		request.setAttribute("book", result);

		
		
		return null;
	}
}
