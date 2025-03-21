package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCHKShopping.service.goods.GoodsDetailService;
import jspMVCHKShopping.service.goods.GoodsVisitCountService;
import jspMVCHKShopping.service.item.GoodsWishItemService;
import jspMVCHKShopping.service.item.GoodsWishService;

public class ItemFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command =  requestURI.substring(contextPath.length());
		if(command.equals("/detailView.item")) {
			System.out.println("제품상세보기");
			// 조회수 증가
			GoodsVisitCountService action2 = new GoodsVisitCountService();
			action2.execute(request);
			//  상품만 조회
			GoodsDetailService action = new GoodsDetailService();
			action.execute(request);
			// 찜 조회
			GoodsWishService action1 = new GoodsWishService();
			action1.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/detailView.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/wishItem.item")) {
			GoodsWishItemService action = new GoodsWishItemService();
			action.execute(request);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {		
		doProcess(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {	
		doProcess(req,resp);
	}
}






