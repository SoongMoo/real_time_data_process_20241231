package jspMVCHKShopping.service.employee;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.EmployeeDAO;

public class EmployeeDeleteService {
	public void execute(HttpServletRequest request) {
		String empNum = request.getParameter("num");
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeDelete(empNum);		
	}
}
