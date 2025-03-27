package cookieTest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cookieTest.service.LoginService;

public class LoginFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/logout.hk")) {
			Cookie cookie = new Cookie("auto", "");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
			
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(contextPath);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/login.hk")) {
			System.out.println("로그인");
			
			// session만들기 위한 service
			LoginService action = new LoginService();
			action.execute(req, resp);
			resp.sendRedirect(contextPath);
		}
	}
}