package jspMVCHKShopping.service;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class MemberInfoService {
	public void execute(HttpServletRequest request) {
		String memberNum = request.getParameter("memberNum");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberSelectOne(memberNum);
		request.setAttribute("dto", dto);
	}
}
