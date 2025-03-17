package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCHKShopping.service.member.MemberAutoNumService;
import jspMVCHKShopping.service.member.MemberDeleteService;
import jspMVCHKShopping.service.member.MemberInfoService;
import jspMVCHKShopping.service.member.MemberListService;
import jspMVCHKShopping.service.member.MemberUpdateService;
import jspMVCHKShopping.service.member.MemberWriteService;

public class MemberFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/jspMVCHKShopping/memberList.mem : url
		//                      <------------------------------> :uri
		//                      <--------------->
		String requestURI = request.getRequestURI();
		//   /jspMVCHKShopping/memberList.mem
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberList.mem")) {
			System.out.println("회원리스트");
			
			MemberListService action = new MemberListService();
			action.execute(request);
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberWrite.mem")) {
			System.out.println("회원등록");
			MemberAutoNumService action = new MemberAutoNumService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDetail.mem")) {
			
			MemberInfoService action = new MemberInfoService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberModify.mem")) {
			MemberInfoService action = new MemberInfoService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/member/memberUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberDelete.mem")) {
			MemberDeleteService action = new MemberDeleteService();
			action.execute(request);
			response.sendRedirect("memberList.mem");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberWrite.mem")) {
			MemberWriteService action = new MemberWriteService();	
			action.execute(request);
			response.sendRedirect("memberList.mem");
		}else if(command.equals("/memberModify.mem")) {
			MemberUpdateService action = new MemberUpdateService();
			action.execute(request);
			response.sendRedirect("memberDetail.mem?memberNum="+request.getParameter("memberNum"));
		}
	}
	
}






