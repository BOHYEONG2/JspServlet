package kr.ac.kopo.framework;

import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.controller.LoginController;
import kr.ac.kopo.controller.LoginProcessController;
import kr.ac.kopo.controller.LogoutController;
import kr.ac.kopo.controller.MainController;
import kr.ac.kopo.controller.MyBooksController;
import kr.ac.kopo.controller.MyPageController;
import kr.ac.kopo.controller.UpdateInfoController;
import kr.ac.kopo.controller.UpdateInfoProcessController;
import kr.ac.kopo.controller.book.DeleteBookController;
import kr.ac.kopo.controller.book.GetBookController;
import kr.ac.kopo.controller.book.GetBookListController;
import kr.ac.kopo.controller.book.InsertBookController;
import kr.ac.kopo.controller.book.InsertBookProcessController;
import kr.ac.kopo.controller.book.RentBookController;
import kr.ac.kopo.controller.book.ReturnBookController;
import kr.ac.kopo.controller.book.SearchBookController;
import kr.ac.kopo.controller.book.SearchBookProcessController;
import kr.ac.kopo.controller.user.CheckDuplicateIdController;
import kr.ac.kopo.controller.user.DeleteUserController;
import kr.ac.kopo.controller.user.DeleteUserProcessController;
import kr.ac.kopo.controller.user.InsertUserController;
import kr.ac.kopo.controller.user.InsertUserProcessController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/insertUserProcess.do", new InsertUserProcessController());
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/main.do", new MainController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());	
		mappings.put("/loginProcess.do", new LoginProcessController());
			
		mappings.put("/insertBook.do", new InsertBookController());
		mappings.put("/insertBookProcess.do", new InsertBookProcessController());
		mappings.put("/getBook.do", new GetBookController());
		mappings.put("/getBookList.do", new GetBookListController());	
		mappings.put("/searchBook.do", new SearchBookController());
		mappings.put("/searchBookProcess.do", new SearchBookProcessController());
		mappings.put("/rentBook.do", new RentBookController());
		mappings.put("/returnBook.do", new ReturnBookController());
		mappings.put("/deleteBook.do", new DeleteBookController());	
		mappings.put("/deleteUser.do", new DeleteUserController());	
		mappings.put("/deleteUserProcess.do", new DeleteUserProcessController());	
		
		mappings.put("/checkduplicateid.do", new CheckDuplicateIdController());
		mappings.put("/mypage.do", new MyPageController());
		mappings.put("/myBooks.do", new MyBooksController());
		mappings.put("/updateInfo.do", new UpdateInfoController());
		mappings.put("/updateInfoProcess.do", new UpdateInfoProcessController());
		
		
		
			
		
	}

	public Controller getController(String uri) {
		return mappings.get(uri);
	}
}
