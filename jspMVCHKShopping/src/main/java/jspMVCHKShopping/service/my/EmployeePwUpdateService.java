package jspMVCHKShopping.service.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.EmployeeDAO;
import jspMVCHKShopping.model.MemberDAO;

public class EmployeePwUpdateService {
	public int execute(HttpServletRequest request) {
		String oldPw = request.getParameter("oldPw");
		String newPw = request.getParameter("newPw");
		
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		String empId = auth.getUserId();
		int i;
		if(oldPw.equals(auth.getUserPw())) {
			EmployeeDAO dao = new EmployeeDAO();
			dao.employeePwUpdate(empId, newPw);
			auth.setUserPw(newPw);
			i = 1;
		}else {
			request.setAttribute("pwErr","비밀번호가 틀렸습니다.");
			i = 0;
		}
		return i;
	}
}
