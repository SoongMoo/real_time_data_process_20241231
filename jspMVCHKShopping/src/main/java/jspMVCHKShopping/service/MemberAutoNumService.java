package jspMVCHKShopping.service;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.MemberDAO;

public class MemberAutoNumService {
	public void execute(HttpServletRequest request) {
		MemberDAO dao = new MemberDAO();
		String memberNum = dao.selectAutoNum();
		request.setAttribute("memberNum", memberNum);
	}
}
