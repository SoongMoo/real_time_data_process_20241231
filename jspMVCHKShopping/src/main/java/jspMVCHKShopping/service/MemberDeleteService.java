package jspMVCHKShopping.service;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.MemberDAO;

public class MemberDeleteService {
	public void execute(HttpServletRequest request) {
		String memberNum = request.getParameter("memberNum");
		MemberDAO dao = new MemberDAO();
		dao.memberDelete(memberNum);
	}
}
