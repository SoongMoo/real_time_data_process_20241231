package jspMVCHKShopping.service.employee;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.EmployeeDAO;

public class EmployeeAutoNumService {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		String empNum = dao.empAutoNum();
		request.setAttribute("empNum", empNum);
	}
}
