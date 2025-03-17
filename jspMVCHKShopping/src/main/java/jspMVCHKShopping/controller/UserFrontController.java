package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCHKShopping.service.user.UserWriteService;

public class UserFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/userAgree.nhn")) {
			System.out.println("회원규약");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/user/userAgree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userWrite.nhn")) {
			System.out.println("가입페이지");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/user/userForm.jsp");
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/userWrite.nhn")) {
			UserWriteService action = new UserWriteService();
			action.execute(request);
			response.sendRedirect(contextPath);
		}
	}
}











