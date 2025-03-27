package cookieTest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookieTest.model.dao.LoginDAO;

public class MainFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/")) {
			System.out.println("main");
			
			Cookie [] cookies = req.getCookies(); // 브라우저에 있는 쿠키 모두 불러오기
			if(cookies != null && cookies.length > 0){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("member")){
						System.out.println("아이디 전달");
						req.setAttribute("member", cookie.getValue());
					}
					if(cookie.getName().equals("auto")) {
						LoginDAO dao = new LoginDAO();
						String memberPw = dao.authSelect(cookie.getValue());
						if(memberPw != null) {
							HttpSession session = req.getSession();
							session.setAttribute("auth", cookie.getValue());
						}
					}
				}
			}
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		}
	}
}