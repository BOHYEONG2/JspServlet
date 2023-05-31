package ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTestServlet2
 */
@WebServlet("/CookieTestServlet2") // 이 값이 uri로 들어오면 밑에 클래스  CookieTestServlet2 이것을 실행시킨다
public class CookieTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTestServlet2() {	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)		
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 브라우저에 나오는거 입력 출력 인코딩 디코딩 문자셋 설정
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		// 출력 HTML 파일 만들기 위한 out 인스턴스 생성
		PrintWriter out = response.getWriter();
		
		// jsp가 돌떄 쿠키가 있는지 확인하고 있으면  쿠키를 설정하는 기능
		
		// 브라우저로부터 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		// 쿠키가 있는지 확인
		if(cookies != null)
		{
			// 쿠키가 있으면
			for(Cookie cookie : cookies)
			{
				// 출력
				out.println("cookie : " +cookie.getName()+":"+cookie.getValue()+"<br/>");
			}
		}
		// name과 value 입력받는 html 폼 생성 
		out.println("<form method='post' action='CookieTestServlet2'>"); // 폼을 제출할 때 action='CookieTestServlet2'는 폼 데이터가 전송될 서블릿을 지정합니다.
		out.println("name<input type='text' name='name'/> ");
		out.println("value<input type='text' name='value'/> ");
		out.println("<input type='submit'/> ");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 브라우저에 나온 name value를 쿠키에 저장
		// 폼에서 POST로 요청이 오면 
		// request에서 submit해서 보낸 name과 value를 추출
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		
		//쿠키로 저장
		Cookie c = new Cookie(name, value);
		response.addCookie(c);
		
		// 서블릿을 doGet으로 리다이렉션
		response.sendRedirect("CookieTestServlet2"); // 다시 보내는거 
	}

}
