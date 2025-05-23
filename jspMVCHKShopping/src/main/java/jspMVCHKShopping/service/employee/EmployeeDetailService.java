package jspMVCHKShopping.service.employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.EmployeeDAO;
import jspMVCHKShopping.model.EmployeeDTO;

public class EmployeeDetailService {
	public void execute(HttpServletRequest request) {
		String empNum = request.getParameter("num");
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.selectOne(empNum);
		request.setAttribute("dto", dto);
	}
}
