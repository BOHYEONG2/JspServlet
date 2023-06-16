package kr.ac.kopo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	  // service에서도 써야하기 때문에 멤버변수로 객체를 만들어줌
	private HandlerMapping mappings;
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		mappings = new HandlerMapping();
	      // init메소드는 서버가 구동될 때 처음 요청할 때에 딱 한번만 실행된다
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // 클라이언트의 요청은 request로 날아온다 클라이언트의 요청 URI를 받아오는 메소드
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length()); // 주소창에서 /MyBanking/login.do 에서 MyBanking이 안나오게 하고싶어서 짜른다
			
			Controller ctrl = mappings.getController(uri); // << 이게 디스패쳐와 핸들링맵핑 왔다갔다 하는거
			String callPage = ctrl.handleRequest(request, response);  // 요건 컨트롤러부분 호출하는거
			//System.out.println("jsp : " + callPage);
			
			if(callPage.startsWith("redirect:")) {
				
				response.sendRedirect(callPage.substring("redirect:".length()));
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response); 
		
	}

	
	}
}
