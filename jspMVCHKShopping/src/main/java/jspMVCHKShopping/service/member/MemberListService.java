package jspMVCHKShopping.service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class MemberListService {
	public void execute(HttpServletRequest request) {
		MemberDAO dao =  new MemberDAO();
		List<MemberDTO> list = dao.memberSelectAll();
		request.setAttribute("list", list);
	}
}
