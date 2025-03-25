package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCHKShopping.service.goods.GoodsDetailService;
import jspMVCHKShopping.service.goods.GoodsVisitCountService;
import jspMVCHKShopping.service.item.CartInsertService;
import jspMVCHKShopping.service.item.CartListService;
import jspMVCHKShopping.service.item.GoodsItemService;
import jspMVCHKShopping.service.item.GoodsOrderService;
import jspMVCHKShopping.service.item.GoodsWishItemService;
import jspMVCHKShopping.service.item.GoodsWishService;
import jspMVCHKShopping.service.item.INIstdpayPcReturnService;
import jspMVCHKShopping.service.item.IniPayReqService;

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
		}else if(command.equals("/cart.item")) {
			CartInsertService action = new CartInsertService();
			action.execute(request);
		}else if(command.equals("/cartList.item")) {
			CartListService action = new CartListService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/cartList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/itemBuy.item")) {
			GoodsItemService action = new GoodsItemService();
			action.execute(request);
			System.out.println("구매페이지");
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/goodsOrder.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsOrder.item")) {
			// itemBuy.item에서 넘어온 값을 purchase에 저장
			GoodsOrderService action = new GoodsOrderService();
			String purchaseNum = action.execute(request);
			
			response.sendRedirect("paymentOk.item?purchaseNum="+purchaseNum);
		}else if(command.equals("/paymentOk.item")) {
			IniPayReqService action = new IniPayReqService();
			try {
				action.execute(request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/payment.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/INIstdpay_pc_return.item")) {
			INIstdpayPcReturnService action = 
					new INIstdpayPcReturnService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/buyfinished.jsp");
			dispatcher.forward(request, response);
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






