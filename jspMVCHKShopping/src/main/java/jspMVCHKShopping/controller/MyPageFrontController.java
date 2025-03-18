package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCHKShopping.service.employee.EmployeeModifyService;
import jspMVCHKShopping.service.member.MemberUpdateService;
import jspMVCHKShopping.service.my.EmployeeInfoService;
import jspMVCHKShopping.service.my.EmployeePwUpdateService;
import jspMVCHKShopping.service.my.MemberDetailService;
import jspMVCHKShopping.service.my.MemberPwUpdateService;

public class MyPageFrontController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberMyPage.my")) {
			System.out.println("내정보");
			
			
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/myPage/memberMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberUpdate.my")) {
			System.out.println("회원 정보 수정");
			MemberDetailService action = new MemberDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/myPage/myModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberModify.my")) {
			MemberUpdateService action = new MemberUpdateService();
			int i = action.execute(request);
			if(i == 1)// 비밀번호가 일치하면 
				response.sendRedirect("memberMyPage.my");
			else { // 비밀번호가 일치하지 않으면
				MemberDetailService action1 = new MemberDetailService();
				action1.execute(request);
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/myPage/myModify.jsp");
				dispatcher.forward(request, response);
			}
		}else if(command.equals("/memberPwUpdate.my")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/myNewPw.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberPwPro.my")) {
			MemberPwUpdateService action = new MemberPwUpdateService();
			int i = action.execute(request);
			if(i == 1)
				response.sendRedirect("memberMyPage.my");
			else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/myPage/myNewPw.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		else if(command.equals("/empMyPage.my")) {
			EmployeeInfoService action = new EmployeeInfoService();
			action.execute(request);			
			
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("myPage/employeeMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empUpdate.my")) {
			EmployeeInfoService action = new EmployeeInfoService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("myPage/empModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empModify.my")) {
			EmployeeModifyService action = new EmployeeModifyService();
			int i = action.execute(request);
			if(i == 1) response.sendRedirect("empMyPage.my");
			else {
				EmployeeInfoService action1 = new EmployeeInfoService();
				action1.execute(request);
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/myPage/empModify.jsp");
				dispatcher.forward(request, response);
			}
		}else if(command.equals("/empPwModify.my")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/myPage/empNewPw.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empPwPro.my")) {
			EmployeePwUpdateService action = new EmployeePwUpdateService();
			int i = action.execute(request);
			if(i == 1)
				response.sendRedirect("empMyPage.my");
			else {
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/myPage/empNewPw.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
}
