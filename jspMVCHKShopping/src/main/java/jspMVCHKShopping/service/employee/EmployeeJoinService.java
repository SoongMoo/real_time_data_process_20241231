package jspMVCHKShopping.service.employee;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.EmployeeDAO;
import jspMVCHKShopping.model.EmployeeDTO;

public class EmployeeJoinService {
	public void execute(HttpServletRequest request) {
		try {
			// 한글 깨짐 방지
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		String empNum = request.getParameter("empNum");
		String empName = request.getParameter("empName");
		String empId = request.getParameter("empId");
		String empPw = request.getParameter("empPw");
		String empAddr = request.getParameter("empAddr");
		String empAddrDetail = request.getParameter("empAddrDetail");
		String empPost = request.getParameter("empPost");
		String empPhone = request.getParameter("empPhone");
		String empJumin = request.getParameter("empJumin");
		String empEmail = request.getParameter("empEmail");
		String empHireDate = request.getParameter("empHireDate");
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(empAddr);
		dto.setEmpAddrDetail(empAddrDetail);
		dto.setEmpEmail(empEmail);
		dto.setEmpId(empId);
		dto.setEmpJumin(empJumin);
		dto.setEmpName(empName);
		dto.setEmpNum(empNum);
		dto.setEmpPhone(empPhone);
		dto.setEmpPost(empPost);
		dto.setEmpPw(empPw);
		dto.setEmpHireDate(empHireDate);
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeInsert(dto);
	}
}









