package jspMVCHKShopping.service.employee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.EmployeeDAO;
import jspMVCHKShopping.model.EmployeeDTO;

public class EmployeeListService {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> list = dao.selectAll();
		request.setAttribute("dtos", list);
	}
}
