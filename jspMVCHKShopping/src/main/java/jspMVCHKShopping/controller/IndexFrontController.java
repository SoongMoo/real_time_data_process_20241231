package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.UserDAO;
import jspMVCHKShopping.service.goods.GoodsListService;

public class IndexFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command =  requestURI.substring(contextPath.length());
		if(command.equals("/")) {
			GoodsListService action = new GoodsListService();
			action.execute(request);
			Cookie [] cookies = request.getCookies();
			if(cookies != null && cookies.length >0) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("storeId")) {
						request.setAttribute("sid", cookie.getValue());
					}
					if(cookie.getName().equals("keepLogin")) {
						UserDAO dao = new UserDAO(); 
						AuthInfoDTO auth = dao.loginSelectOne(cookie.getValue());
						HttpSession session = request.getSession();
						session.setAttribute("auth", auth);
					}
				}
			}
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}





