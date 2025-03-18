package jspMVCHKShopping.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspMVCHKShopping.service.employee.EmployeeAutoNumService;
import jspMVCHKShopping.service.employee.EmployeeDeleteService;
import jspMVCHKShopping.service.employee.EmployeeDetailService;
import jspMVCHKShopping.service.employee.EmployeeJoinService;
import jspMVCHKShopping.service.employee.EmployeeListService;
import jspMVCHKShopping.service.employee.EmployeeModifyService;

public class EmployeeFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/employeeList.emp")) {
			EmployeeListService action = new EmployeeListService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("employee/employeeList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeWrite.emp")) {
			EmployeeAutoNumService action =
					new EmployeeAutoNumService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("employee/employeeForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeDetail.emp")) {
			EmployeeDetailService action =
					new EmployeeDetailService();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("employee/employeeDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeUpdate.emp")) {
			EmployeeDetailService action =
					new EmployeeDetailService();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("employee/employeeModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeDelete.emp")) {
			EmployeeDeleteService action = new EmployeeDeleteService();
			action.execute(request);
			response.sendRedirect("employeeList.emp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/employeeRegist.emp")) {
			EmployeeJoinService action = 
					new EmployeeJoinService();
			action.execute(request);
			response.sendRedirect("employeeList.emp");
		}else if(command.equals("/employeeModify.emp")) {
			EmployeeModifyService action = new EmployeeModifyService();
			action.execute(request);
			response.sendRedirect("employeeDetail.emp?num=" +
							request.getParameter("empNum"));
		}
	}
}
