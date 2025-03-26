package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.service.member.LoginService;

public class LoginFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/logout.login")) { // 로그아웃
			Cookie cookie = new Cookie("keepLogin", "");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.invalidate();  // 모든 session 삭제
			response.sendRedirect(contextPath);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/login.login")) {
			System.out.println("로그인");
			LoginService action = new LoginService();
			int i = action.execute(request, response); // i : 0 / 1
			if(i == 1)                                          
				response.sendRedirect(contextPath);
			else {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
