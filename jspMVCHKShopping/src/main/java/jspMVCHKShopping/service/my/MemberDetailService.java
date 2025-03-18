package jspMVCHKShopping.service.my;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jspMVCHKShopping.model.AuthInfoDTO;
import jspMVCHKShopping.model.MemberDAO;
import jspMVCHKShopping.model.MemberDTO;

public class MemberDetailService {
	public void execute(HttpServletRequest request) {
		// 회원정보를 알기 위해서는 회원번호 또는 아이디
		// session에 아이디가 존재한다.
		HttpSession session = request.getSession();
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		String memberId = auth.getUserId();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberSelectOne(memberId);
		request.setAttribute("dto", dto);
	}
}
